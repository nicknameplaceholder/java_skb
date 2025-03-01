import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int command;
        while ((command = displayMenu(scanner)) != 0) {
            if (command == 1) {
                System.out.println("Введите месяц:");
                String month = scanner.next();
                System.out.println("Введите день:");
                int day = scanner.nextInt();
                System.out.println("Введите количество шагов:");
                int steps = scanner.nextInt();
                StepTracker.addStepsByDay(month, day, steps);
            } else if (command == 2) {
                System.out.println("Введите месяц:");
                String month = scanner.next();
                StepTracker.displayStatisticByMonth(month);
            } else if (command == 3) {
                StepTracker.changeStepsGoal();
            } else {
                System.out.println("Такой опции нет!");
            }
        }
    }

    public static int displayMenu(Scanner scanner) {
        System.out.println("Опции: ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
        return scanner.nextInt();
    }

}
