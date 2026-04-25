package FinalProject;

public class Truck extends Vehicles {

    private double loadCapacity;
    private double cargoCapacity;

    public Truck() {
        super();
        this.loadCapacity = 1000.0;
        this.cargoCapacity = 100.0;
    }

    public Truck(String name, Manufacturer manufacturer, int year, Color color,
                 double price, int numberOfSeats, Status status,
                 int gasTankSize, int miles, double loadCapacity, double cargoCapacity) {

        super(name, manufacturer, year, color, price, numberOfSeats, status, gasTankSize, miles);
        this.setLoadCapacity(loadCapacity);
        this.setCargoCapacity(cargoCapacity);
    }

    public double getLoadCapacity() {
        return this.loadCapacity;
    }

    public double getCargoCapacity() {
        return this.cargoCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        if (loadCapacity >= 0) {
            this.loadCapacity = loadCapacity;
        } else {
            this.loadCapacity = 1000.0;
        }
    }

    public void setCargoCapacity(double cargoCapacity) {
        if (cargoCapacity >= 0) {
            this.cargoCapacity = cargoCapacity;
        } else {
            this.cargoCapacity = 100.0;
        }
    }

    public String toString() {
        return "TRUCK\n" +
               super.toString() +
               "\nLoad Capacity: " + this.loadCapacity +
               "\nCargo Capacity: " + this.cargoCapacity;
    }
}
