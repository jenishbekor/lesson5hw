package com.company;

import java.util.Arrays;
import java.util.Random;

public class MagicDoor {
    private Hero[] heroes = new Hero[4];
    private int luckHeroIndex;

    public MagicDoor() {

        heroes[0] = new Hero(250, 30, "Physical");
        heroes[1] = new Hero(250, 20, "Magical");
        heroes[2] = new Hero(250, 10, "Kinetic");
        heroes[3] = new Hero(250, 0, "Medical");

    }

    public int getLuckHeroIndex() {
        return luckHeroIndex;
    }

    public void setLuckHeroIndex(int luckHeroIndex) {
        this.luckHeroIndex = luckHeroIndex;
    }

    public String getLuckHero() {
        return heroes[luckHeroIndex].getHeroType();
    }

    public void changeLuckHeroIndex(Boss boss) {
        Random r = new Random();
        luckHeroIndex = r.nextInt(heroes.length); //0, 1, 2
        if (heroes[luckHeroIndex].getHeroType().equals(boss.getDefenceType())) {
            changeLuckHeroIndex(boss);
        } else {
            System.out.println("Lucky hero " + heroes[luckHeroIndex].getHeroType());
        }
    }


    public Hero[] getHeroes() {
        return heroes;
    }

    public boolean isAllDeath() {
        boolean allDeath = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allDeath = false;
            }
        }
        return allDeath;
    }

    public void medicalHelpToHeroes() {
        if (heroes[3].getHealth() > 0) { //medical hero is alive
            for (Hero hero : heroes) {
                if (hero.getHealth() > 0) {
                    int medicalHealth = new Random().nextInt(20);
                    System.out.println(hero.getHeroType() + " health increased by " + medicalHealth);
                    hero.setHealth(hero.getHealth() + medicalHealth);
                }
            }
        }

    }

    @Override
    public String toString() {
        String str = "";
        for (Hero hero : heroes) {
            str = str + hero.getHeroType() + " health: " + hero.getHealth() + "\n";
        }
        return str;
    }
}
