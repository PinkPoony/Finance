import java.util.Scanner;

public class Main {
    public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();
        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                manager.loadMonthlyReports();
                System.out.println("Все отчеты посчитаны");
            } else if (command == 2) {
                manager.loadYearlyReport();
                System.out.println("Годовой отчет посчитан");
            } else if (command == 3) {
                manager.compareOfReports();
            } else if (command == 4) {
                manager.printMonthlyReport();
            } else if (command == 5) {
                manager.printYearlyReport();
            } else if (command == 0) {
                System.out.println("Хорошего дня!");
                break;
            } else {
                System.out.println("К сожалению такого номера команда нет");
                System.out.println("Попробуйте вывести ещё раз");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Добро пожаловать в глваное меню приложения БалансПро");
        System.out.println("Выберите действие: ");
        System.out.println("1 - посчитать все месячные отчёты");
        System.out.println("2 - посчитать годовой отчёт");
        System.out.println("3 - сверить отчёты");
        System.out.println("4 - вывести всю информацию обо всех месячных отчётах");
        System.out.println("4 - вывести информацию о месячном отчёте");
        System.out.println("5 - вывести всю информацию о годовом отчёте");
        System.out.println("0 - выход");
    }
}