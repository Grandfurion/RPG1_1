package com.yaros;

import java.util.Random;

public class Item {

    private String name;
    public String get_name(){
        return name;
    }

    private String type;
    public String get_type(){
        return type;
    }

    private int damage;
    public int get_damage(){
        return damage;
    }

    private int armor_class;
    public int get_armor_class(){
        return armor_class;
    }

    private int price;
    public int get_price(){
        return price;
    }

    Effect effect;
    /*DK if this method is needed at all (didnt use it)
    public void on_use(Effect effect){
        effect.on_use(effect);
    } */

    public static Item gen_item(){
        Item g_item = new Item();
        Random random = new Random();

        String[] type_s = new String[]{"weapon", "armor", "consumables"};
        String[] name_s = new String[]{"sword", "dagger", "spear", "jacket", "breastplace", "potion", "scroll"};
        int price_s = 0;
        int damage_s = 0;

        int[] d = new int[2];
        d[0] = random.nextInt(3);
        g_item.type = type_s[d[0]];
        if(d[0] == 0){
            d[1] = random.nextInt(3);
            switch (d[1]){
                case 0:{
                    damage_s = 3;
                    break;
                }
                case 1:{
                    damage_s = 2;
                    break;
                }
                case 2:{
                    damage_s = 4;
                    break;
                }
            }
            g_item.damage = damage_s;
            price_s = random.nextInt(26) + 30;

        }else if(d[0] == 1){
            d[1] = random.nextInt(2) + 3;
            if(d[1] == 3){
                g_item.armor_class = 1;
            }else if(d[1] == 4){
                g_item.armor_class = 2;
            }
            price_s = random.nextInt(31) + 60;
        }else if(d[0] == 2){
            d[1] = random.nextInt(2) + 5;
            if(d[1] == 5){
                g_item.effect = Effect.lesser_heal(0);
            }
            if(d[1] == 6){
                g_item.effect = Effect.lesser_fire_damage();
            }
            price_s = random.nextInt(11) + 40;
        }
        g_item.name = name_s[d[1]];
        g_item.price = price_s;

        return g_item;
    }

    public static Item sword(){
        Item sword = new Item();
        sword.type = "weapon";
        sword.name = "sword";
        sword.damage = 3;
        return sword;
    }
    public static Item weaponless(){
        Item weaponless = new Item();
        weaponless.type = "weapon";
        weaponless.name = "weaponless";
        weaponless.damage = 1;
        return weaponless;
    }
    public static Item casual_outfit(){
        Item outfit = new Item();
        outfit.type = "armor";
        outfit.name = "casual outfit";
        outfit.armor_class = 0;
        return outfit;
    }

}