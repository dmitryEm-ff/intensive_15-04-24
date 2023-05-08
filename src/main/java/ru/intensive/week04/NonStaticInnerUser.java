package ru.intensive.week04;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class NonStaticInnerUser {
    private String login;
    private String password;

    private void createQuery() {
        new Query().printToLog(login, password);
    }

    private class Query {
        public void printToLog(String login, String password) {
            System.out.printf("User %s, %s send a query.%n", login, password);
        }
    }

    public static void main(String[] args) {
        NonStaticInnerUser nsiu = new NonStaticInnerUser("testLogin1", "testPassword1");
        nsiu.createQuery();

        new NonStaticInnerUser().new Query().printToLog("testLogin2", "testPassword2");
    }
}