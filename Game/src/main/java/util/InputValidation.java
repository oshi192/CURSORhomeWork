package util;

public class InputValidation {

    private InputValidation() throws IllegalStateException {
        throw new IllegalStateException("Can't create instance of util.ScannerUtil");
    }

    public static int getNumber(int min, int max) {
        String input;
        System.out.print("\nchose your option: ");
        while (true) {
            input = Reader.getString();
            if (input.matches("\\d+")) {
                if (Integer.parseInt(input) >= min && Integer.parseInt(input) <= max) {
                    return Integer.parseInt(input);
                }
            }
            System.out.println("invalid input , try again :\nchose your option: " + min + "-" + max);
        }
    }

}
