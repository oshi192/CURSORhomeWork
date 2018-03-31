import java.util.ArrayList;

import static java.lang.Math.random;

public class Team {

    private String name;
    private int type;
    private ArrayList<Hero> team;
    private Race race;

    Team(String name){
        this.name=name;
    }
    public void setRace(int i) {
        race=new Race(i);
        type=i;
        team=new ArrayList<Hero>();
    }

    public String getName() {
        return name;
    }
    public void setHeroes(){
        System.out.println("n----");
        for(int i=0;i<3;i++){
            System.out.println("Chose your hero: 1-3");
            team.add(new Hero(type,InputValidation.checkNumber(1,3)));
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
        for(int i=0;i<3;i++){
            if(team.get((position+i)%3).health>0) {
                if(team.get((position+i)%3).getType()==2&&random()*2>1){
                    int k=Hero.actions[type-1][team.get((position+i)%3).getType()-1][1]*
                            ((random()< Hero.actions[type-1][team.get((position+i)%3).getType()-1][2]/100.f)?2:1);
                    addHeath(k);
                    System.out.print(name+":"+team.get((position+i)%3).getName()+" "+team.get((position+i)%3).health+">>>>");
                    return 0;
                }
                int k=Hero.actions[type-1][team.get((position+i)%3).getType()-1][0]*
                        ((random()< Hero.actions[type-1][team.get((position+i)%3).getType()-1][((position+i)%3==2)?2:1]/100.f)?2:1);
                System.out.print(name+":"+team.get((position+i)%3).getName()+" "+team.get((position+i)%3).health+">>>>");
                return  k;
            }
        }
        return 0;

    }
    public void damagedOf(int damage){
        int position=(int)(random()*2+0.01);
        for(int i=0;i<3;i++){
            if(team.get((position+i)%3).health>0) {
                int y=(int)(damage*((100-Hero.actions[type-1][team.get((position+i)%3).getType()-1][2])/100.f));
                System.out.println(name+":"+team.get((position+i)%3).getName()+" "+team.get((position+i)%3).health+"-"+y);
                team.get((position+i)%3).health-=y;
                return;
            }
        }
    }
    private void addHeath(int k ){
        int position=(int)(random()*2+0.01);
        for(int i=0;i<3;i++){
            if(team.get((position+i)%3).health>0) {
                team.get((position+i)%3).health+=k;
                System.out.println(name+":"+team.get((position+i)%3).getName()+" "+team.get((position+i)%3).health+"-"+k);
                return;
            }
        }
    }
    public void printAllHp(){
        for(Hero h:team){
            System.out.print("\t\t"+h.health);
        }
    }
}
