package util;

public enum Planets {
    MOON(0.0025),VENUS(0.27),MERCURY(0.6),MARS(0.52),
    SUN(1),JUPITER(4.18),SATURN(8.51),URANUS(18.14),
    NEPTUNE(29),PLUTO(39),CENTEROFGALAXY(1638000000);
    public double distance;

    Planets(double distance)
    {
        this.distance=distance;
    }

    public static boolean asMyEnum(String str) {
        for (Planets d : Planets.values()) {
            if (d.name().equals(str))
                return true;
        }
        return false;
    }

    public static long setDistance(){

        long distance=0;
        System.out.println("MERCURY,VENUS,EARTH,MOON,MARS,JUPITER,SATURN,URANUS,NEPTUNE,PLUTO,SUN");
        String s=ScannerUtil.getStringValue();
        if(Planets.asMyEnum(s)){
            distance=(int)(Planets.valueOf(s).distance*149597); //set Distance
            System.out.println("distance: "+distance*1000+"km");//*10^3 km
        }else{
            System.out.println("invalid destination point: "+ s);
            System.out.println("try: MERCURY,VENUS,EARTH,MOON,MARS,JUPITER,SATURN,URANUS,NEPTUNE,PLUTO");
        }
        return distance*1000;
    }
}
