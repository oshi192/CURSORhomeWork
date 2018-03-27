import rocket.parts.CabinVariants;
import rocket.parts.EngineVariants;
import rocket.parts.FuelTanksVariants;

import java.util.Scanner;

public class PartInstaller {
    private Rocket Falcon;
    private long distance;
    private static Scanner sc;
    PartInstaller (){
        Falcon=new Rocket();
        sc = new Scanner(System.in);
        distance=0;
    }
    public static void sTtart(){
        do{
            new PartInstaller().install();
        }while(ScannerUtil.checkStartApp());
    }

    public void install(){  //instal engines to rocket and set Distance
        while(ScannerUtil.setDistance()==0);
        Falcon.setCabin(CabinVariants.findCabin(ScannerUtil.checkAnswer(1,5,3)));
        int y=ScannerUtil.checkAnswer(3,5,4);
        for(int i=0;i<y;i++){
            EngineVariants ev =EngineVariants.findEngine(ScannerUtil.checkAnswer(1,5,1));
            FuelTanksVariants ftv=FuelTanksVariants.findFuelTank(ScannerUtil.checkAnswer(1,5,2));
            while(ftv.width>ev.weight || ftv.height>ev.height){
                System.out.println("FuelTank is too big: choose another one: smallr od equal height:"+ev.height+" width"+ev.width);
                ftv=FuelTanksVariants.findFuelTank(ScannerUtil.checkAnswer(1,5,2));
            }
            Falcon.setEngine(ev,ftv );
        }
        fly();        //start flying
    }

    private void fly(){

        while(Falcon.run()!=0);
        if(Falcon.getVelocity()>11200){
            while(Falcon.getDistance()<distance){
                Falcon.run();
            }
        }else{
            System.out.println("Sory but we cannot leave Earth in this Rocket, try to build another one");
        }
        Falcon.displayInfo();
    }

}
