
import rocket.parts.*;

public class Rocket {
    private CabinInterface cabin;
    private EngineInterface e1;
    private EngineInterface e2;
    private EngineInterface e3;
    private EngineInterface e4;
    private EngineInterface e5;
    private long distance;
    private float velocity;
    private int enginesCount;
    private int time,time1,time2;
    public Rocket(){
        enginesCount=0;
        velocity=0;
        time=0;
        time1=0;
        time2=0;
        distance=0;
    }

    public void setEngine(EngineVariants ev, FuelTanksVariants ftv) {
        if(enginesCount==0){
            ev.setFuelTank(ftv);e1=ev;enginesCount++;
        }else if(enginesCount==1){
            ev.setFuelTank(ftv);e2=ev;enginesCount++;
        }else if(enginesCount==2){
            ev.setFuelTank(ftv);e3=ev;enginesCount++;
        }else if(enginesCount==3){
            ev.setFuelTank(ftv);e4=ev;enginesCount++;
        }else {
            ev.setFuelTank(ftv);e5=ev;enginesCount++;
        }
    }
    public void setCabin(CabinVariants cv){
        cabin=cv;
    }


    void displayInfo(){
        System.out.println("velocity: "+velocity+"\ttime: "+time+"\ttimeTo1: "+time1+"\ttimeTo2: "+time2+"\tdistance: "+distance);
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public float run(){
        float a=velocity;
        velocity+=4000000*powerSum()*1.f/getRocketMass();
        time++;
        if(velocity>7900 && time1==0)time1=time;
        if(velocity>11200 && time2==0)time2=time;
        distance+=velocity;
        return velocity-a;
    }
    public float getVelocity(){
        return velocity;
    }
    public long getDistance(){
        return distance;
    }

    private int getRocketMass(){
        int mass=0;
        mass+=cabin.getMass();
        mass+=e1.getMass();
        mass+=e2.getMass();
        mass+=e3.getMass();
        if(enginesCount>3){mass+=e4.getMass();}
        if(enginesCount>4){mass+=e5.getMass();}
        return mass;
    }
    private int powerSum(){
        int power=0;
        power+=e1.getPower();
        power+=e2.getPower();
        power+=e3.getPower();
        if(enginesCount>3){power+=e4.getPower();}
        if(enginesCount>4){power+=e5.getPower();}
        return power;
    }

    public int getEnginesCount() {
        return enginesCount;
    }
}
