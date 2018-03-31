/////
public class Hero extends Race {
    private String name;
    protected boolean isPreferance;
    private int typeRace;
    protected float kDamage;
    protected float health;
    protected int countActions;
    public final static int [][][] actions= new int[][][]{
            {{10,10,13}, {11, 5,15}, {15,15, 2, 1}}, //Human{warior,archer,mag}
            {{ 9,12,15}, {13, 7, 3}, {15,15, 2, 3}},
            {{15, 5,10}, {14, 2, 1}, {15,15, 2, 2}}
    };
    private int type;
    Hero(int typeRace,int type){
        this.type=type;
        this.typeRace=typeRace;
        setName(type,typeRace);
        health=100;
    }
    private void setName(int t,int r){
        name=HeroesType.valueOf("N"+(t*10+r)).name;
        isPreferance=(r==1)?false:true;
    }

    public float getHealth() {
        return health;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

}
