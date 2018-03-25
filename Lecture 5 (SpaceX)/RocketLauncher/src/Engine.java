public class Engine  implements FuelProvider{
    private int  height;
    private int  width;
    private int  weight;
    private int  power;
    private int  fuelConsumption;
    private int  fuelTankSpace;
//    private int  acceleration1;
//    private int  acceleration2;
    private FuelTank fuelTank;
    Engine(EngineVariants ev, FuelTanksVariants ftv){
    height  = ev.height;
    width   = ev.width;
    weight  = ev.weight;
    power   = ev.power;
    fuelConsumption = ev.fuelConsumption;
    fuelTankSpace   = ev.fuelTankSpace;
    fuelTank= new FuelTank(ftv) {
        @Override
        boolean dFuel(int consulum) {
            this.capacity-=consulum;
            if(this.capacity>0)return true;
            else return false;
        }
    };
    }

    @Override
    public int burnFuel() {
        if(fuelTank.dFuel(fuelConsumption))
        return power*10000/weight;
        else return 0;
    }

    private abstract class FuelTank{
        private int  height;
        private int  width;
        private int  weight;
        public  int  capacity;
        FuelTank(FuelTanksVariants ftv){
            height  = ftv.height;
            width   = ftv.width;
            weight  = ftv.weight;
            capacity  = ftv.capacity;
        }
        abstract boolean dFuel(int consulum);
    }

    public void displayInfo(int i){
        System.out.println("engine:"+i);
        System.out.println("height\twidth\tweight\tpower\tfuelConsumption\tfuelTankSpace");
        System.out.println(""+height + "\t\t" + width + "\t\t" + weight + "\t" + power + "\t\t" + fuelConsumption + "\t\t\t" + fuelTankSpace + "\t");
        System.out.println("FuelTank:"+i);
        System.out.println("height\twidth\tweight\tcapacity");
        System.out.println(""+fuelTank.height + "\t\t" + fuelTank.width + "\t\t" + fuelTank.weight + "\t" + fuelTank.capacity );
        System.out.println("---------------------------------------------------------------");
    }


}
