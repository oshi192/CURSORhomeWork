import heroes.Hero;
import heroes.HeroType;
import util.InputValidation;

import java.util.ArrayList;

import static java.lang.Math.random;

class Team {

    private String name;
    private ArrayList<Hero> team;

    Team(String name) {
        this.name = name;
        team = new ArrayList<>();
    }

    String getName() {
        return name;
    }

    void setHeroes(int a) {
        for (int i = 0; i < 3; i++) {
            System.out.println("Chose your hero:");
            for (int j = 1; j <= 3; j++) {
                HeroType.valueOf("C" + a + j).getInfo();
            }
            int k = InputValidation.checkNumber(1, 3);
            team.add(new Hero(HeroType.valueOf("C" + a + k)));
        }
    }

    boolean checkIsAlive() {
        for (Hero h : team) {
            if (h.getHealth() > 0) {
                return true;
            }
        }
        return false;
    }

    int calculateDamage() {
        int position = (int) (random() * 2 + 0.01);
        HeroType h;
        for (int i = 0; i < 3; i++) {
            boolean isAlive = team.get((position + i) % 3).getHealth() > 0;
            if (isAlive) {
                h = team.get((position + i) % 3).getHeroType();
                System.out.print(name + " | " + h.getRace() + " " + h.getType());
                System.out.print(" [" + team.get((position + i) % 3).getHealth() + "hp] >>>>> ");
                boolean canHealing = h.getHealing() != 0 && random() * 3 < 1;
                if (canHealing) {
                    damaged(h.getHealing());
                    return 0;
                }
                return h.getDamage() * ((random() < (h.getCritical() / 100.f)) ? 2 : 1) * (-1);
            }
        }
        return 0;
    }


    void damaged(int inc) {
        if (inc == 0) return;
        int position = (int) (random() * 2 + 0.01);
        HeroType h;
        for (int i = 0; i < 3; i++) {
            boolean isAlive = team.get((position + i) % 3).getHealth() > 0;
            if (isAlive) {
                h = team.get((position + i) % 3).getHeroType();
                int damage = (int) (inc * (100 - h.getArmor()) / 100.f);
                System.out.print(damage + ">>>>>" + name + " | " + h.getRace() + " " + h.getType());
                System.out.println(" [" + team.get((position + i) % 3).getHealth() + "hp]");
                team.get((position + i) % 3).incHealth(damage);
                return;
            }
        }
    }

}
