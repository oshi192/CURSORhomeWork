public enum DisancePlanets {
    //distance to planets in au (from Earth to Sun)
    MERCURY(0.7),VENUS(0.3),EARTH(0),MOON(0.2),MARS(0.8),JUPITER(4.2),SATURN(9),URANUS(19),NEPTUNE(29),PLUTO(39);
    public double distance;
    DisancePlanets(double distance)
    {
           this.distance=distance;
    }
}
