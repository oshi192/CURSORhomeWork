
public class Game {
    public static void main(String[] args) {
        Battle battle = new Battle();
        battle.setNames();
        battle.chooseTeam();
        battle.startBatle();
        battle.printResult();
    }
}
