package RocketParts;

public interface EngineInterface {

    static class FuelTank{
        int  height;
        int  width;
        int  weight;
        int  capacity;
        FuelTank(FuelTanksVariants ftv){
            this.height=ftv.height;
            this.weight=ftv.weight;
            this.width=ftv.width;
            this.capacity=ftv.capacity;
        }
        FuelTank(){

        }

        public int getCapacity() {
            return capacity;
        }

        public int getMass() {
            return weight+capacity;
        }
    }
    int getMass();
    int getPower();


}
