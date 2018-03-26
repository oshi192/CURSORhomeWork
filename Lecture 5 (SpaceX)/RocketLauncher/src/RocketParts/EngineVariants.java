package RocketParts;

public enum EngineVariants implements EngineInterface {
    E1(1,"toddler",25,3,20000,4,100,2000,new FuelTank()),E2(2,"merlyn",30,4,20000,18,300,5000, new FuelTank()),E3(3,"atlon",40,4,40000,16,400,8000, new FuelTank()),
    E4(4,"sirius5",30,4,30000,8,200,5000, new FuelTank()),E5(5,"BigBee",50,5,50000,24,500,10000, new FuelTank());

    public final String name;
    public final int  id;
    public final int  height;
    public final int  width;
    public final int  weight;
    public final int  power;
    public final int  fuelConsumption;
    public final int  fuelTankSpace;
    public FuelTank ft ;
    EngineVariants(int id, String name, int height, int width, int weight, int power, int fuelConsumption, int fuelTankSpace, FuelTank ft)
    {
        this.name=name;
        this.height=height;
        this.width=width;
        this.weight=weight;
        this.power=power;
        this.fuelConsumption=fuelConsumption;
        this.fuelTankSpace=fuelTankSpace;
        this.id = id;
        this.ft = ft;
    }

    public static void displayEngineVariants() {
        System.out.println("\tengine Variants:\n");
        System.out.println("#\tname\theight\twidth\tweight\tpower\tfuelConsumption\tfuelTankSpace");
        System.out.println("-----------------------------------------------------------------------");
        for (EngineVariants ev : EngineVariants.values()) {
            System.out.println("" + ev.id + ":\t" + ev.name + "\t" + ev.height + "\t" + ev.width + "\t" + ev.weight + "\t" + ev.power + "\t" + ev.fuelConsumption + "\t\t" + ev.fuelTankSpace );
        }
    }

    public static EngineVariants findEngine(int n) {
        for (EngineVariants e : EngineVariants.values()) {
            if (e.id == n) {
                return e;
            }
        }
        return null;
    }

    public void setFuelTank(FuelTanksVariants ftv){
        ft.capacity=ftv.capacity;
        ft.width=ftv.width;
        ft.weight=ftv.weight;
        ft.height=ftv.height;
    }
    @Override
    public int  getMass(){
        return weight+ft.getMass();
    }
    @Override
    public int  getPower(){
        ft.capacity-=fuelConsumption;
        return ft.capacity>0?power:0;
    }

}
