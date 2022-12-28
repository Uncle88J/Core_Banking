package com.tosan.core.db;

public class emp {
    int id;
    String name;
    String family;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public void setId(int id) {
        this.id = id;

    }

    public void setName(String name) {
        this.name = name;

    }

    public emp(int id, String name, String family) {
        this.id = id;
        this.name = name;
        this.family = family;
    }

    public emp setFamily(String family) {
        this.family = family;
        return this;
    }


}