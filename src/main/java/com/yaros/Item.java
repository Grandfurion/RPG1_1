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

    private int price;
    public int get_price(){
        return price;
    }

    public void on_use(){

    }

    public static Item gen_item(){
        Item g_item = new Item();
        Random random = new Random();

        String[] type_s = new String[]{"weapon", "armor", "consumables"};
        String[] name_s = new String[]{"sword", "dagger", "spear", "jacket", "breastplace", "potion", "scroll"};
        int price_s = 0;

        int[] d = new int[2];
        d[0] = random.nextInt(3);
        g_item.type = type_s[d[0]];
        if(d[0] == 0){
            d[1] = random.nextInt(3);
            price_s = random.nextInt(26) + 30;
        }else if(d[0] == 1){
            d[1] = random.nextInt(2) + 3;
            price_s = random.nextInt(31) + 60;
        }else if(d[0] == 2){
            d[1] = random.nextInt(2) + 5;
            price_s = random.nextInt(11) + 40;
        }
        g_item.name = name_s[d[1]];
        g_item.price = price_s;

        return g_item;
    }

}