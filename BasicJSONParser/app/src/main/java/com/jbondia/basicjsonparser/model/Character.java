package com.jbondia.basicjsonparser.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by jbondia on 10/03/15.
 */
public class Character implements Serializable {

    private long id;
    private long gold;
    private int level;
    private String name;
    private String type;
    private String race;
    private ArrayList<Armor> armors;

    public Character(long id, long gold, int level, String name, String type, String race) {
        this.id = id;
        this.gold = gold;
        this.level = level;
        this.name = name;
        this.type = type;
        this.race = race;
        this.armors = new ArrayList<>();
    }

    public Character(long id, long gold, int level, String name, String type, String race, ArrayList<Armor> armors) {
        this.id = id;
        this.gold = gold;
        this.level = level;
        this.name = name;
        this.type = type;
        this.race = race;
        this.armors = armors;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGold() {
        return gold;
    }

    public void setGold(long gold) {
        this.gold = gold;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public ArrayList<Armor> getArmors() {
        return armors;
    }

    public void setArmors(ArrayList<Armor> armors) {
        this.armors = armors;
    }

    public Armor getSingleArmor(int index) {
        return armors.get(index);
    }

    public void setSingleArmor(Armor armor) {
        this.armors.add(armor);
    }

    @Override
    public String toString() {

        String armorsString = "";
        for(Armor armor : armors) {
            armorsString += armor.toString() + ", ";
        }

        String toString= "Character{" +
                "gold=" + gold +
                ", level=" + level +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", race='" + race + '\'' +
                ", armors={" + armorsString +
                '}';

        return toString;
    }
}
