package com.company;

public class Hero {
    private int health;
    private int attackSize;
    private String heroType;

    public Hero(int health, int attackSize, String heroType) {
        this.health = health;
        this.attackSize = attackSize;
        this.heroType = heroType;
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

    public String getHeroType() {
        return heroType;
    }

    public void setHeroType(String heroType) {
        this.heroType = heroType;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "health=" + health +
                ", attackSize=" + attackSize +
                ", heroType='" + heroType + '\'' +
                '}';
    }
}