package Week5.İçerik2.PatikaStore;

public abstract class Product {
    private  int id ;
    private  String  name;
    private  Brand brand;
    private  int  price;
    private int storage;
    private int ram;
    private double screenSize;

    public Product(int id, String name, Brand brand, int price, int storage, int ram, double screenSize) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.storage = storage;
        this.ram = ram;
        this.screenSize = screenSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }
}
