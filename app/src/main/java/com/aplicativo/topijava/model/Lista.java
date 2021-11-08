package com.aplicativo.topijava.model;

import java.util.List;

public class Lista {

    private List<Data> items;

    public Lista(List<Data> items){
        this.items = items;
    }

    public List<Data> getItems(){
        return items;
    }
    public void setItems(List<Data> items){
        this.items = items;
    }
}
