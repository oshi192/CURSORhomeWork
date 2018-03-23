abstract  class Engine implements I_BurningFuel{

    @Override
    public int on(int c, int consumption) {
        return c-consumption;
    }
    abstract void check();
}
