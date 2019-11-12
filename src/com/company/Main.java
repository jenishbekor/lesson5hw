package com.company;

import java.util.Random;

public class Main {

    private static Boss boss;
    private static MagicDoor magicDoor;

    public static void main(String[] args) {
        // write your code here
        boss = new Boss(750, 50);
        magicDoor = new MagicDoor();

        printStatistics();
        while (!isFinished()) {
            round();
        }
    }

    public static void printStatistics() {
        System.out.println("_____________");
        System.out.println(boss);
        System.out.println(magicDoor);
        System.out.println("_____________");
    }

    public static boolean isFinished() {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!");
            return true;
        }

        if (magicDoor.isAllDeath()) {
            System.out.println("Boss won!");
            return true;
        }

        return false;
    }

    public static void round() {
        boss.changeDefenceType(magicDoor.getHeroes());
        magicDoor.changeLuckHeroIndex(boss);
        heroesHit();
        if (boss.getHealth() > 0) {
            bossHits();
        }
        magicDoor.medicalHelpToHeroes();
        printStatistics();
    }

    public static void heroesHit() {
        for (Hero hero : magicDoor.getHeroes()) {
            if (hero.getHealth() > 0) {
                if (!hero.getHeroType().equals(boss.getDefenceType())) {
                    if (magicDoor.getLuckHero().equals(hero.getHeroType())) {
                        int coefficient = new Random().nextInt(9) + 2; //2,3,4,5,6
                        int heroSuperAttack = hero.getAttackSize() * coefficient;
                        System.out.println(hero.getHeroType() + " hits boss by " + heroSuperAttack);
                        boss.setHealth(boss.getHealth() - heroSuperAttack);
                    } else {
                        boss.setHealth(boss.getHealth() - hero.getAttackSize());
                    }

                    if (boss.getHealth() < 0) {
                        boss.setHealth(0);
                        break;
                    }
                }
            }
        }
    }

    public static void bossHits() {
        for (Hero hero : magicDoor.getHeroes()) {
            if (hero.getHealth() > 0) {
                hero.setHealth(hero.getHealth() - boss.getAttackSize());
            }
            if (hero.getHealth() < 0) {
                hero.setHealth(0);
            }
        }
    }
}
