import heroes.Hero;
import heroes.HeroType;
import util.InputValidation;
import java.util.ArrayList;
import static java.lang.Math.random;

public class Team {

    private String name;
    private ArrayList<Hero> team;

    Team(String name){
        this.name=name;
        team=new ArrayList<Hero>();
    }

    public String getName() {
        return name;
    }

    public void setHeroes(int a){
        for(int i=0;i<3;i++){
            System.out.println("Chose your hero:");
            for(int j=1;j<=3;j++) {
                HeroType.valueOf("C"+a+j).getInfo();
            }
            int k=InputValidation.checkNumber(1,3);
            team.add(new Hero(HeroType.valueOf("C"+a+k)));
        }
    }

    public boolean checkIsAlive(){
        for(Hero h:team){
            if(h.getHealth()>0){return true;}
        }
        return false;
    }

    public int calculateDamage(){
        int position=(int)(random()*2+0.01);
        HeroType h;
        for(int i=0;i<3;i++){
            if(team.get((position+i)%3).getHealth()>0) {
                h=team.get((position+i)%3).getHeroType();
                System.out.print(name+" | "+h.getRace()+" "+h.getType());
                System.out.print(" ["+team.get((position+i)%3).getHealth()+"hp] >>>>> ");
                if(h.getHealling() != 0 && random()*3 < 1){
                    damaged(h.getHealling());
                    return 0;
                }
                return h.getDamage() * ( (random()<(h.getCritical()/100.f)) ? 2 : 1 )*(-1);
            }
        }
        return 0;
    }


    public void damaged(int inc){
        if(inc==0)return;
        int position=(int)(random()*2+0.01);
        HeroType h;
        for(int i=0;i<3;i++){
            if(team.get((position+i)%3).getHealth()>0) {
                h=team.get((position+i)%3).getHeroType();
                int damage=(int)(inc*(100-h.getArmor())/100.f);
                System.out.print(damage+">>>>>"+name+" | "+h.getRace()+" "+h.getType());
                System.out.println(" ["+team.get((position+i)%3).getHealth()+"hp]");
                team.get((position+i)%3).incHealth(damage);
                return;
            }
        }
    }


}
