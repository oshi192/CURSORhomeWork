import Util.Check;
import workshop.parts.CabinVariants;
import workshop.parts.EngineVariants;
import workshop.parts.FuelTanksVariants;

public class RocketInstaller implements SpaceTravel{
    private Rocket falcon;
    RocketInstaller(){
        falcon=new Rocket();
    }

    private void fly(){
        while(falcon.run()!=0);
        System.out.println(falcon.getDestination());
        if(falcon.getVelocity()>11200){
            while(falcon.getDistance()<falcon.getDestination()){falcon.run();}
        }else{
            System.out.println("Sory but we cannot leave Earth in this Rocket, try to build another one");
        }
        falcon.displayInfo();
    }

    public void install(){  //instal engines to rocket and set Distance
        do{
            falcon.createNewEngines();
            do{
                falcon.setDestination();
            }while(falcon.getDestination()==0);
            falcon.setCabin(CabinVariants.findCabin(Check.checkAnswer(1,5,3)));
            addEngine();
            fly();        //start flying
        }while(Check.checkStartApp());
    }

    private  void addEngine(){
        int y=Check.checkAnswer(3,5,4);
        for(int i=0;i<y;i++){
            EngineVariants ev =EngineVariants.findEngine(Check.checkAnswer(1,5,1));
            FuelTanksVariants ftv=FuelTanksVariants.findFuelTank(Check.checkAnswer(1,5,2));
            while(ftv.width>ev.weight || ftv.height>ev.height){
                System.out.println("FuelTank is too big: choose another one: smallr od equal height:"+ev.height+" width"+ev.width);
                ftv=FuelTanksVariants.findFuelTank(Check.checkAnswer(1,5,2));
            }
            falcon.setEngine(ev,ftv );
        }
    }
}
