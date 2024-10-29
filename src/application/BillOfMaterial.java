package application;

import java.util.ArrayList;

//Describes BillOfMaterial objects. Bill of Materials are made up of different Part objects
public class BillOfMaterial {

    private String id;
    private String name;
    private ArrayList<Part> partList;
    private String bomDesc;
    private double totalCost;

    public BillOfMaterial(String id, String name, String bomDesc, double totalCost, ArrayList<Part> partList) {
        this.id = id;
        this.name = name;
        this.bomDesc = bomDesc;
        this.totalCost = totalCost;
        this.partList = partList;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<Part> getPartList() {
        return partList;
    }
    public String getBomDesc() {
        return bomDesc;
    }
    public void setBomDesc(String bomDesc) {
        this.bomDesc = bomDesc;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public ArrayList<String> partNames() {
        ArrayList<String> partNames = new ArrayList<>();
        for (Part part : partList) {
            partNames.add(part.getName());
        }
        return partNames;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name)
                .append("\nID: ").append(id)
                .append("\nBOM Description: ").append(bomDesc)
                .append("\nTotal Cost: ").append(totalCost)
                .append("\nPart List: ").append(partNames());
        return sb.toString();
    }
}
