
public class Game {
    public static void main(String[] args) {
        Battle battle = new Battle();
        battle.setNamesAndRaces();
        battle.startBattle();
        battle.printResult();
    }
}
