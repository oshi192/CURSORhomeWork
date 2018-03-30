import workshop.parts.CabinVariants;
import workshop.parts.EngineVariants;
import workshop.parts.FuelTanksVariants;

public interface SpaceTravel {
    float run();
    void createNewEngines();
    void setDestination();
    long getDestination();
    float getVelocity();
    long getDistance();
    void displayInfo();
    void setCabin(CabinVariants cv);
    void setEngine(EngineVariants ev, FuelTanksVariants ftv);
}
