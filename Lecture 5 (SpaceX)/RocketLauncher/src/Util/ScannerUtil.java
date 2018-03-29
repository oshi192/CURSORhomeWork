package Util;

import workshop.parts.CabinVariants;
import workshop.parts.EngineVariants;
import workshop.parts.FuelTanksVariants;

import java.util.Scanner;

public class ScannerUtil {

    private static Scanner sc;

    private ScannerUtil() throws IllegalStateException {
        throw new IllegalStateException("Can't create instance of Util.ScannerUtil");
    }

    private static Scanner getScanner() {
        if (sc == null) {
            sc = new Scanner(System.in);
        }
        return sc;
    }

    public static boolean checkStartApp() {
        String s;
        System.out.println("\none more time?\ny- yes\tn-no\n");
        do {
            s = getScanner().nextLine();
            if (!("y".equalsIgnoreCase(s) || "n".equalsIgnoreCase(s))) {
                System.out.println("invalid answer try y or n");
            }
        } while (!("y".equalsIgnoreCase(s) || "n".equalsIgnoreCase(s)));
        return (s.equalsIgnoreCase("y")) ? true : false;
    }

    public static int checkAnswer(int min, int max, int type) {   //alidation answers in menu
        if (type == 1) { EngineVariants.displayEngineVariants();}
        if (type == 2) { FuelTanksVariants.displayFuelTanksVariants();}
        if (type == 3) { CabinVariants.displayCabinVariants();}
        if (type == 4) { System.out.print("number of engines from 3 to 5 :");}
        return checkNumber(min,max);
    }

    private static int checkNumber(int min, int max){
        String s;
        int answer;
        System.out.print("\nchose your option: ");
        do {
            while (!(getScanner().hasNextInt())) {
                do {                            // to skip empty lines //
                    s = getScanner().nextLine();
                } while (s.equals(""));
                System.out.println("it is not a number, try again \n");
            }
            answer = getScanner().nextInt();
            if (answer < min || answer > max){
                System.out.println("invalid number , try again :\nchose your option: ");
            }
        } while (answer < min || answer > max);
        return answer;
    }

}
