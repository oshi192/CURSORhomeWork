

public class Rocket {

    private int fuel;       // fuel in this rocket
    private double speed;   // current speed
    private Stage stage1;   // we can instal 3 stages maximum  first stage
    private Stage stage2;   //  second stage
    private Stage stage3;   //  third stage
    public int stages;      //  count installed stages
    public long distance;   //  calculate flyed distance

    private class Cabin{    // we have cabin with "start" button
        public int mass;    // cabin mass
        Cabin(int mass)
        {
            this.mass=mass;
        }
        public void PressButton()
        {
            System.out.println("go");
        }
    }
    private Cabin cabin;
    Rocket(int fuel){
        this.fuel=fuel;
        speed=0;
        distance=0;
        int f;
        stages=0;
        if(fuel>410000){
            f=410000;
            this.fuel-=410000;
            stages++;
        }else{
            f=this.fuel;
            if(this.fuel>0)stages++;
            this.fuel=0;
        }
        stage1=new Stage(f,3246,110000,stages);
        if(fuel>1100000){
            f=1100000;
            this.fuel-=1100000;
            stages++;
        }else{
            f=this.fuel;
            if(this.fuel>0)stages++;
            this.fuel=0;
        }
        stage2=new Stage(f,3246*2,300000,stages);
        if(fuel>3500000){
            f=3500000;
            this.fuel-=3500000;
            stages++;
        }else{
            f=this.fuel;
            if(this.fuel>0)stages++;
            this.fuel=0;

        }
        stage3=new Stage(f,3246*4,500000,stages);
        cabin=new Cabin(50000);
        System.out.println("cabin installed");
        System.out.println("Rocket mass: "+calculateMass());
    }

    public void start(){
        cabin.PressButton();
    }
    public void flying(){
        if(stage3.installed)
        {
            stage3.run();
            if(!stage3.installed)stages--;
            calculateVelocity(stage3.consumption);
        }else if(stage2.installed){
            stage2.run();
            if(!stage2.installed)stages--;
            calculateVelocity(stage2.consumption);
        }else if(stage1.installed){
            stage1.run();
            if(!stage1.installed)stages--;
            calculateVelocity(stage1.consumption);
        }else{
            calculateVelocity(0);
        }
    }


    private int calculateMass()
    {
        return stage1.getAllMass()+stage2.getAllMass()+stage3.getAllMass()+cabin.mass;
    }
    public void calculateVelocity(int c){
        speed+=c*8500.d/calculateMass();
        distance+=speed;
    }
    public double getSpeed(){
        return  speed;
    }
    public String toString(){
        return " stages :"+stages+"\t speed: "+speed+"\tdistance: "+distance+"\tmass: "+calculateMass()+"\t| instaled: "+stage1.installed+" "+stage2.installed+" "+stage3.installed+"\n";
    }


}
