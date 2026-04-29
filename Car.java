package FinalProject;

public class Car extends Vehicles {

    private double gasMileage;
    private Type type;

    public Car() {
        super();
        this.gasMileage = 25.0;
        this.type = Type.SEDAN;
    }

    public Car(String name, Manufacturer manufacturer, int year, Color color,
               double price, int numberOfSeats, Status status,
               int gasTankSize, double gasMileage, Type type) {

        super(name, manufacturer, year, color, price, numberOfSeats, status, gasTankSize);
        this.setGasMileage(gasMileage);
        this.setType(type);
    }

    public double getGasMileage() {
        return this.gasMileage;
    }

    public Type getType() {
        return this.type;
    }

    public void setGasMileage(double gasMileage) {
        if (gasMileage >= 0) {
            this.gasMileage = gasMileage;
        } else {
            this.gasMileage = 25.0;
        }
    }

    public void setType(Type type) {
        if (type != null) {
            this.type = type;
        } else {
            this.type = Type.SEDAN;
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
	        "%-7s: %-10s | %-8s | Price: $%8.2f | Seats: %2d | MPG: %5.1f | Type: %-10s | Status: %-10s",
	        "Car",
	        this.getLicensePlate(),
	        availabilityText,
	        this.getPrice(),
	        this.getNumberOfSeats(),
	        this.getGasMileage(),
	        this.getType(),
	        this.getStatus()
	    );
    }
    
    @Override
    public String toStringAll() {
    	
    	return super.toStringAll() +
    		   "\nGas Mileage: " + this.getGasMileage() +
    	       "\nType: " + this.getType();
    }
}
