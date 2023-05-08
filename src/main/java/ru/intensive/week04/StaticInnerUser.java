package ru.intensive.week04;

public class StaticInnerUser {
    static class Query {
        public void printToLog(String login, String password) {
            System.out.printf("User %s, %s send a query.%n", login, password);
        }
    }

    public static void main(String[] args) {
        StaticInnerUser.Query nested = new StaticInnerUser.Query();
        nested.printToLog("testLogin1", "testPassword1");
    }
}
