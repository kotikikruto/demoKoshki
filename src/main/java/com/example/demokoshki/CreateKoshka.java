package com.example.demokoshki;

import java.util.ArrayList;

public class CreateKoshka {

    static int counter = 0;
    int id;
    String name;
    String fur;
    String colourFur;
    String colourEye;
    String stripped;
    String gender;

    String genome;


    public CreateKoshka(String name, String fur, String colourFur, String colourEye, String stripped, String gender) {
        id = counter;
        counter += 1;
        this.name = name;
        this.fur = fur;
        this.colourFur = colourFur;
        this.colourEye = colourEye;
        this.stripped = stripped;
        this.gender = gender;
        genome = "genome"; // TODO ну как-то из бэдэ достать геном

    }

    public CreateKoshka(String name, String fur, String colourFur, String colourEye, String stripped, String gender, String genome) {
        id = counter;
        counter += 1;
        this.name = name;
        this.fur = fur;
        this.colourFur = colourFur;
        this.colourEye = colourEye;
        this.stripped = stripped;
        this.gender = gender;
        this.genome = genome;

    }


    public int getId() { return id; }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

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

    public String getGenome(){
        return genome;
    }

    @Override
    public String toString() {
        return name;
    }

}