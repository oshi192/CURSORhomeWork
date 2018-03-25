public class Rocket {
    private Cabin cabin;
    private Engine e1;
    private Engine e2;
    private Engine e3;
    private Engine e4;
    private Engine e5;
    private long distance;
    private int velocity;
    private int enginesCount;
    private int time,time1,time2;
    Rocket(){
        enginesCount=0;
        velocity=0;
        time=0;
        time1=0;
        time2=0;
        distance=0;
    }

    public void setEngine(EngineVariants ev, FuelTanksVariants ftv) {
        Engine e=new Engine(ev,ftv);
        if(enginesCount==0){
            e1=e;enginesCount++;
        }else if(enginesCount==1){
            e2=e;enginesCount++;
        }else if(enginesCount==2){
            e3=e;enginesCount++;
        }else if(enginesCount==3){
            e4=e;enginesCount++;
        }else {
            e5=e;enginesCount++;
        }
    }
    public void setCabin(CabinVariants cv){
        cabin=new Cabin(cv);
    }

    void displayParameters(){
        cabin.displayInfo();
        e1.displayInfo(1);
        e2.displayInfo(2);
        e3.displayInfo(3);
        if(enginesCount>2){
            e4.displayInfo(4);
        }
        if(enginesCount>3){
            e5.displayInfo(5);
        }
    }

    void displayInfo(){
        System.out.println("velocity: "+velocity+"\ttime: "+time+"\ttimeTo1: "+time1+"\ttimeTo2: "+time2+"\tdistance: "+distance);
    }

    public int run(){
        int a=velocity;
        velocity+=(e1.burnFuel())*15;
        velocity+=(e2.burnFuel())*15;
        velocity+=(e3.burnFuel())*15;
        if(enginesCount>3)velocity+=(e4.burnFuel())*15;
        if(enginesCount>4)velocity+=(e5.burnFuel())*15;
        time++;
        if(velocity>7900&&time1==0)time1=time;
        if(velocity>11200&&time2==0)time2=time;
        distance+=velocity;
        return velocity-a;
    }
    public int getVelocity(){
        return velocity;
    }
    public long getDistance(){
        return distance;
    }


}
