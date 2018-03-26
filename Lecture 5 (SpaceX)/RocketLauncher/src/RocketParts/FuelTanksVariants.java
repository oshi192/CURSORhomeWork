package RocketParts;

public enum FuelTanksVariants {
    FT1(1,"alpha",20,3,1000,5000),FT2(2,"betta",25,3,2000,10000),FT3(3,"gama",30,4,3000,12000),
    FT4(4,"delta",35,4,3000,15000),FT5(5,"ipsilon",40,5,5000,20000);
    public final String name;
    public final int  id;
    public final int  height;
    public final int  width;
    public final int  weight;
    public final int  capacity;

    FuelTanksVariants(int id,String name,int  height, int  width, int  weight, int  capacity){
        this.name=name;
        this.id =id;
        this.capacity   =capacity;
        this.height =height;
        this.weight =weight;
        this.width  =width;
    }
    public static void displayFuelTanksVariants(){

        System.out.println("\n\tfuel tank variants:\n");
        System.out.println("#\tname\theight\twidth\tweight\tcapacity");
        System.out.println("-----------------------------------------");
        for (FuelTanksVariants ftv : FuelTanksVariants.values()) {
            System.out.println(""+ftv.id+":\t"+ftv.name+"\t"+ftv.height+"\t"+ftv.width+"\t"+ftv.weight+"\t"+ftv.capacity);
        }
    }

    public static FuelTanksVariants findFuelTank(int n){
        for (FuelTanksVariants e : FuelTanksVariants.values()) {
            if (e.id == n) {
                return e;
            }
        }
        return null;
    }
}
