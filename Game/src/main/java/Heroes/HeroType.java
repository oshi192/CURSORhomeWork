package Heroes;

import lombok.Getter;

@Getter
public enum HeroType {

    C11("Human","Paladin",10,0,10,13),C12("Human","Archer",11,0, 5,15),C13("Human","Mag",15,15, 2, 1),
    C21("Elves","Warrior", 9,0,12,15),C22("Elves","Super archer",13,0,7, 3),C23("Elves","Druid",15,15, 2, 3),
    C31("Demons","Varvar",15,0, 5,10),C32("Demons","Hells archer",14,0,2, 1),C33("Demons","Necromant",15,15, 2, 2);

    private String type;
    private String race;
    private int damage;
    private int healling;
    private int armor;
    private int critical;

    HeroType(String race,String type,int damage,int healling,int critical,int armor){
        this.type=type;
        this.armor=armor;
        this.damage=damage;
        this.healling=healling;
        this.race=race;
        this.critical=critical;
    }

    public void getInfo(){
        System.out.print(race+" - "+type+" damage:"+damage+((healling==0)?"":(" healing:"+healling)));
        System.out.println(" %critical:"+critical+" armor:"+armor);
    }
}
