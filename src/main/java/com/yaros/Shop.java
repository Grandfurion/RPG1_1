package com.yaros;

public class Shop {

    private static boolean is_goods = false;
    private static Item[] goods = new Item[6];


    public static void shop_show_goods(Item[] goods){

        Commands.cleanConsole();
        for(int i = 0; i < goods.length; i++){
            if (goods[i] != null){
                System.out.println(goods[i].get_name() + " (" + goods[i].get_type() + ") " + " - " + goods[i].get_price());
            }else{
                System.out.println("sold");
            }
        }
    }


    public static void shop_buy_item(String[] command){

        if(is_goods == false) {
            System.out.println("all goods were sold");
        }
        int index = 0;
        try{
            index = Integer.parseInt(command[1]) - 1;
        }catch (Exception e){
            System.out.println("invalid value (item number)");
            return;
        }
        Item[] inventory = Character.get_inventory();

        for (int i = 0; i < inventory.length; i++){
            if (inventory[i] == null && Character.get_gold() > goods[i].get_price()) {
                Character.inventory_add_item(goods[index], i);
                Character.change_gold(goods[index].get_price());
                System.out.println(goods[index].get_name() + " was bought for " + goods[index].get_price());
                goods[index] = null;
                goods_check();
                break;
            }else if(inventory[i] == null && Character.get_gold() < goods[i].get_price()){
                System.out.println("You havent enough gold");
                break;
            }else if (inventory[i] != null && i == (inventory.length -1)){
                System.out.println("your inventory is full!");
                break;
            }else if(inventory[i] != null && i != (inventory.length -1)){
                continue;
            }
            break;
        }


    }

    public static void shop_goods() {

        if (is_goods == false) {

            Commands.cleanConsole();
            System.out.println("Shop goods: ");
            for (int i = 0; i < goods.length; i++) {
                goods[i] = Item.gen_item();
            }

            for (int i = 0; i < goods.length; i++) {
                System.out.println(goods[i].get_name() + " (" + goods[i].get_type()
                        + ") - " + goods[i].get_price() + " gold");
            }

            is_goods = true;

        }else{
            shop_show_goods(goods);
        }
    }

    public static void goods_check(){
        is_goods = false;
        for(int i = 0; i < goods.length; i++){
            if(goods[i] != null){
                is_goods = true;
            }
        }
    }

}
