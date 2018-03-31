public class Race {

    private  String name;

    Race(int i){
        switch (i){
            case 1:name="Human";
            case 2:name="Elfes";
            case 3:name="Demons";
        }
    }
    Race(){

    }

    public String getName() {
        return name;
    }
}
