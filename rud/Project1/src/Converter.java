package src;

public class Converter {

    public static double distance(int steps) {
        return (steps*0.75)/1000;
    }

    public static double kkalBurned(int steps) {
        return (double) (steps * 50)/1000;
    }
}
