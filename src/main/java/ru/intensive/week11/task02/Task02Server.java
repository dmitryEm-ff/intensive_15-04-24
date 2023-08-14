package ru.intensive.week11.task02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task02Server {
    private static final int PORT = 1234;
    private List<ClientHandler> clients = new CopyOnWriteArrayList<>();
    private ExecutorService executorService = Executors.newCachedThreadPool();

    public Task02Server() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Сервер запущен!");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler client = new ClientHandler(clientSocket, this);
                clients.add(client);
                executorService.execute(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
            System.out.println("Сервер остановлен!");
        }
    }

    public void sendMessageToAllClients(String msg, ClientHandler sender) {
        for (ClientHandler c : clients) {
            if (c != sender) {
                c.sendMsg(msg);
            }
        }
    }

    public void removeClient(ClientHandler client) {
        clients.remove(client);
    }

    public static void main(String[] args) {
        Task02Server task02Server = new Task02Server();
    }
}
