package Week5.İçerik2.PatikaStore;

public class Notebook extends Product {
    public Notebook(int id, String name, Brand brand, int price, int storage, int ram, double screenSize) {
        super(id, name, brand, price, storage, ram, screenSize);
    }

    @Override
    public String toString() {
        return String.format("| %d | %s | %d | %s | %d | %.1f | %d |",
                this.getId(),
                this.getName(),
                this.getPrice(),
                this.getBrand().getName(), // Assuming Brand class has a getName() method
                this.getStorage(),
                this.getScreenSize(),
                this.getRam());
    }
}
