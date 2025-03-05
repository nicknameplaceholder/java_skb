package pol.Project1.src;

public class Converter {
    private static final int STEP_LENGTH_CM = 75;
    private static final int CALORIES_PER_STEP = 50;

    public static double stepsToKilometers(int steps) {
        return (double) (steps * STEP_LENGTH_CM) / 100000;
    }

    public static double stepsToKilocalories(int steps) {
        return (double) (steps * CALORIES_PER_STEP) / 1000;
    }

}
