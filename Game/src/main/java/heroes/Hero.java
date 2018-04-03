package heroes;

import lombok.Getter;

@Getter
public class Hero {

    private HeroType heroType;
    private float health;
    public Hero(HeroType h){
        heroType = h;
        health = 100;
    }

    public void incHealth(int k){
        health += k;
        if(health>100)health=100;
    }
}
