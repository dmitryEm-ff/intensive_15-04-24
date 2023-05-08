package ru.intensive.week04;

public class LocalInnerUser {
    void myMethod(){
         String login = "login";
         String password = "password";

        class Query {
            public void printToLog() {
                System.out.printf("User %s, %s send a query.%n", login, password);
            }
        }

        Query inner = new Query();
        inner.printToLog();
    }

    public static void main(String[] args) {
        LocalInnerUser liu = new LocalInnerUser();
        liu.myMethod();
    }
}