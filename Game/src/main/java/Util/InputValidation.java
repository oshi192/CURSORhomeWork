package Util;

public class InputValidation {

    private InputValidation() throws IllegalStateException {
        throw new IllegalStateException("Can't create instance of util.ScannerUtil");
    }

    public static boolean checkStartApp() {
        String s;
        System.out.println("\none more time?\ny- yes\tn-no\n");
        do {
            s = Reader.getString();
            if (!("y".equalsIgnoreCase(s) || "n".equalsIgnoreCase(s))) {
                System.out.println("invalid answer try y or n");
            }
        } while (!("y".equalsIgnoreCase(s) || "n".equalsIgnoreCase(s)));
        return ("y".equalsIgnoreCase(s)) ? true : false;
    }

    public static int checkNumber(int min, int max){
        String input;
        System.out.print("\nchose your option: ");
        while(true){
            input=Reader.getString();
            if(input.matches("\\d+")) {
                if (Integer.parseInt(input) >= min && Integer.parseInt(input) <= max) {
                    return Integer.parseInt(input);
                }
            }
            System.out.println("invalid input , try again :\nchose your option: "+min+"-"+max);
        }
    }

}
