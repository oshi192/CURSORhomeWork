public enum EngineVariants {
    E1(1,"toddler",10,2,20000,4,100,2000),E2(2,"merlyn",30,4,20000,18,300,5000),E3(3,"atlon",40,4,40000,16,400,8000),
    E4(4,"sirius5",25,4,30000,8,200,5000),E5(5,"BigBee",50,5,50000,24,500,10000);

    public final String name;
    public final int  id;
    public final int  height;
    public final int  width;
    public final int  weight;
    public final int  power;
    public final int  fuelConsumption;
    public final int  fuelTankSpace;
     EngineVariants(int id,String name,int height, int width, int weight, int power, int fuelConsumption, int fuelTankSpace)
    {
        this.name=name;
        this.height=height;
        this.width=width;
        this.weight=weight;
        this.power=power;
        this.fuelConsumption=fuelConsumption;
        this.fuelTankSpace=fuelTankSpace;
        this.id=id;
    }

    public static void displayEngineVariants() {
        System.out.println("\tengine Variants:\n");
        System.out.println("#\tname\theight\twidth\tweight\tpower\tfuelConsumption\tfuelTankSpace");
        System.out.println("-----------------------------------------------------------------------");
        for (EngineVariants ev : EngineVariants.values()) {
            System.out.println("" + ev.id + ":\t" + ev.name + "\t" + ev.height + "\t" + ev.width + "\t" + ev.weight + "\t" + ev.power + "\t" + ev.fuelConsumption + "\t\t" + ev.fuelTankSpace );
        }
    }
}
