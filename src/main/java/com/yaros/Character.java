package com.yaros;

public class Character {

    private static int hp;
    private static int hp_limit;
    private static Item weapon;

    private static int gold = 1000;
    public static int get_gold(){
        return gold;
    }
    public static void change_gold(int value){
        gold -= value;
    }

    private static Item[] inventory = new Item[6];
    public static Item[] get_inventory(){
        return inventory;
    }
    public static void inventory_add_item(Item n_item, int index){
        inventory[index] = n_item;
    }

    public static void inventory(){

        Commands.cleanConsole();
        System.out.println("Your Inventory:");
        for(int i = 0; i < inventory.length; i++){
            if(inventory[i] != null) {
                System.out.println("slot " + (i + 1) + ":  " + inventory[i].get_name());
            }else{
                System.out.println("slot " + (i + 1) + ": empty");
            }
        }
        System.out.println("Gold: " + gold);
    }

    public  static void inventory_drop(String[] command){

        try{
            int index = Integer.parseInt(command[1]) - 1;
            System.out.println(inventory[index].get_name() + " was dropped");
            inventory[index] = null;
        }catch(Exception e){
            System.out.println("invalid value (item number)");
            return;
        }
    }


    public static void equip_weapon(Item weap){
        weapon = weap;
    }
}
