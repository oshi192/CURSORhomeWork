import Util.InputValidation;
import Util.Reader;

import static java.lang.Math.random;
import static java.lang.Thread.sleep;

public class Batle {
    private Team team1;
    private Team team2;
    private int move;

    public  void chooseTeam(){
        System.out.println("Enter your first player name: ");
        team1=new Team(Reader.getString());
        System.out.println("Enter second player name: ");
        team2=new Team(Reader.getString());
        System.out.println(team1.getName()+" choose team race: \n1)Human - \n2)Elfes - \n3)Demons - ");
        team1.setRace(InputValidation.checkNumber(1,3));
        team1.setHeroes();
        System.out.println(team2.getName()+" choose team race: \n1)Human - \n2)Elfes - \n3)Demons - ");
        team2.setRace(InputValidation.checkNumber(1,3));
        team2.setHeroes();
    }
    public void startBatle() throws InterruptedException {
        int y=0;
        move=(random()*2<1)?1:-1;
        team1.printTeam();
        team2.printTeam();
        sleep(1000);
        while(team1.checkIsAlive()&&team2.checkIsAlive()){
            y++;
            System.out.print("step "+y+":\t");
            if(move>0){
                team2.damagedOf(team1.calculateDamage());
            }else{
                team1.damagedOf(team2.calculateDamage());
            }
            move*=-1;
            sleep(10);
            if(y%10==0){
                team1.printTeam();
                team2.printTeam();
            }
        }
        team1.printTeam();
        team2.printTeam();
    }

    public void printResult(){
        System.out.println(team1.getName()+": is alive="+team1.checkIsAlive());
        System.out.println(team2.getName()+": is alive="+team2.checkIsAlive());
        System.out.println("win :"+((move<0)?team1.getName():team2.getName()));
    }
}
