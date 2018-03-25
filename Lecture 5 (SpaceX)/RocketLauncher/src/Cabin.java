public class Cabin {
    private int  height;
    private int  width;
    private int  weight;
    private int  capacity;
    Cabin(CabinVariants cv){
        height=cv.height;
        width=cv.width;
        weight=cv.weight;
        capacity=cv.capacity;
    }

    public void displayInfo(){
        System.out.println("\n\tcabin:\n");
        System.out.println("height\twidth\tweight\tcapacity");
        System.out.println("-----------------------------------------");
        System.out.println(""+height+"\t\t"+width+"\t\t"+weight+"\t"+capacity);
    }
}
