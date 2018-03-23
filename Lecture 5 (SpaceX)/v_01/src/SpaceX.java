
/*  if you want to start use this 2 parameters:                                     */
/*     first  - fuel (example - 2000000)                                            */
/*     second - destination point                                                   */
/*     (example: MERCURY,VENUS,EARTH,MOON,MARS,JUPITER,SATURN,URANUS,NEPTUNE,PLUTO) */

/*     the rocket has a limited tank volume so                                      */
/*     if we enter more fuel than we can use - we don't use the rest of it          */
//     refuel the stage, if there is more fuel we install next stage and refuel it too

/*  enum DisancePlanets                                                 */
/*  interface I_BurningFuel                                             */
/*  abstract class Engine implements I_BurningFuel                      */
/*  class Stage use Engine object                                       */
/*  class Rocket use Stage objects                                      */
/*  class SpaceX use Rocket object                                      */




public class SpaceX {
    public static void main(String[] args) {
        Rocket falcon;
        if (args.length > 0) {
            if (isNumber(args[0])) {                            //check if we have a number
                falcon = new Rocket(Integer.parseInt(args[0])); //if we have first argument we have a fuel and we build the rocket
            } else {
                System.out.println("start failed\ninvalid first parametr, try to enter a number");
                return;
            }
        } else {
            System.out.println("no Enaf fuel!! we can not start!");
            return;
        }

        DisancePlanets destination;
        if (args.length > 1) {
            if(asMyEnum(args[1])) {
                destination = DisancePlanets.valueOf(args[1]); //if we have second argument - we have a destination point
            }else{
                System.out.println("start failed\ninvalid destination point, some like that: ");
                System.out.println("MERCURY,VENUS,EARTH,MOON,MARS,JUPITER,SATURN,URANUS,NEPTUNE,PLUTO");
                return;
            }
        } else {
            destination = DisancePlanets.valueOf("EARTH"); //if we havnt - we stay on EARTH
            System.out.println("we havnt the destination point");
        }
        int time = 0;   //to count time of travelling
                        //3..2..1..
        falcon.start(); //start

        while (falcon.distance / 1000 < 149000 * destination.distance) {
            time++;
            falcon.flying();
        }
        //when fuel ends, we look at velocity
        if (falcon.getSpeed() < 7900) {
            System.out.println("no enough fuel to fly off the Earth");
        } else if (falcon.getSpeed() < 11200) {
            System.out.println("we leave the Earth, but we havent enough fuel to fly to another planet");
        } else {
            System.out.println(falcon.toString());
            System.out.println("final speed = " + (int) falcon.getSpeed() + " m/s\tto destination point : " + time / 86 + " days");
        }
    }

    public static boolean isNumber (String s)
    {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public static boolean asMyEnum(String str) {
        for (DisancePlanets me : DisancePlanets.values()) {
            if (me.name().equalsIgnoreCase(str))
                return true;
        }
        return false;
    }
}

