package pol.Project1.src;

import java.util.HashMap;
import java.util.Scanner;

public class StepTracker {
    private static int stepsGoal = 10000;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int DAYS_PER_MONTH = 30;
    private static final HashMap<String, int[]> stepsData = new HashMap<>();
    private static final String[] MONTHS = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль",
            "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};

    static {
        for (String month : MONTHS) {
            stepsData.put(month, new int[DAYS_PER_MONTH]);
        }
    }


    public static void addStepsByDay(String month, int day, int steps) {
        if (stepsData.containsKey(month) && (0 < day && day <= 30) && steps > 0) {
            stepsData.get(month)[day - 1] = steps;
        } else {
            System.out.println("Проверьте введённые данные");
        }
    }

    public static void displayStatisticByMonth(String month) {
        int totalSteps = 0;
        int maxSteps = 0;
        double averageSteps;
        double burntCalories;
        double totalDistance;
        int bestGoalReachSeries = 0;
        int currentSeries = 0;


        if (stepsData.containsKey(month)) {
            int[] currentMonth = stepsData.get(month);
            for (int i = 0; i < currentMonth.length; i++) {
                System.out.println((i + 1) + "день: " + currentMonth[i]);
                totalSteps += currentMonth[i];
                if (currentMonth[i] > maxSteps) {
                    maxSteps = currentMonth[i];
                }
                if (currentMonth[i] >= stepsGoal) {
                    currentSeries++;
                    if (bestGoalReachSeries < currentSeries) {
                        bestGoalReachSeries = currentSeries;
                    }

                } else {
                    currentSeries = 0;
                }
            }

            averageSteps = (double) totalSteps / DAYS_PER_MONTH;
            burntCalories = Converter.stepsToKilocalories(totalSteps);
            totalDistance = Converter.stepsToKilometers(totalSteps);
            System.out.println("Текущая цель: " + stepsGoal);
            System.out.println("Общее количество шагов за месяц: " + totalSteps);
            System.out.println("Максимальное пройденное количество шагов в месяце: " + maxSteps);
            System.out.println("Среднее количество шагов: " + averageSteps);
            System.out.println("Пройденная дистанция (в км): " + totalDistance);
            System.out.println("Количество сожжённых килокалорий: " + burntCalories);
            System.out.println("Лучшая серия: " + bestGoalReachSeries);
        } else {
            System.out.println("Проверьте введённые данные");
        }
    }

    public static void changeStepsGoal() {
        System.out.println("Введите новую цель:");
        int newGoal = SCANNER.nextInt();
        if (newGoal < 0) {
            System.out.println("Цель не может быть меньше 0!");
        } else {
            stepsGoal = newGoal;
        }
    }
}
