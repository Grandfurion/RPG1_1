package com.yaros;

public class Quest {

    static void quest1(Npc character){
        Commands.cleanConsole();
        System.out.println("you left city through East Gates. After about half an hour you discover a dark cave and" +
                " decided to enter it. You realize a small goblin in dark mist, prepare to fight!");
        Npc enemy = new Npc("goblin" ,17, 17, Item.sword(), Item.casual_outfit(), 14, 16, 12);
        int hero = Battle.battle_first_phase(character,enemy);
        if (hero == 2){
            Commands.death();
        }
        return;
    }

}
