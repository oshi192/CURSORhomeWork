import Util.ScannerUtil;
import workshop.CabinInterface;
import workshop.EngineInterface;
import workshop.parts.*;

import java.util.ArrayList;

    class Rocket implements SpaceTravel{
    private CabinInterface cabin;
    private ArrayList<EngineInterface> engines;
    private long distance;
    private long destination;
    private float velocity;
    private int time,time1,time2;


    void setEngine(EngineVariants ev, FuelTanksVariants ftv) {
        engines.add(new Engine(ev,ftv));
    }
    void setCabin(CabinVariants cv){
        cabin=new Cabin(cv);
    }


    void displayInfo(){
        System.out.println("velocity: "+velocity+"\ttime: "+(time/(24*3600))+"\ttimeTo1: "+(time1/(24*3600))
                +"\ttimeTo2: "+(time2/(24*3600))+"\tdistance: "+(distance/1000));
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    float run(){
        float a=velocity;
        velocity+=0.001*powerSum()/getRocketMass();
        time++;
        if(velocity>7900 && time1==0)time1=time;
        if(velocity>11200 && time2==0)time2=time;
        distance+=velocity;
        return velocity-a;
    }

    float getVelocity(){
        return velocity;
    }

    long getDistance(){
        return distance;
    }

    private int getRocketMass(){
        int mass=0;
        for(EngineInterface ev:engines){
            mass+=ev.getMass();
        }
        mass+=cabin.getMass();
        return mass;
    }
    private int powerSum(){
        int power=0;
        for(EngineInterface ev:engines){
            power+=ev.getMass();
        }
        return power;
    }

    private void fly(){
            while(run()!=0);
        System.out.println(destination);
            if(getVelocity()>11200){
                while(getDistance()<destination){
                   run();
                }
            }else{
                System.out.println("Sory but we cannot leave Earth in this Rocket, try to build another one");
            }
        displayInfo();
    }

    public void install(){  //instal engines to rocket and set Distance
        do{
            engines= new ArrayList<>();
            do{
                destination=ScannerUtil.setDistance();
            }while(destination==0);
            setCabin(CabinVariants.findCabin(ScannerUtil.checkAnswer(1,5,3)));
            int y=ScannerUtil.checkAnswer(3,5,4);
            for(int i=0;i<y;i++){
                EngineVariants ev =EngineVariants.findEngine(ScannerUtil.checkAnswer(1,5,1));
                FuelTanksVariants ftv=FuelTanksVariants.findFuelTank(ScannerUtil.checkAnswer(1,5,2));
                while(ftv.width>ev.weight || ftv.height>ev.height){
                    System.out.println("FuelTank is too big: choose another one: smallr od equal height:"+ev.height+" width"+ev.width);
                    ftv=FuelTanksVariants.findFuelTank(ScannerUtil.checkAnswer(1,5,2));
                }
                setEngine(ev,ftv );
            }
            fly();        //start flying
        }while(ScannerUtil.checkStartApp());


        }

}
