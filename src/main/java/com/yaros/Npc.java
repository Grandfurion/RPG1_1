package com.yaros;

public class Npc {

    public Npc(String name, int hp, int hp_limit, Item weapon, Item armor, int superStrength, int superDexterity, int superIntelligence){
        this.name = name;
        this.hp = hp;
        this.hp_limit = hp_limit;
        this.weapon = weapon;
        this.armor = armor;
        this.superStrength = superStrength;
        this.superDexterity = superDexterity;
        this.superIntelligence = superIntelligence;
        setModificators();
    }

    private String name;
    public String get_name(){
        return name;
    }

    private int hp;
    public int get_hp(){
        return hp;
    }
    public void change_hp(int value){
        hp -= value;
    }
    private  int hp_limit;
    public  int get_hp_limit(){
        return hp_limit;
    }

    public  void cap_hp(){    //set currently hp to hp limit
        if(hp > hp_limit){
            hp = hp_limit;
        }
    }
    //private  Item weapon = Item.weaponless();
    //private  Item armor = Item.casual_outfit();

    private  Item weapon;
    private  Item armor;

    private int superStrength;
    private int superDexterity;
    private int superIntelligence;

    public void setModificators(){
        strenghtModificator = (superStrength - 10) / 2;
        dexterityModificator = (superDexterity - 10) / 2;
        intelligenceModificator = (superIntelligence - 10) / 2;
    }

    private  int strenghtModificator;
    public  int getStrMod(){
        return strenghtModificator;
    }
    private  int dexterityModificator;
    public  int getDexMod(){
        return dexterityModificator;
    }
    private  int intelligenceModificator;
    public  int getIntMod(){
        return intelligenceModificator;
    }

    public void equip_weapon_or_armor(int num){
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
    public  Item get_weapon(){
        return weapon;
    }

    public  Item get_armor(){
        return armor;
    }

    public void attack_target(Npc terget){
        int modificator = Main.random.nextInt(6)+1;
        if ((strenghtModificator + modificator) >=
                (terget.dexterityModificator + terget.armor.get_armor_class() + 3)){
            int value = weapon.get_damage() + strenghtModificator;
            terget.change_hp(value);
            System.out.println(this.name + " damaged " + terget.name + " for " + value + " damage");
        }else if((strenghtModificator + modificator) <
                (terget.dexterityModificator + terget.armor.get_armor_class() + 3)){
            System.out.println(name + " missed");
        }
    }

    private int gold = 1000;
    public int get_gold(){
        return gold;
    }
    public void change_gold(int value){
        gold -= value;
    }

    private Item[] inventory = new Item[6];
    public Item[] get_inventory(){
        return inventory;
    }
    public void inventory_add_item(Item n_item, int index){
        inventory[index] = n_item;
    }

    public void inventory(){

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

    public void inventory_use_item(int index, Npc target){
        index -= 1;
        if(!Main.in_battle) {
            if (inventory[index].effect != null) {
                if(inventory[index].effect.get_type().equals("damage")){
                    System.out.println("you are not in battle");
                    return;
                }
                inventory[index].effect.on_use(inventory[index].effect, this, target);
                System.out.println("you use " + inventory[index].get_name());
                inventory[index] = null;
            } else {
                System.out.println("cant use selected item");
            }
        }else{
            if (inventory[index].effect != null) {
                inventory[index].effect.on_use(inventory[index].effect, this, target);
                System.out.println("you use " + inventory[index].get_name());
                inventory[index] = null;
            } else {
                System.out.println("cant use selected item");
            }
        }
    }

    public void inventory_drop(String[] command){

        try{
            int index = Integer.parseInt(command[1]) -1;
            System.out.println(inventory[index].get_name() + " was dropped");
            inventory[index] = null;
        }catch(Exception e){
            System.out.println("invalid value (item number)");
            return;
        }
    }


}




/*
public class Npc {

    private String name;
    public String get_name(){
        return name;
    }
    private int hp;
    public int get_hp(){
        return hp;
    }
    public void change_hp(int value){
        hp -= value;
    }
    private int hp_limit;
    public int get_hp_limit(){
        return hp_limit;
    }

    private static int strenghtModificator;
    public static int getStrMod(){
        return strenghtModificator;
    }
    private static int dexterityModificator;
    public static int getDexMod(){
        return dexterityModificator;
    }
    private static int intelligenceModificator;
    public static int getIntMod(){
        return intelligenceModificator;
    }

    private Item weapon;
    public Item get_weapon(){
        return weapon;
    }
    private int armor_class;
    public int get_armor_class(){
        return armor_class;
    }

    public void attack(){
        int modificator = Main.random.nextInt(6)+1;
        if ((getStrMod() + modificator) >=
                (Character.getDexMod() + Character.get_armor().get_armor_class() + 3)) {
            int value = get_weapon().get_damage() + getStrMod();
            Character.change_hp(value);
            System.out.println(get_name() + " damaged you for " + value + " hp");
        } else if ((getStrMod() + modificator) <
                (Character.getDexMod() + Character.get_armor().get_armor_class() + 3)) {
            System.out.println(get_name() + " missed");
        }
    }

    /*public void equip_weapon(Item weap){
        weapon = weap;
    }

    public Npc(String name, int hp, int hp_limit, Item weapon, int armor_class, int strenghtModificator, int dexterityModificator, int intelligenceModificator){
        this.name = name;
        this.hp = hp;
        this.hp_limit = hp_limit;
        this.weapon = weapon;
        this.armor_class = armor_class;
        this.strenghtModificator = strenghtModificator;
        this.dexterityModificator = dexterityModificator;
        this.intelligenceModificator = intelligenceModificator;
    }

}
*/
