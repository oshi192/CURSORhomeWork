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
        String input;
        System.out.print("\nchose your option: ");
        while(true){
            input=ScannerUtil.getStringValue();
            if(input.matches("\\d+")) {
                if (Integer.parseInt(input) >= min && Integer.parseInt(input) <= max) {
                    return Integer.parseInt(input);
                }
            }
            System.out.println("invalid input , try again :\nchose your option: "+min+"-"+max);
        }
    }

}
