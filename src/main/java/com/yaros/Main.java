package com.yaros;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Random random = new Random();

    public static boolean in_battle = false;

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        //Character character = new Character("Hero", 22, 22, Item.weaponless(), Item.casual_outfit(), 3,2,3);
        //Npc character = new Npc("Hero", 22, 22, Item.weaponless(), Item.casual_outfit(), 3,2,3);
        Npc character = Commands.genCharacter();
        System.out.println("Welcome to the RPG 1_1!!! enjoy this game killing monsters in 'dungeon' or visit shop by 'shop'");
        System.out.println("Command list: 'shop', 'buy 1'(+number of item) 'equip 1' 'use 1', 'inventory', 'dungeon',");

        for(;;){
            String com = scanner.nextLine();
            String[] command;

            try {
                command = com.split(" ");
            }catch (Exception e){
                System.out.println("invalid command");
                continue;
            }
                switch (command[0]) {


                    case "inventory": {
                        character.inventory();
                        break;
                    }

                    case "equip":{
                        try {
                            character.equip_weapon_or_armor(Integer.parseInt(command[1]));
                        }catch(Exception e){
                            System.out.println("invalid command");
                        }
                        break;
                    }

                    case "shop": {
                        Shop.shop_goods();
                        break;
                    }

                    case "use": {
                        character.inventory_use_item(Integer.parseInt(command[1]), null);
                        break;
                    }

                    case "buy": {
                        Shop.shop_buy_item(command, character);
                        break;
                    }

                    case "drop": {
                        character.inventory_drop(command);
                        break;
                    }

                    case "dungeon":{
                        Quest.quest1(character);
                        break;
                    }
                }

        }
    }
}







/*case "shop":{
        System.out.println("no goods now");
        for (;;) {
        System.out.println("you are in the shop");
        command = scanner.nextLine();
        if (!command.equals("quit")){
        continue;
        }
        System.out.println("you leave shop");
        break;
        }
        break;
        }  */