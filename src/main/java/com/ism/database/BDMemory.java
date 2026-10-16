package com.ism.database;

import java.util.List;

import com.ism.entity.Produit;

public class BDMemory implements Database {
    private static BDMemory instance = null;

    private BDMemory() {}

    public static BDMemory getInstance() {
        if (instance == null) {
            instance = new BDMemory();
        }
        return instance;
    }

    @Override
    public void createConnexion() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Produit insert(Produit produit) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Produit> getProduits() {
        // TODO Auto-generated method stub
        return null;
    }
    

}
