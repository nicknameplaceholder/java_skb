package src;

public class Converter {

    public static int distance(int steps) {
        return (int) (steps*0.75);
    }

    public static double kkalBurned(int steps) {
        return (double) (steps * 50)/1000;
    }
}
