abstract  class Engine implements EngineProvider{

    @Override
    public int on(int c, int consumption) {
        return c-consumption;
    }
    abstract void check();
}
