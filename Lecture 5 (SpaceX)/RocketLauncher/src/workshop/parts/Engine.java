package workshop.parts;

import workshop.EngineInterface;

public class Engine implements EngineInterface {


    private final int  height;
    private final int  width;
    private final int  weight;
    private final int  power;
    private final int  fuelConsumption;
    private final int  fuelTankSpace;
    private FuelTank ft ;
    public Engine(EngineVariants ev,FuelTanksVariants ftv)
    {
        this.height=ev.height;
        this.width=ev.width;
        this.weight=ev.weight;
        this.power=ev.power;
        this.fuelConsumption=ev.fuelConsumption;
        this.fuelTankSpace=ev.fuelTankSpace;
        this.ft = new FuelTank(ftv);
    }

    private class FuelTank {
        int height;
        int width;
        int weight;
        int capacity;

        FuelTank(FuelTanksVariants ftv) {
            this.height = ftv.height;
            this.weight = ftv.weight;
            this.width = ftv.width;
            this.capacity = ftv.capacity;
        }

        int getWeight() {
            return weight;
        }


    }


    @Override
    public int  getMass(){
        return weight+ft.getWeight();
    }
    @Override
    public int  getPower(){
        ft.capacity-=fuelConsumption;
        return ft.capacity>0?power:0;
    }
}
