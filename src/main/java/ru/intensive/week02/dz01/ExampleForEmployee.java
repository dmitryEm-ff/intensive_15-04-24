package ru.intensive.week02.dz01;

import java.util.Arrays;

public class ExampleForEmployee {

    private static final Employee[] employeeArray = new Employee[5];

    static {
        employeeArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "+79219219221", 30000, 30);
        employeeArray[1] = new Employee("Petrov Petr", "DevOps", "petr@mailbox.com", "+79219212112", 60000, 41);
        employeeArray[2] = new Employee("Sidorov Sidr", "Programmer", "sidr@mailbox.com", "+79210210202", 45000, 37);
        employeeArray[3] = new Employee("Ivanova Maria", "Counter", "masha@mailbox.com", "+79214321515", 50000, 25);
        employeeArray[4] = new Employee("Petrova Alexandra", "Director", "alexand@mailbox.com", "+79210234567", 90000, 55);
    }

    public static void main(String[] args) {
        Arrays.stream(employeeArray).filter(e -> e.getAge() > 40).forEach(System.out::println); //2 Employees

/*        for (Employee e : employeeArray) {
            if (e.getAge() > 40) {
                System.out.println(e);
            }
        }
 */
    }
}
