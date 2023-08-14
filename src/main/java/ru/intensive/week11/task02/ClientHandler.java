package ru.intensive.week11.task02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private Task02Server task02Server;
    private static AtomicInteger clientCounter = new AtomicInteger();
    private Scanner inMessage;
    private PrintWriter outMessage;

    public ClientHandler(Socket clientSocket, Task02Server task02Server) {
        try {
            this.clientSocket = clientSocket;
            this.task02Server = task02Server;
            clientCounter.incrementAndGet();
            this.inMessage = new Scanner(clientSocket.getInputStream());
            this.outMessage = new PrintWriter(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                task02Server.sendMessageToAllClients("Новый участник подключился к чату!", null);
                task02Server.sendMessageToAllClients("Количество участников: " + clientCounter.get(), null);
                break;
            }
            while (true) {
                if (inMessage.hasNext()) {
                    String message = inMessage.nextLine();
                    if (message.equalsIgnoreCase("exit!")) {
                        break;
                    }
                    task02Server.sendMessageToAllClients(message, this);
                }
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            clientCounter.decrementAndGet();
            task02Server.removeClient(this);
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMsg(String msg) {
        outMessage.println(msg);
        outMessage.flush();
    }
}
