
import java.util.Scanner;

import static java.lang.Math.random;

public class Game {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your first player name: ");
        Team team1=new Team(Reader.getString());
        System.out.println("Enter second player name: ");
        Team team2=new Team(Reader.getString());
        System.out.println(team1.getName()+" choose team race: \n1)Human - \n2)Elfes - \n3)Demons - ");
        System.out.println("next-----------");
        team1.setRace(InputValidation.checkNumber(1,3));
        team1.setHeroes();
        System.out.println(team2.getName()+" choose team race: \n1)Human - \n2)Elfes - \n3)Demons - ");
        team2.setRace(InputValidation.checkNumber(1,3));
        team2.setHeroes();
        int move;
        move=(random()*2<1)?1:-1;
        int i=0;
        while(team1.checkIsAlive()&&team1.checkIsAlive()){
            if(move>0){
                team2.damagedOf(team1.calculateDamage());
            }else{
                team1.damagedOf(team2.calculateDamage());
            }

            move*=-1;
            i++;
        }
        System.out.println("team1: health="+team1.checkIsAlive());
        System.out.println("team2: health="+team2.checkIsAlive());
        System.out.println("win :"+((move<0)?"team1":"team2"));


    }
}
