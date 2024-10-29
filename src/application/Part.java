package application;


//Describes Part object
public class Part {

    private String id;
    private String name;
    private double price;
    private int stock;
    private String partType;
    private double weight;
    private String manufacturer;
    private String supplier;

    //Will allow the user to enter the part without setting a stock value. Stock will automatically be set to 0
    public Part(String id, String name, double price, String partType, double weight, String manufacturer, String supplier) {
        this(id, name, price, 0, partType, weight, manufacturer, supplier);
    }

    public Part(String id, String name, double price, int stock, String partType, double weight, String manufacturer, String supplier) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.partType = partType;
        this.weight = weight;
        this.manufacturer = manufacturer;
        this.supplier = supplier;
    }


    //Setters and Getters for instance variables

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
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public String getPartType() {
        return partType;
    }
    public void setPartType(String partType) {
        this.partType = partType;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getSupplier() {
        return supplier;
    }
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String toString() {
        return "Part Info: " +  "\n ID:" + id + "\n Name: " + name + "\n Price: " + price + "\n Stock: " + getStock() + "\n Type: " + partType + "\n Weight: " + weight +
                "\n Manufacturer: " + manufacturer + "\n Supplier: " + supplier;
        }


}
