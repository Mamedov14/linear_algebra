package ru.vsu;

public class Integral {
    public static double integralRectangle(double a, double b, Function function) {
        double area = 0;
        double h = 0.001;
        for (int i = 0; i < (b - a) / h; i++) {
            area += h * function.setFunction(a + i * h);
        }
        return area;
    }

    public static double integralTrapezoid(double a, double b, Function function) {
        double area = 0;
        double h = 0.001;
        for (int i = 0; i < (b - a) / h; i++) {
            area += h * (0.5 * (function.setFunction(a + i * h) + function.setFunction(a + (i + 1) * h)));
        }
        return area;
    }
}
