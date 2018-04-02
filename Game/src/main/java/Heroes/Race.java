package Heroes;

public class Race {

    private  String name;
    private int type;

    public Race(int i){
        type=i;
        switch (i){
            case 1:name="Human";break;
            case 2:name="Elves";break;
            case 3:name="Demons";break;
        }
    }
    public Race(){

    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }
}
