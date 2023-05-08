package ru.intensive.week04;

interface Printable {
    String print();
}

public class AnonymousPrintable implements Printable {
    @Override
    public String print() {
        return "Print message!";
    }

    public void displayMessage(Printable p) {
        System.out.println(p.print() + " Anonymous");
    }

    public static void main(String[] args) {
        AnonymousPrintable ap = new AnonymousPrintable();
        System.out.println(ap.print());

        ap.displayMessage(new Printable() {
            @Override
            public String print() {
                return "Hello!";
            }
        });
    }
}
