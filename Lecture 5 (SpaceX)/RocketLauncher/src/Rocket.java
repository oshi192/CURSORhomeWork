import Util.Planets;
import workshop.CabinProvider;
import workshop.EngineProvider;
import workshop.parts.*;

import java.util.ArrayList;

class Rocket {
    private CabinProvider cabin;
    private ArrayList<EngineProvider> engines;
    private long distance;
    private long destination;
    private float velocity;
    private int time, time1, time2;


    float run() {
        float a = velocity;
        velocity += 0.001 * powerSum() / getRocketMass();
        time++;
        if (velocity > 7900 && time1 == 0) {time1 = time;}
        if (velocity > 11200 && time2 == 0) {time2 = time;}
        distance += velocity;
        return velocity - a;
    }

    public void createNewEngines() {
        engines = new ArrayList<>();
    }

    private int getRocketMass() {
        int mass = 0;
        for (EngineProvider ev : engines) {
            mass += ev.getMass();
        }
        mass += cabin.getMass();
        return mass;
    }

    private int powerSum() {
        int power = 0;
        for (EngineProvider ev : engines) {
            power += ev.getMass();
        }
        return power;
    }

    public void setEngine(EngineVariants ev, FuelTanksVariants ftv) {
        engines.add(new Engine(ev, ftv));
    }

    public void setCabin(CabinVariants cv) {
        cabin = new Cabin(cv);
    }

    public void displayInfo() {
        System.out.println("velocity: " + velocity + "\ttime: " + (time / (24 * 3600)) + "\ttimeTo1: " + (time1 / (24 * 3600))
                + "\ttimeTo2: " + (time2 / (24 * 3600)) + "\tdistance: " + (distance / 1000));
    }

    public void setDestination() {
        this.destination = Planets.setDistance();
    }

    public long getDestination() {
        return destination;
    }

    public float getVelocity() {
        return velocity;
    }

    public long getDistance() {
        return distance;
    }
}
