import heroes.HeroType;
import util.InputValidation;
import util.Reader;

import static java.lang.Math.random;

public class Battle {
    private Team team1;
    private Team team2;
    private int move;

    public void setNames() {
        System.out.println("Enter your first player name: ");
        team1 = new Team(Reader.getString());
        System.out.println("Enter second player name: ");
        team2 = new Team(Reader.getString());
    }

    public void chooseTeam() {
        System.out.println(team1.getName() + " choose team race: ");
        for (int i = 1; i <= 3; i++) {
            System.out.println(i + ") " + HeroType.valueOf("C" + i + 1).getRace());
        }
        team1.setHeroes(InputValidation.checkNumber(1, 3));
        for (int i = 1; i <= 3; i++) {
            System.out.println(i + ") " + HeroType.valueOf("C" + i + 1).getRace());
        }
        team2.setHeroes(InputValidation.checkNumber(1, 3));
    }

    public void startBatle() {
        int y = 0;
        move = (random() * 2 < 1) ? 1 : -1;
        while (team1.checkIsAlive() && team2.checkIsAlive()) {
            y++;
            System.out.print("step " + y + ":\t");
            if (move > 0) {
                team2.damaged(team1.calculateDamage());
            } else {
                team1.damaged(team2.calculateDamage());
            }
            move *= -1;

        }

    }

    public void printResult() {
        System.out.println(team1.getName() + ": is alive=" + team1.checkIsAlive());
        System.out.println(team2.getName() + ": is alive=" + team2.checkIsAlive());
        System.out.println("won :" + ((move < 0) ? team1.getName() : team2.getName()));
    }
}
