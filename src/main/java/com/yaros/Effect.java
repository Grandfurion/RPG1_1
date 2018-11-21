package com.yaros;

public class Effect {

    private String name;
    private int duration;
    private int value;

    private String type;
    public String get_type(){
        return type;
    }


    public Effect(String name, int duration){
        this.name = name;
        this.duration = duration;
    }

    public void on_use(Effect effect, Npc user, Npc target){
        switch (effect.type){
            case "heal":{
                healing(effect, user);
                break;
            }
            case "damage":{
                damage(effect, target);
                break;
            }
        }
    }

    public void healing(Effect effect, Npc npc){
        if(effect.type == "heal") {
            npc.change_hp(-value);
            System.out.println("you was healed for " + value + " hp");
            npc.cap_hp();
        }
    }

    public void damage(Effect effect, Npc target){
        if(effect.type == "damage"){
            target.change_hp(value);
            System.out.println(target.get_name() + " was damaged for " + value + " hp");
        }
    }

    public static Effect lesser_heal(int duration){
        Effect lesser_heal = new Effect("lesser heal", 0);
        lesser_heal.value =  8 + Main.random.nextInt(6);
        lesser_heal.type = "heal";
        return lesser_heal;
    }

    public static Effect lesser_fire_damage(){
        Effect lesser_fire_damage = new Effect("lesser_fire_damage", 0);
        lesser_fire_damage.value = 6 + Main.random.nextInt(4);
        lesser_fire_damage.type = "damage";
        return lesser_fire_damage;
    }

}
