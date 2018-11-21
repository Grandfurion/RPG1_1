package com.yaros;

import java.util.Scanner;

public class Commands {



    public static void cleanConsole(){

        for (int i = 0; i < 7; i++){
            System.out.println(" ");
        }

    }

    public static void death(){
        Scanner scanner = new Scanner(System.in);
        for (;;){
            String com = scanner.nextLine();
            System.out.println("you died");
        }
    }

    public static Npc genCharacter(){
        Scanner scanner = new Scanner(System.in);
        int scoreMax = 15;
        System.out.println("stats point buy: enter the value of current stat and get it value's score, total score " +
                "must be less than " + scoreMax + " . the point buy table: default stat = 10; \n set stat to 9(reduced " +
                "compare to default will give you 1 extra score, reduce to 8 will give 1 more, to 7 or 6 will give" +
                " 2 extra. can not reduce below 6.\n Increase stat to 11 will cost 1 score, to 12/13 - 2 more for " +
                "every point, 3 for 14/15 point. and 4 score for 16/17/18 point can nor increase stat upper than 18.");
        int score = 0;
        for(;;){
            System.out.println("Enter your strength");
            try {
                int str = scanner.nextInt();
                score = stat_checker(str, score);
                System.out.println("score = " + score + "/" + scoreMax);
                System.out.println("Enter your dexterity");
                int dex = scanner.nextInt();
                score = stat_checker(dex, score);
                System.out.println("score = " + score + "/" + scoreMax);
                System.out.println("Enter your intelligence");
                int intel = scanner.nextInt();
                score = stat_checker(intel, score);
                System.out.println("score = " + score + "/" + scoreMax);
                if(!scoreChecker(score, scoreMax)) {
                    score = 0;
                    continue;
                }
                Npc character  = new Npc("Hero", 25, 25, Item.weaponless(), Item.casual_outfit(), str, dex, intel);
                return character;
            }catch (Exception e){
                System.out.println("Invalid number");
                continue;
            }
        }
    }

    public static boolean scoreChecker(int score, int scoreMax){
        if(score <= scoreMax){
            return true;
        }
        else{
            System.out.println("over score (" + score +  "/" + scoreMax + ")");
            return false;
        }
    }

    public static int stat_checker(int value, int score){
        if (value < 6 || value > 18){
            throw new ArithmeticException("invalid number");
        }else{
            switch (value){
                case 6:{
                    score -= 6;
                    break;
                }
                case 7: {
                    score -= 4;
                    break;
                }case 8: {
                    score -= 2;
                    break;
                }case 9:{
                    score -= 1;
                    break;
                }case 10:{
                    break;
                }case 11:{
                    score += 1;
                    break;
                }case 12:{
                    score += 3;
                    break;
                }case 13:{
                    score += 5;
                    break;
                }case 14:{
                    score += 8;
                    break;
                }case 15:{
                    score += 11;
                    break;
                }case 16:{
                    score += 15;
                    break;
                }case 17:{
                    score += 18;
                    break;
                }case 18:{
                    score += 21;
                    break;
                }
            }
        }
        return score;
    }




}
