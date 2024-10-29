package application;

import java.util.ArrayList;


// The Warehouse object will be used to house ALL parts

public class Warehouse {

    private ArrayList<Part> allParts;

    public Warehouse() {
        allParts = new ArrayList<>();
    }

    public void add(Part part) {
        allParts.add(part);
    }

    public Part getPartByName(String name) {
        for (Part part : allParts) {
            if (part.getName().equals(name)) {
                return part;
            }
        }
        return null;
    }


    public int size(){
        return allParts.size();
    }


}
