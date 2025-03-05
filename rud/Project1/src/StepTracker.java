package rud.Project1.src;

import java.util.HashMap;

public class StepTracker {

    int defaultMission = 10000;
    HashMap<Integer, MonthData> monthToData = new HashMap<>();

    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    public void addStepsByDay(int dayOfMonth, int monthOfYear, int steps) {
        MonthData monthMonthData = monthToData.get(monthOfYear);
        monthMonthData.monthData[dayOfMonth - 1] = steps;
        monthToData.put(monthOfYear, monthMonthData);
        System.out.println("Значения сохранены.");
    }

    public void changeDefaultMission(int newDefaultMission) {

        if (newDefaultMission >= 0) {
            defaultMission = newDefaultMission;
            System.out.println("Новая цель - " + defaultMission + " шагов!" + "\n");
        } else {
            System.out.println("Значение не изменилось так как вы ввели отрицательное значение." +
                    " Текущее значение - '" + defaultMission + "'." + "\n");
        }
    }

    void statistics(int input) {
        int sum = 0;
        int maxStepCounter = 0;
        int bestSeries = 0;
        int series = 0;

        // Количество пройденных шагов по дням.
        MonthData month = monthToData.get(input);
        int[] stepPerDay = month.monthData;
        System.out.println("Статистика за " + input + "-й месяц.");
        System.out.println("Количество пройденных шагов по дням: ");
        for (int i = 0; i < stepPerDay.length; i++) {
            System.out.print((i + 1) + " день: " + stepPerDay[i]);
            if (i == stepPerDay.length - 1) {
                System.out.println(".");
            } else {
                System.out.print(", ");
            }
            sum += stepPerDay[i];
            if (stepPerDay[i] > maxStepCounter) {
                maxStepCounter = stepPerDay[i];
            }
            if (stepPerDay[i] >= defaultMission) {
                series++;
                if (series > bestSeries) {
                    bestSeries = series;
                }
            } else {
                series = 0;
            }
        }
        System.out.println("\n");

        // Общее количество шагов за месяц.
        System.out.println("Общее количество шагов за месяц: " + sum + "\n");

        // Максимальное пройденное количество шагов в месяце.
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxStepCounter + "\n");

        // Среднее количество шагов.
        int avgSteps = sum / stepPerDay.length;
        System.out.println("Среднее количество шагов в " + input + "-м месяце: " + avgSteps + "\n");

        // Пройденная дистанция в км.
        System.out.println("Пройденная дистанция (в км): " + Converter.distance(sum) + "\n");

        // Количество сожженных каллорий.
        System.out.println("Количество сожженных каллорий: " + Converter.kkalBurned(sum) + "\n");

        // Лучшая серия.
        System.out.println("Максимальная серия выполненных целей: " + bestSeries + " дней." + "\n");
    }


}
