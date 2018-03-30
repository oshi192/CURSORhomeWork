package util;


import java.util.Scanner;

public class ScannerUtil {

    private static Scanner sc;

    private ScannerUtil() throws IllegalStateException {
        throw new IllegalStateException("Can't create instance of util.ScannerUtil");
    }

    private static Scanner getScanner() {
        if (sc == null) {
            sc = new Scanner(System.in);
        }
        return sc;
    }
    public static boolean hasIntValue(){return getScanner().hasNextInt();}
    public static int getIntValue(){
        return getScanner().nextInt();
    }
    public static String getStringValue(){
        return  getScanner().nextLine();
    }

}
