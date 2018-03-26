
public enum PlanetDistances {
    MOON("MOON",0.0025),VENUS("VENUS",0.27),MERCURY("MERCURY",0.6),MARS("MARS",0.52),
    SUN("SUN",1),JUPITER("JUPITER",4.18),SATURN("SATURN",8.51),URANUS("URANUS",18.14),
    NEPTUNE("NEPTUNE",29),PLUTO("PLUTO",39),CENTEROFGALAXY("CENTEROFGALAXY",1638000000);
    public double distance;
    public String name;
    PlanetDistances(String name,double distance)
    {
        this.name=name;
        this.distance=distance;
    }

    public static boolean asMyEnum(String str) {
        for (PlanetDistances d : PlanetDistances.values()) {
            if (d.name.equals(str))
                return true;
        }
        return false;
    }
}
