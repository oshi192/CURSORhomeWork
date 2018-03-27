import rocket.parts.CabinVariants;
import rocket.parts.EngineVariants;
import rocket.parts.FuelTanksVariants;

import java.util.Scanner;

public class ScannerUtil {
    private static Scanner sc=new Scanner(System.in);

    private ScannerUtil() throws IllegalStateException {
        throw new IllegalStateException("Can't create instance of ScannerUtil");
    }

    public static boolean checkStartApp(){
        String s;
        System.out.println("\none more time?\ny- yes\tn-no\n");
        do {
            s= sc.nextLine();
            if(!("y".equalsIgnoreCase(s)||"n".equalsIgnoreCase(s))){
                System.out.println("invalid answer try y or n");
            }
        }while(!("y".equalsIgnoreCase(s)||"n".equalsIgnoreCase(s)));
        if(s.equals("y")||s.equals("Y")){
            return true;
        }
        else
        {
            return false;
        }
    }

    public static int checkAnswer(int min,int max,int type){   //alidation answers in menu
        if(type==1){
            EngineVariants.displayEngineVariants();}
        if(type==2){
            FuelTanksVariants.displayFuelTanksVariants();}
        if(type==3){
            CabinVariants.displayCabinVariants();}
        if(type==4){
            System.out.print("number of engines from 3 to 5 :");
        }
        String s;
        int answer;
        System.out.print("\nchose your option: ");
        do
        {
            while(!(sc.hasNextInt()))
            {
                do {                            // to skip empty lines //
                    s= sc.nextLine();
                }while(s.equals(""));
                System.out.println("it is not a number, try again \n");
            }
            answer=sc.nextInt();
            if(answer <min || answer > max)		// if we enter option more than 3 or less //
            {						                    // than 1, we display this message        //
                System.out.println("invalid number , try again :\n");
                System.out.println("chose your option: \n");
            }
        }while (answer <min || answer > max);
        return answer;
    }

    public static long setDistance(){
        long distance;
        System.out.println("MERCURY,VENUS,EARTH,MOON,MARS,JUPITER,SATURN,URANUS,NEPTUNE,PLUTO,SUN");
        String s=sc.nextLine();
        if(PlanetDistances.asMyEnum(s)){
            distance=(int)(PlanetDistances.valueOf(s).distance*149597); //set Distance
            System.out.println("distance: "+distance*1000+"km");//*10^3 km
            return distance;
        }else{
            System.out.println("invalid destination point: "+ s);
            System.out.println("try: MERCURY,VENUS,EARTH,MOON,MARS,JUPITER,SATURN,URANUS,NEPTUNE,PLUTO");
        }return 0;
    }
}
