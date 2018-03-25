import java.util.Scanner;

public class PartInstaller {
    private Rocket Falcon;
    private long distance;
    private static Scanner sc;
    PartInstaller (){
        Falcon=new Rocket();
        sc = new Scanner(System.in);
    }

    public void Install(){  //instal engines to rocket and set Distance
        while(setDistance());
        Falcon.setCabin(findCabin(checkAnswer(1,5,3)));
        int y=checkAnswer(3,5,4);
        for(int i=0;i<y;i++){
            Falcon.setEngine(findEngine(checkAnswer(1,5,1)),findFuelTank(checkAnswer(1,5,2)));
        }
        start();        //start flying
    }

    public void start(){

        while(Falcon.run()!=0);
        if(Falcon.getVelocity()>11200){
            while(Falcon.getDistance()<distance){
                Falcon.run();
            Falcon.displayInfo();}
        }else{
            System.out.println("Sory but we cannot leave Earth in this Rocket, try to build another one");
        }
        Falcon.displayInfo();
    }

    public boolean setDistance(){
        System.out.println("MERCURY,VENUS,EARTH,MOON,MARS,JUPITER,SATURN,URANUS,NEPTUNE,PLUTO,SUN");
        String s=sc.nextLine();
        if(asMyEnum(s)){
            distance=(int)(PlanetDistances.valueOf(s).distance*149597); //set Distance
            System.out.println("distance: "+distance*1000+"km");//*10^3 km
            return false;
        }else{
            System.out.println("invalid destination point: "+ s);
            System.out.println("try: MERCURY,VENUS,EARTH,MOON,MARS,JUPITER,SATURN,URANUS,NEPTUNE,PLUTO");
        }return true;
    }
    private CabinVariants findCabin(int n){
        for (CabinVariants e : CabinVariants.values()) {
            if (e.id == n) {
                return e;
            }
        }
        return null;
    }
    private FuelTanksVariants findFuelTank(int n){
        for (FuelTanksVariants e : FuelTanksVariants.values()) {
            if (e.id == n) {
                return e;
            }
        }
        return null;
    }
    private EngineVariants findEngine(int n) {
        for (EngineVariants e : EngineVariants.values()) {
            if (e.id == n) {
                return e;
            }
        }
        return null;
    }

    private int checkAnswer(int min,int max,int type){   //alidation answers in menu
        if(type==1){EngineVariants.displayEngineVariants();}
        if(type==2){FuelTanksVariants.displayEngineVariants();}
        if(type==3){CabinVariants.displayCabinVariants();}
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

    private boolean asMyEnum(String str) {
        for (PlanetDistances d : PlanetDistances.values()) {
            if (d.name().equalsIgnoreCase(str))
                return true;
        }
        return false;
    }

    public static boolean checkStartApp(){ //in the end we ask - one more time
        String s;
        System.out.println("\none more time?\ny- yes\tn-no\n");
        do {                            // to skip empty lines //
            s= sc.nextLine();
        }while(s.equals(""));
        while(!(s.equals("y")||s.equals("n")||s.equals("Y")||s.equals("N"))) // in case of enter wrong answer //
        {
            System.out.println("\ninvalid answer!! try again: \ny- yes\tn-no\n");
            do {                            // to skip empty lines //
                s= sc.nextLine();
            }while(s.equals(""));
        }
        if(s.equals("y")||s.equals("Y")){
            return true;
        }
        else
        {
            return false;
        }
    }
}
