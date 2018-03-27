package rocket.parts;

public enum CabinVariants implements CabinInterface {
    C1(1,"a0",8,3,15000,5),C2(2,"b3",6,2,12000,3),C3(3,"a2",8,3,20000,5),C4(4,"c3",10,4,25000,8),C5(5,"ff",12,4,26000,10);
    public final String name;
    public final int  id;
    public final int  height;
    public final int  width;
    public final int  weight;
    public final int  capacity;
    CabinVariants(int id,String name,int height,int  width,int  weight,int  capacity)
    {
        this.name=name;
        this.id=id;
        this.height=height;
        this.width=width;
        this.weight=weight;
        this.capacity=capacity;
    }
    public static void displayCabinVariants(){
        System.out.println("\n\tcabin Variants:\n");
        System.out.println("#\tname\theight\twidth\tweight\tcapacity");
        System.out.println("-----------------------------------------");
        for (CabinVariants cv : CabinVariants.values()) {
            System.out.println(""+cv.id+":\t"+cv.name+"\t"+cv.height+"\t"+cv.width+"\t"+cv.weight+"\t"+cv.capacity);
        }
    }

    public static CabinVariants findCabin(int n){
        for (CabinVariants e : CabinVariants.values()) {
            if (e.id == n) {
                return e;
            }
        }
        return null;
    }
    public int getMass(){
        return weight;
    }
}
