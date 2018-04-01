package Heroes;

public class Race {

    private  String name;

    public Race(int i){
        switch (i){
            case 1:name="Human";
            case 2:name="Elfes";
            case 3:name="Demons";
        }
    }
    public Race(){

    }

    public String getName() {
        return name;
    }
    public void getInfo(){
        switch (name){
            case "Human": ;
            case "Elfes": ;
            case "Demons":;
        }
    }
}
