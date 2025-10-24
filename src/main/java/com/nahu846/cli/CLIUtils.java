package com.nahu846.cli;

import java.math.BigDecimal;
import java.util.Scanner;

public class CLIUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static String prompt(String message) {
        System.out.println(message + ": ");
        return scanner.nextLine();
    }

    public static int promptInt(String message) {
        System.out.println(message + ": ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static Long promptLong(String message) {
        System.out.println(message + ": ");
        return Long.valueOf(scanner.nextLine());
    }

    public static Double promptDouble(String message) {
        System.out.println(message + ": ");
        return Double.valueOf(scanner.nextLine());
    }

    public static BigDecimal promptBigDecimal(String message) {
        System.out.println(message + ": ");
        return BigDecimal.valueOf(promptInt(message));
    }
}
