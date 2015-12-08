package model;

import java.util.ArrayList;

public class Categorie {
    
    private ArrayList<String> listLibelleFR;
    private ArrayList<String> listLibelleEN;

    public Categorie() {
        listLibelleFR = new ArrayList<>();
        listLibelleEN = new ArrayList<>();
    }

    public ArrayList<String> getListLibelleFR() {
        return listLibelleFR;
    }

    public ArrayList<String> getListLibelleEN() {
        return listLibelleEN;
    }
    
    public void addListLibelleFR(String lib) {
        listLibelleFR.add(lib);
    }
    
    public void addListLibelleEN(String lib) {
        listLibelleEN.add(lib);
    }
}
