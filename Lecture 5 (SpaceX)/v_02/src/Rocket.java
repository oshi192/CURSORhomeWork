public class Rocket {
    private int power;
    private int mass;
    private double distance;
    private Cabin cabin;
    private Nozzle n1;
    private Nozzle n2;
    private Nozzle n3;
    private int velocity;
    private boolean check;
    private Nozzle engine;
    private class Cabin{    // we have cabin with "start" button
        private int mass;    // cabin mass
        Cabin(int m)
        {
            this.mass=m;
            System.out.println("cabin installed");
        }
        public void PressStartButton()
        {
            System.out.println("go");
        }
    }

    Rocket(String[] args){
        validation(args);        // check args[]
        n1=new Nozzle(power,4,new Engine() {
            @Override
            void check() {
                System.out.println("engin - ok");
            }
        });
        n2=new Nozzle(power,4,new Engine() {
            @Override
            void check() {
                System.out.println("engin - ok");
            }
        });
        n3=new Nozzle(power,2,new Engine() {
            @Override
            void check() {
                System.out.println("engin - ok");
            }
        });
        velocity=0;
        cabin=new Cabin(50000);
        if(power==0||mass==0){check=false;System.out.println("error!! mass or power");}
    }

    public void launch(){
        if(check) {
            cabin.PressStartButton();
            int i = 0,d=0;
            while (d < distance) {
                velocity += n1.calculateVelocity();
                velocity += n2.calculateVelocity();
                velocity += n3.calculateVelocity();
                i++;
                d += velocity;
            }
            displayInfo(velocity,i);
        }
    }

    private boolean isNumber (String s)
    {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    private boolean asMyEnum(String str) {
        for (PlanetDisances d : PlanetDisances.values()) {
            if (d.name().equalsIgnoreCase(str))
                return true;
        }
        return false;
    }
    private void displayInfo(int velocity,int i){
        if (velocity > 7900) {
            System.out.println("we leave earth! and ");
            System.out.println("time travel: " + i + "days; final speed : " + velocity / 1000.0 + "km/s");
        } else {
            System.out.println("we havent enough fuel to fly off");
        }
    }

    private void validation(String[]args){
        check=true;
        if(args.length==3){
            if(asMyEnum(args[0])){
                distance=PlanetDisances.valueOf(args[0]).distance*149597;   //*10^3 km
            }else{
                distance=0;
                check=false;
                System.out.println("invalid destination point: "+ args[0]);
                System.out.println("try: MERCURY,VENUS,EARTH,MOON,MARS,JUPITER,SATURN,URANUS,NEPTUNE,PLUTO");
            }
            if(isNumber(args[1])){
                power=Integer.parseInt(args[1])*1000;
            }else{
                power=0;
                System.out.println("invalid input power parameter: "+ args[1]);
                System.out.println("try: some like 10");
            }
            if(isNumber(args[2])){
                mass=Integer.parseInt(args[2])*1000;
            }else{
                mass=0;
                System.out.println("invalid input mass parameter: "+ args[2]);
                System.out.println("try: some like 2000");
            }
        }else{
            System.out.println("invalid input, try to enter 3 parameters,");
            System.out.println("Like: VENUS 100000 2000000");
        }
    }




}
