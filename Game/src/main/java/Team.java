
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
            chooseHero(a);
        }
    }

    private void chooseHero(int a) {
        System.out.println("Chose your hero:");
        for (int j = 1; j <= 3; j++) {
            HeroType.valueOf("C" + a + j).getInfo();
        }
        int k = InputValidation.getNumber(1, 3);
        team.add(new Hero(HeroType.valueOf("C" + a + k)));
    }

    boolean checkIsAlive() {
        boolean isAlive = false;
        for (Hero h : team) {
            if (h.getHealth() > 0) {
                isAlive = true;
            }
        }
        return isAlive;
    }

    int calculateDamage() {
        int position = (int) (random() * 2 + 0.01);
        int damage = 0;
        for (int i = 0; i < 3; i++) {
            boolean isAlive = team.get((position + i) % 3).getHealth() > 0;
            if (isAlive) {
                damage = getDamage((position + i) % 3);
            }
        }
        return damage;
    }

    private int getDamage(int i) {
        int a = 0;
        HeroType h = team.get(i).getHeroType();
        System.out.print(name + " | " + h.getRace() + " " + h.getType());
        System.out.print(" [" + team.get(i).getHealth() + "hp] >>>>> ");
        boolean canHealing = h.getHealing() != 0 && random() * 3 < 1;
        if (canHealing) {
            damaged(h.getHealing());
        } else {
            a = h.getDamage() * ((random() < (h.getCritical() / 100.f)) ? 2 : 1) * (-1);
        }
        return a;
    }

    void damaged(int inc) {
        int position = (int) (random() * 2 + 0.01);
        boolean damaged=true;
        for (int i = 0; i < 3; i++) {
            boolean isAlive = team.get((position + i) % 3).getHealth() > 0;
            if (isAlive&&damaged) {
                setDamage((position + i) % 3, inc);
                damaged=false;
            }
        }
    }

    private void setDamage(int i, int inc) {
        HeroType h = team.get(i).getHeroType();
        int damage = (int) (inc * (100 - h.getArmor()) / 100.f);
        System.out.print(damage + ">>>>>" + name + " | " + h.getRace() + " " + h.getType());
        System.out.println(" [" + team.get(i).getHealth() + "hp]");
        team.get(i).incHealth(damage);
    }

}
