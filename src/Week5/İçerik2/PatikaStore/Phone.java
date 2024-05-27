package Week5.İçerik2.PatikaStore;

public class Phone extends Product {
    private int batteryPower;
    private String colour;
    private int camera;

    public Phone(int id, String name, Brand brand, int price, int storage, int ram, double screenSize, int batteryPower, String colour, int camera) {
        super(id, name, brand, price, storage, ram, screenSize);
        this.batteryPower = batteryPower;
        this.colour = colour;
        this.camera = camera;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    @Override
    public String toString() {
        return String.format("| %d | %s | %d | %s | %d | %.1f | %d | %d | %d | %s |",
                this.getId(),
                this.getName(),
                this.getPrice(),
                this.getBrand().getName(), // Assuming Brand class has a getName() method
                this.getStorage(),
                this.getScreenSize(),
                this.getCamera(),
                this.getBatteryPower(),
                this.getRam(),
                this.getColour());
    }
}
