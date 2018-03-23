public class Nozzle {
    public int fuel;
    private int my_mass;
    private Engine engine;
    public int consumption;

    Nozzle(int power,int k){
        double d=Math.random()*200000+500000;
        this.fuel=(int)d;
        my_mass=500000;
        engine=new Engine() {
            @Override
            void check() {
                System.out.println("engin - ok");
            }
        };
        engine.check();
        consumption=power/k;
    }

    public void run(){
        if(fuel>0){
            fuel=engine.on(fuel,consumption/4);
        }
    }

    public int massStage(){
        return fuel+my_mass;
    }
}
