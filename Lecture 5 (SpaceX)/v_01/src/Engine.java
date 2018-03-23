public abstract class Engine implements I_BurningFuel {
    @Override
    public int on(int e,int  consumption) {
        if(e>consumption){
            return e-consumption;
        }else{
            return 0;
        }
    }
    abstract void check();

}
