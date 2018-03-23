public class Nozzle {
    private int fuel;
    private int my_mass;
    private Engine engine;
    private int consumption;

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

    private void run(){
        if(fuel>0){
            fuel=engine.on(fuel,consumption/4);
        }
    }

    public int calculateVelocity(){
        run();
        if(fuel > 0){
            return consumption * 3000 / massStage();
        }else{
            return 0;
        }
    }
    private int massStage(){
        return fuel+my_mass;
    }
}
