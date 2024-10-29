package application;

import java.util.ArrayList;

public class BOMWarehouse {

    private ArrayList<BillOfMaterial> billOfMaterials;

    public BOMWarehouse() {
        billOfMaterials = new ArrayList<>();
    }

    public void add(BillOfMaterial billOfMaterial) {
        billOfMaterials.add(billOfMaterial);
    }

    public BillOfMaterial getBOMByName(String name) {
        for (BillOfMaterial bom : billOfMaterials) {
            if (bom.getName().equals(name)) {
                return bom;
            }
        }
        return null;
    }


    public int size(){
        return billOfMaterials.size();
    }

}
