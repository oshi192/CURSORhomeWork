package util;

import workshop.parts.CabinVariants;
import workshop.parts.EngineVariants;
import workshop.parts.FuelTanksVariants;

public class Check {
    public static boolean checkStartApp() {
        String s;
        System.out.println("\none more time?\ny- yes\tn-no\n");
        do {
            s = ScannerUtil.getStringValue();
            if (!("y".equalsIgnoreCase(s) || "n".equalsIgnoreCase(s))) {
                System.out.println("invalid answer try y or n");
            }
        } while (!("y".equalsIgnoreCase(s) || "n".equalsIgnoreCase(s)));
        return ("y".equalsIgnoreCase(s)) ? true : false;
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

            while (!ScannerUtil.hasIntValue()) {
                do {                            // to skip empty lines //
                    s = ScannerUtil.getStringValue();
                } while (s.equals(""));
                System.out.println("it is not a number, try again \n");
            }
            answer = ScannerUtil.getIntValue();
            if (answer < min || answer > max){
                System.out.println("invalid number , try again :\nchose your option: ");
            }
        } while (answer < min || answer > max);
        return answer;
    }
}
