package com.yaros;
import java.util.Scanner;

public class Main {


    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        //boolean daily_check = false;

        for(;;){
            String com = scanner.nextLine();

            try {
                String[] command = com.split(" ");
                switch (command[0]) {

                    case "inventory": {
                        Character.inventory();
                        break;
                    }

                    case "shop": {
                        Shop.shop_goods();
                        break;
                    }

                    case "buy": {
                        Shop.shop_buy_item(command);
                        break;
                    }

                    case "drop": {
                        Character.inventory_drop(command);
                        break;
                    }

                }
            }catch (Exception e){
                System.out.println("invalid command");
                continue;
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