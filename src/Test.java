import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
    private static final String FUNCTION_REGEX = "^[-]?(([1-9][0-9]*)?x\\^2(([+]|[-])([1-9][0-9]*)?x)?(([+]|[-])[1-9][0-9]*)?)|([1-9][0-9]*)$";

    public static int findA(String wyrazenie) {
        int indeks = wyrazenie.indexOf("x^2");
        if (indeks < 1) {
            return 0;
        }
        return Integer.parseInt(wyrazenie.substring(0, indeks));
    }

    public static int findB(String wyraznie) {
        String wyraznie2 = wyraznie.replaceAll("\\+", "").replaceFirst("x", "a");
        int indeks = wyraznie2.indexOf("a^2");
        int indeks1 = wyraznie2.indexOf("x");
        if (indeks1 < 1) {
            return 0;
        }
        String b = wyraznie2.substring(indeks + 3, indeks1);
        return Integer.parseInt(b);
    }


    public static int findC(String wyraznie) {
        String wyrazenie2 = wyraznie.replaceAll("\\+", "").replaceFirst("x", "a");
        int indeks = wyrazenie2.indexOf("x");
        if (indeks == -1) {
            indeks = wyrazenie2.indexOf("a^2") + 2;
        }
        String c = wyrazenie2.substring(indeks + 1);
        if ("".equals(c)) {
            return 0;
        }
        return Integer.parseInt(c);
    }

    public static void menu() {
        System.out.println("Podaj rownieni - wybierz 1");
        System.out.println("Zakoncz program - wybierz 0");
        System.out.println("Wybierz opcje");
    }

    public static boolean checkRegex(String wyrazenie) {
        return wyrazenie.replaceAll("\\s", "").matches(FUNCTION_REGEX);
    }

    public static void oblicz(Trojmian trojmian, String wyraznie) {
        System.out.print("Rownanie " + wyraznie);
        if (trojmian.czyMaNieskonczonoscRozwiazan()) {
            System.out.println(" ma nieskonczenie wiele rozwiazan");
        } else if (trojmian.rozwiaz()) {
            trojmian.pokazWynik();
        } else {
            System.out.println(" nie ma rozwiazan");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean warunek = true;

        while (warunek) {
            menu();
            try {
                int opcja = scanner.nextInt();
                scanner.nextLine();
                switch (opcja) {
                    case 0:
                        System.out.println("Koniec");
                        warunek = false;
                        break;
                    case 1:
                        System.out.println("Podaj wyrazenie");
                        String wyraznie = scanner.nextLine();
                        if (checkRegex(wyraznie)) {
                            int a = findA(wyraznie);
                            int b = findB(wyraznie);
                            int c = findC(wyraznie);
                            Trojmian trojmian = new Trojmian(a, b, c);
                            oblicz(trojmian, wyraznie);
                        } else {
                            System.out.println("Niepoprawne wyrazenie.");
                        }
                        break;
                    default:
                        System.out.println("To nie jest poprawna wartośc. Miało być 1 albo 0.");
                        break;
                }

            } catch (InputMismatchException ex) {
                System.out.println("To nie jest liczba, sprobuj jeszcze raz");
                scanner.nextLine();

            }
        }
    }
}
