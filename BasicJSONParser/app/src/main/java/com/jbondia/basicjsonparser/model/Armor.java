package com.jbondia.basicjsonparser.model;

import java.io.Serializable;

/**
 * Created by jbondia on 10/03/15.
 */
public class Armor implements Serializable {

    private long id;
    private int level;
    private String name;

    public Armor(long id, int level, String name) {
        this.id = id;
        this.level = level;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return "Name: " + name + "\nLevel: " + level;
    }
}
