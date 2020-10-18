public class Trojmian {
    private double a;
    private double b;
    private double c;
    private double delta;
    private double x1;
    private double x2;

    public Trojmian(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean rozwiaz() {
        delta = (b * b) - 4 * a * c;
        if (delta > 0) {
            x1 = (-b + Math.sqrt(delta)) / (2 * a);
            x2 = (-b - Math.sqrt(delta)) / (2 * a);

            return true;
        } else if (a == 0 && b == 0) {
            return true;
        } else if (delta == 0) {
            x2 = x1 = -b / (2 * a);
            return true;
        }
        return false;
    }

    public boolean czyMaNieskonczonoscRozwiazan() {
        return a == 0 && b == 0;
    }

    public void pokazWynik() {
        if (x1 == x2) {
            System.out.println(" ma jedno rozwiaznie " + x1);
        } else {
            System.out.println(" ma dwa rozwiazania x1=" + x1 + " x2=" + x2);
        }
    }
}
