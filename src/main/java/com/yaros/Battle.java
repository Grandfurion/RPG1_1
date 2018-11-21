package com.yaros;

import java.util.Scanner;

public class Battle {

    static Scanner scanner = new Scanner(System.in);

    static int battle_first_phase(Npc character , Npc enemy) {
        int[] victory_def = new int[]{0}; //1 - enemy died, 2 - hero died
        System.out.println("your enemy is " + enemy.get_name());
        Main.in_battle = true;


        int command;

        for (; ; ) {
            /*if (victory_def[0] != 0) {

            }*/
            try {
                System.out.println("what should you do?");
                System.out.println("You: " + character.get_hp() + " hp, enemy: " + enemy.get_hp() + " hp");
                System.out.println(">Attack (1)");
                System.out.println(">Inventory (2)");
                System.out.println(">Run (3)");
                command = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("wrong command");
                continue;
            }

            switch (command) {
                case 1: {
                    attack(character ,enemy, victory_def);
                    break;
                }

                case 2:{
                    for (;;) {
                        character.inventory();
                        System.out.println("select item to use");
                        String com = scanner.nextLine();
                        if(!com.equals("back")) {
                            try {
                                character.inventory_use_item(Integer.parseInt(com), enemy);
                            } catch (Exception e) {
                                System.out.println("invalid command (enter the number of selected item");
                                continue;
                            }
                        }else{

                        }
                        break;
                    }
                    break;
                }

                case 3: {
                    run(character, enemy, victory_def);
                    break;
                }
            }
            death_check(character, enemy, victory_def);
            // character must survive to continue the game
            if (victory_def[0] != 0){
                int hero = battle_end(victory_def);
                Main.in_battle = false;
                return hero;
            }else {
                continue;
            }
        }
    }

    static void attack(Npc character , Npc enemy, int[] victory_def) {

        int enemy_init = (enemy.getDexMod() + Main.random.nextInt(6) + 1);
        int hero_init =  (character.getDexMod() + Main.random.nextInt(6) + 1);

        // enemy attacks first
        if (enemy_init > hero_init) {

            enemy.attack_target(character);
            death_check(character, enemy, victory_def);
            if (victory_def[0] == 0) {
                character.attack_target(enemy);
            }

            //hero attacks first
        } else if (hero_init >= enemy_init) {
            character.attack_target(enemy);
            death_check(character, enemy, victory_def);
            if (victory_def[0] == 0) {
                enemy.attack_target(character);
            }

        }
    }


    static void death_check(Npc character, Npc enemy, int[] victory_death) {
        if (character.get_hp() <= 0) {
            victory_death[0] = 2;
        }else if(enemy.get_hp() <= 0){
            victory_death[0] = 1;
    }

    }
    static int battle_end(int[] victory_def){
        if(victory_def[0] == 1){
            System.out.println("enemy was defeated");
            return 1;

        }else if(victory_def[0] == 2){
            System.out.println("you died");
            return 2;
        }else if (victory_def[0] == 3){
            System.out.println("escaped from battle");
            return 3;
        }
        return 0;
    }

    static void run(Npc character, Npc enemy, int[] victory_def){
        int char_speed = character.getDexMod() + Main.random.nextInt(6) + 1;
        int enemy_speed = enemy.getDexMod() + Main.random.nextInt(3) + 1;

        System.out.println("you try to escape the battle");
        if (char_speed >= enemy_speed){
            System.out.println("you manage to do it!");
            victory_def[0] = 3;
            return;
        }else{
            System.out.println("you failed");
        }
    }

}
