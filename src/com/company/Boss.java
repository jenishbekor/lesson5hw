package com.company;

import java.util.Random;

public class Boss {
    private int health;
    private int attackSize;
    private String defenceType;

    public Boss(int health, int attackSize) {
        this.health = health;
        this.attackSize = attackSize;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackSize() {
        return attackSize;
    }

    public void setAttackSize(int attackSize) {
        this.attackSize = attackSize;
    }

    public String getDefenceType() {
        return defenceType;
    }

    public void setDefenceType(String defenceType) {
        this.defenceType = defenceType;
    }

    public void changeDefenceType(Hero[] heroes) {
        Random r = new Random();
        int randomIndex = r.nextInt(heroes.length); //0, 1, 2
        defenceType = heroes[randomIndex].getHeroType();
        if (defenceType.equals("Medical")) {
            changeDefenceType(heroes);
        }
        System.out.println("Boss choosed " + defenceType);
    }

    @Override
    public String toString() {
        return "Boss health:" + health;
    }
}
