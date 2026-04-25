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
               int gasTankSize, int miles, double gasMileage, Type type) {

        super(name, manufacturer, year, color, price, numberOfSeats, status, gasTankSize, miles);
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

    public String toString() {
        return "CAR\n" +
               super.toString() +
               "\nGas Mileage: " + this.gasMileage +
               "\nType: " + this.type;
    }
}
