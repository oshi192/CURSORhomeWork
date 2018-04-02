package Heroes;

import lombok.Getter;

@Getter
public class Hero extends Race {
    private String name;
    private boolean isPreferance;
    private int typeRace;
    private float health;
    public final static int [][][] actions= new int[][][]{
            {{10,10,13}, {11, 5,15}, {15,15, 2, 1}}, //Human{warior,archer,mag}
            {{ 9,12,15}, {13, 7, 3}, {15,15, 2, 3}},
            {{15, 5,10}, {14, 2, 1}, {15,15, 2, 2}}
    };
    private int type;
    public Hero(int typeRace,int type){
        this.type=type;
        this.typeRace=typeRace;
        setName(typeRace,type);
        health=100;
    }
    private void setName(int t,int r){
        name=HeroesType.valueOf("N"+(t*10+r)).name;
        isPreferance=(r==1)?false:true;
    }

    public void incHealth(int k){
        health+=k;
    }


}
