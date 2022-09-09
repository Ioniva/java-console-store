package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ScannerUtils {
    static Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    public static int showIntRangeInput(int fromNumber, int toNumber) {
        System.out.print("Escribe un numero (del " + fromNumber + " al " + toNumber + "): ");
        return scanner.nextInt();
    }

    public static String showStringInput(String text){
        String input;
        boolean wentomatch = false;
        do {
            System.out.print(text + " ");
            input = scanner.next();
            if (input.matches(".*([';]+|(--)+).*")){
                System.err.println("¡Se han introducido caracteres ilegales!");
            } else {
                wentomatch = true;
            }
        } while (!wentomatch);
        return input;
    }

    public static int showIntInput(String text){
        int input;
        do {
            System.out.print(text + " ");
            input = scanner.nextInt();
        } while (input < 0);
        return input;
    }

    public static double showDoubleInput(String text){
        double input;
        do {
            System.out.print(text + " ");
            input = scanner.nextDouble();
        } while (input < 0);
        return input;
    }

    public static Date showDateInput(String text) {
        String input;
        Date date = null;
        try {
            System.out.print(text + " ");
            input = scanner.next();
            date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(input);
        } catch (Exception e){
            e.printStackTrace();
        }
        return date;
    }
}

