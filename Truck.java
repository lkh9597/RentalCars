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
                 int gasTankSize, double loadCapacity, double cargoCapacity) {

        super(name, manufacturer, year, color, price, numberOfSeats, status, gasTankSize);
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

    @Override
    public String toString() {
    	String availabilityText;
		
		if(this.isAvailable()) {
			availabilityText =  "Free";
		}else {
			availabilityText = "Rented";
		}

	    return String.format(
	        "%-7s: %-10s | %-8s | Price: $%8.2f | Seats: %2d | Cargo: %6.1f | Load: %6.1f | Status: %-10s",
	        "Truck",
	        this.getLicensePlate(),
	        availabilityText,
	        this.getPrice(),
	        this.getNumberOfSeats(),
	        this.getCargoCapacity(),
	        this.getLoadCapacity(),
	        this.getStatus()
	    );
    }
    
    @Override
    public String toStringAll() {
    	
    	return super.toStringAll() +
    		   "\nCargo Capacity: " + this.getCargoCapacity() +
    	       "\nLoad Capacity: " + this.getLoadCapacity();
    }
}
