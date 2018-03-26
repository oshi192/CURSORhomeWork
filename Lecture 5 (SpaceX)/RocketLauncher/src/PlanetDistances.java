public enum PlanetDistances {
    MOON(0.0025),VENUS(0.27),MERCURY(0.6),MARS(0.52),SUN(1),JUPITER(4.18),SATURN(8.51),URANUS(18.14),NEPTUNE(29),PLUTO(39),CENTEROFGALAXY(1638000000);
    public double distance;
    PlanetDistances(double distance)
    {
        this.distance=distance;
    }

    public static boolean asMyEnum(String str) {
        for (PlanetDistances d : PlanetDistances.values()) {
            if (d.name().equalsIgnoreCase(str))
                return true;
        }
        return false;
    }
}
