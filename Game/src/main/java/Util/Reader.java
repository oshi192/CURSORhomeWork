package Util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Reader {
    private static FileReader fin;
    private static Scanner sc;

    private Reader() throws IllegalStateException {
        throw new IllegalStateException("Can't create instance of util.ScannerUtil");
    }

    public static FileReader getFileReader(String s) throws FileNotFoundException {
        if (fin == null) {
            return new FileReader("/main/resources/" + s + ".txt");
        }
        return fin;
    }

    public static Scanner getScanner(){
        if(sc==null){
            return new Scanner(System.in);
        }
        return sc;
    }

    public static String getString(){
        return  getScanner().nextLine();
    }

    public static int getInt(){
        return  getScanner().nextInt();
    }

}
