package com.example.demokoshki;

public class CreateKoshka {

    static int counter = 0;
    int id;
    String name;
    String fur;
    String colourFur;
    String colourEye;
    String stripped;
    String gender;



    public CreateKoshka(String name, String fur, String colourFur, String colourEye, String stripped, String gender) {
        id = counter;
        counter += 1;
        this.name = name;
        this.fur = fur;
        this.colourFur = colourFur;
        this.colourEye = colourEye;
        this.stripped = stripped;
        this.gender = gender;

    }

    public int getId() { return id; }

    public String getName() {
        return name;
    }

    public String getFur() {
        return fur;
    }

    public String getStripped() {
        return stripped;
    }

    public String getColourFur() {
        return colourFur;
    }

    public String getColourEye() {
        return colourEye;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return name;
    }
}