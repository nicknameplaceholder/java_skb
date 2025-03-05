package rud.Project1.src;

import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);
    private final static StepTracker stepTracker = new StepTracker();


    public static void main(String[] args) {


        while(true) {
            printMenu();
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    enterNumberOfStepsByDay();
                    break;
                case 2:
                    printStatistic();
                    break;
                case 3:
                    changeGoal();
                    break;
                case 0:
                    exitApp();
                    scanner.close();
                    return;
                default:
                    System.out.println("Неправильный выбор. Пожалуйста, попробуйте снова.");
                    break;
            }
        }
    }

    private static void enterNumberOfStepsByDay() {
        System.out.println("Вы выбрали Пункт 1." + "\n" + "Введите количество шагов.");
        int step = scanner.nextInt();
        System.out.println("За какой месяц вы хотите ввести шаги? Введите число от 1 до 12.");
        int monthOfYear = scanner.nextInt();
        System.out.println("За какое число вы хотите ввести шаги? Введите число от 1 до 30.");
        int day = scanner.nextInt();
        if (step >= 0 && monthOfYear >= 1 && monthOfYear <= 12 && day >= 1 && day <= 30) {
            stepTracker.addStepsByDay(day, monthOfYear, step);
        } else {
            System.out.println("Вы ввели некорректные данные. Пожалуйста, проверьте шаги и дату." + "\n" +
                    "Вы ввели - Шаги: " + step + "\n" + "День: " + day + "\n" + "Месяц: " + monthOfYear + "\n");

        }
    }

    private static void printStatistic() {
        System.out.println("Вы выбрали Пункт 2." + "\n" + "Введите месяц от 1 до 12.");
        int month = scanner.nextInt();
        stepTracker.statistics(month);
    }

    private static void changeGoal() {
        System.out.println("Вы выбрали Пункт 3." + "\n" + "Введите новую цель по количеству шагов в день.");
        int newGoal = scanner.nextInt();
        stepTracker.changeDefaultMission(newGoal);
    }

    private static void exitApp() {
        System.out.println("Вы выбрали Пункт 0." + "\n" + "Выход." + "\n" + "Программа завершена, всего хорошего!");
        System.exit(0);
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определенный день.");
        System.out.println("2 - Напечатать статистику за определённый месяц.");
        System.out.println("3 - Изменить цель по количеству шагов в день.");
        System.out.println("0 - Выход из программы.");
    }

}