import Util.Planets;
import Util.ScannerUtil;
import workshop.CabinProvider;
import workshop.EngineProvider;
import workshop.parts.*;

import java.util.ArrayList;

    class Rocket implements SpaceTravel{
    private CabinProvider cabin;
    private ArrayList<EngineProvider> engines;
    private long distance;
    private long destination;
    private float velocity;
    private int time,time1,time2;

    float run(){
        float a=velocity;
        velocity+=0.001*powerSum()/getRocketMass();
        time++;
        if(velocity>7900 && time1==0)time1=time;
        if(velocity>11200 && time2==0)time2=time;
        distance+=velocity;
        return velocity-a;
    }

    private void fly(){
        while(run()!=0);
        System.out.println(destination);
            if(velocity>11200){
                while(distance<destination){run();}
            }else{
                System.out.println("Sory but we cannot leave Earth in this Rocket, try to build another one");
            }
        displayInfo();
    }

    public void install(){  //instal engines to rocket and set Distance
        do{
            engines= new ArrayList<>();
            do{
                destination=Planets.setDistance();
            }while(destination==0);
            setCabin(CabinVariants.findCabin(ScannerUtil.checkAnswer(1,5,3)));
            addEngine();
            fly();        //start flying
        }while(ScannerUtil.checkStartApp());
    }

    private  void addEngine(){
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
    }
    private int getRocketMass(){
        int mass=0;
        for(EngineProvider ev:engines){
            mass+=ev.getMass();
        }
        mass+=cabin.getMass();
        return mass;
    }

    private int powerSum(){
        int power=0;
        for(EngineProvider ev:engines){
            power+=ev.getMass();
        }
        return power;
    }

    private void setEngine(EngineVariants ev, FuelTanksVariants ftv) {
            engines.add(new Engine(ev,ftv));
    }

    private void setCabin(CabinVariants cv){
            cabin=new Cabin(cv);
    }

    private void displayInfo(){
        System.out.println("velocity: "+velocity+"\ttime: "+(time/(24*3600))+"\ttimeTo1: "+(time1/(24*3600))
        +"\ttimeTo2: "+(time2/(24*3600))+"\tdistance: "+(distance/1000));
    }
}
