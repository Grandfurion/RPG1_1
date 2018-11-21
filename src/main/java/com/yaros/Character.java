package com.yaros;

public class Character extends Npc {

    public Character(String name, int hp, int hp_limit, Item weapon, Item armor, int strenght, int dexterity, int intelligence) {
        super (name, hp, hp_limit, weapon, armor , strenght, dexterity, intelligence);

    }


}




/*public class Character {



    private static int hp = 22;
    public static int get_hp(){
        return hp;
    }
    public static void change_hp(int value){
        hp -= value;
    }
    private static int hp_limit = 22;
    public static int get_hp_limit(){
        return hp_limit;
    }

    public static void cap_hp(){    //set currently hp to hp limit
        if(hp > hp_limit){
            hp = hp_limit;
        }
    }
    private static Item weapon = Item.weaponless();
    private static Item armor = Item.casual_outfit();
    private static int strenght = 3;
    public static int getStrMod(){
        return strenght;
    }
    private static int dexterity = 2;
    public static int getDexMod(){
        return dexterity;
    }
    private static int intelligence = 3;
    public static int getIntMod(){
        return intelligence;
    }

    public static void equip_weapon_or_armor(int num){
        if (inventory[num - 1].get_type() == "weapon") {
            weapon = inventory[num - 1];
            System.out.println(inventory[num - 1].get_name() + " was equiped as a weapon");
            return;
        }else if(inventory[num - 1].get_type() == "armor") {
            armor = inventory[num - 1];
            System.out.println(inventory[num - 1].get_name() + " was equiped as an armor");
            return;
        }
            System.out.println("selected item is neither weapon nor armor");
            return;

    }
    public static Item get_weapon(){
        return weapon;
    }

    public static Item get_armor(){
        return armor;
    }

    public static void attack_enemy(Npc enemy){
        int modificator = Main.random.nextInt(6)+1;
        if ((Character.getStrMod() + modificator) >=
                (enemy.getDexMod() + enemy.get_armor_class() + 3)){
            int value = Character.get_weapon().get_damage() + Character.getStrMod();
            enemy.change_hp(value);
            System.out.println("you damaged " + enemy.get_name() + " for " + value + " damage");
        }else if((Character.getStrMod() + modificator) <
                (enemy.getDexMod() + enemy.get_armor_class() + 3)){
            System.out.println("you missed");
        }
    }

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

    public static void inventory_use_item(int index){
        index -= 1;
        if (inventory[index ].effect != null){
            inventory[index ].effect.on_use(inventory[index].effect);
            System.out.println("you use " + inventory[index].get_name());
            inventory[index] = null;
        }else{
            System.out.println("cant use selected item");
        }
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


}*/
