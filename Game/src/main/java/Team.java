import Heroes.Hero;
import Heroes.HeroesType;
import Heroes.Race;
import Util.InputValidation;

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
        race=new Heroes.Race(i);
        type=i;
        team=new ArrayList<Hero>();
    }

    public String getName() {
        return name;
    }
    public void setHeroes(){
        for(int i=0;i<3;i++){
            System.out.println("Chose your hero:");
            for(int j=0;j<3;j++) {
                System.out.print(j+1+": " + HeroesType.valueOf("N" + (race.getType() * 10 + j+1)).name);
                System.out.print(" | damage: "+Hero.actions[race.getType()-1][j][0]+"HP");
                if(j==2){
                    System.out.print(" | healing : "+Hero.actions[race.getType()-1][j][1]+"HP");
                    System.out.print(" | %krit damage: "+Hero.actions[race.getType()-1][j][2]);
                    System.out.print(" | armor : "+Hero.actions[race.getType()-1][j][3]);
                }
                else {
                    System.out.print(" | %krit damage: " + Hero.actions[race.getType() - 1][j][1]);
                    System.out.print(" | armor : "+Hero.actions[race.getType()-1][j][2]);
                }
                System.out.println();
            }
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
            if(team.get((position+i)%3).getHealth()>0) {
                if(team.get((position+i)%3).getType()==2&&random()*2>1){
                    int k=Hero.actions[type-1][team.get((position+i)%3).getType()-1][1]*
                            ((random()< Hero.actions[type-1][team.get((position+i)%3).getType()-1][2]/100.f)?2:1);
                    addHeath(k);
                    System.out.print(name+":"+team.get((position+i)%3).getName()+" ["+team.get((position+i)%3).getHealth()+" HP] >>>> ");
                    return 0;
                }
                float krit=Hero.actions[type-1][team.get((position+i)%3).getType()-1][((position+i)%3==2)?2:1]/100.f;
                int k=Hero.actions[type-1][team.get((position+i)%3).getType()-1][0]*((random()<krit)?2:1);
                System.out.print(name+":["+race.getName()+"]"+team.get((position+i)%3).getName()+" "+team.get((position+i)%3).getHealth()+((random()<krit)?"krit!!":"")+" >>>> ");
                return  k;
            }
        }
        return 0;
    }

    public void damagedOf(int damage){
        int position=(int)(random()*2+0.01);
        for(int i=0;i<3;i++){
            if(team.get((position+i)%3).getHealth()>0) {
                int y=(int)(damage*((100-Hero.actions[type-1][team.get((position+i)%3).getType()-1][((position+i)%3==2)?3:2])/100.f));
                System.out.println(name+":["+race.getName()+"]"+team.get((position+i)%3).getName()+" ["+team.get((position+i)%3).getHealth()+" HP] -"+y+"(damage)");
                team.get((position+i)%3).incHealth(-1*y);
                return;
            }
        }
    }

    private void addHeath(int k ){
        int position=(int)(random()*2+0.01);
        for(int i=0;i<3;i++){
            if(team.get((position+i)%3).getHealth()>0) {
                team.get((position+i)%3).incHealth(k);
                System.out.println(name+":"+team.get((position+i)%3).getName()+" "+team.get((position+i)%3).getHealth()+"-"+k);
                return;
            }
        }
    }
    public void printAllHp(){
        for(Hero h:team){
            System.out.print("\t\t"+h.getHealth());
        }
    }
    public void printTeam(){
        System.out.println("____________________________________________");
        System.out.println("|name\t:"+name);
        System.out.println("|Race\t:"+race.getName());
        System.out.println("|isAlive="+checkIsAlive());
        int i=1;
        for(Hero h:team){
            System.out.println("|"+i+" person-\t:"+h.getName()+" ["+h.getHealth()+" HP]");
            i++;
        }
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }
}
