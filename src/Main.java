import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true) {
            printMenu();
            int choise = scanner.nextInt();
            switch (choise) {
                case 1:
                    System.out.println("Вы выбрали Пункт 1.");
                    break;
                case 2:
                    System.out.println("Вы выбрали Пункт 2.");
                    break;
                case 3:
                    System.out.println("Вы выбрали Пункт 3.");
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неправильный выбор. Пожалуйста, попробуйте снова.");
                    break;
            }
        }



    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определенный день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Показать траты по категориям");
    }

}