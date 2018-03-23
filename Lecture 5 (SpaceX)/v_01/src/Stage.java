public  class Stage {
    private Engine engine;      // stage has an engine
    private int fuel;           // quantity of fuel
    private int bodyMass;       // mass of empty stage
    private  int allMass;       // mass of stage with fuel
    public boolean installed;   // if we use this stage we instell it on rocket
    public int consumption;     // consumptionof fuel at this stage

    Stage(int fuel,int consumption,int bodyMass,int stages){
        this.fuel=fuel;
        this.bodyMass=bodyMass;
        this.consumption=consumption;
        engine= new Engine() {
            @Override
            void check() {
                System.out.print("engine is ok\t");
            }
        };
        if(fuel>0) //if we have some fuel we install stage and check an engine
        {
            installed=true;
            System.out.print(" stage "+stages+" : ");
            engine.check();
            System.out.println(" fuel: "+fuel);
            allMass=bodyMass+fuel;
        }
        else
        {
            installed=false;
            allMass=0;
        }


    }
    public void run(){
        //speed+=fuel/
        if(fuel>0){                             // if we still have fuel
            fuel=engine.on(fuel,consumption);   //turn on engine
        }else{
            installed=false;                    //otherwise we disconnect stage
        }
        allMass=bodyMass+fuel;                  //calculation current mass
    }
    public int getAllMass(){
        return allMass;
    }


}
