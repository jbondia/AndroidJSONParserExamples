package com.jbondia.basicjsonparser.model;

/**
 * Created by jbondia on 10/03/15.
 */
public class Armor {

    private int level;
    private String name;

    public Armor(int level, String name) {
        this.level = level;
        this.name = name;
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

    @Override
    public String toString() {
        return "{" +
                "level=" + level +
                ", name='" + name + '\'' +
                '}';
    }
}
