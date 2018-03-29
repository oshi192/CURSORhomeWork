import Util.ScannerUtil;
import workshop.parts.CabinVariants;
import workshop.parts.EngineVariants;
import workshop.parts.FuelTanksVariants;

public class RocketInstaller implements SpaceTravel{
    Rocket Falcon;

    private void fly(){
        while(Falcon.run()!=0);
        System.out.println(Falcon.getDestination());
        if(Falcon.getVelocity()>11200){
            while(Falcon.getDistance()<Falcon.getDestination()){Falcon.run();}
        }else{
            System.out.println("Sory but we cannot leave Earth in this Rocket, try to build another one");
        }
        Falcon.displayInfo();
    }

    public void install(){  //instal engines to rocket and set Distance
        do{
            Falcon.CreateNewEngines();
            do{
                Falcon.setDestination();
            }while(Falcon.getDestination()==0);
            Falcon.setCabin(CabinVariants.findCabin(ScannerUtil.checkAnswer(1,5,3)));
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
            Falcon.setEngine(ev,ftv );
        }
    }
}
