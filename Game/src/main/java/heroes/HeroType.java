package heroes;

import lombok.Getter;

@Getter
public enum HeroType {

    C11("Human", "Paladin", 10, 10, 13),
    C12("Human", "Archer", 11, 5, 15),
    C13("Human", "Mag", 15,  2, 1),
    C21("Elves", "Warrior", 9,  12, 15),
    C22("Elves", "Super archer", 13, 7, 3),
    C23("Elves", "Druid", 15,  2, 3),
    C31("Demons", "Barbarian", 15, 5, 10),
    C32("Demons", "Hells archer", 14, 2, 1),
    C33("Demons", "Necromancer", 15,  2, 2);

    private String type;
    private String race;
    private int damage;
    private int healing;
    private int armor;
    private int critical;

    HeroType(String race, String type, int damage,  int critical, int armor) {
        this.type = type;
        this.armor = armor;
        this.damage = damage;
        this.race = race;
        this.critical = critical;
        this.healing=(damage==15)?15:0;
    }

    public void getInfo() {
        System.out.print(race + " - " + type + " damage:" + damage + ((healing == 0) ? "" : (" healing:" + healing)));
        System.out.println(" %critical:" + critical + " armor:" + armor);
    }
}
