// Yurii Kosakivskyi 23.03.18
// parametrs:
// ---destination point:    MERCURY,VENUS,EARTH,MOON,MARS,JUPITER,SATURN,URANUS,NEPTUNE,PLUTO
//             ---power:    1-40
//              ---mass:    100-1000


public class RocketLauncher {
    public static void main(String[] args) {
       // String[]d={"PLUTO","0","200"};
       Rocket falcon=new Rocket(args);
       falcon.launch();
    }
}
