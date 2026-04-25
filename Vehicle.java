package rentalcars;

public class Vehicle {
	
	private static final int MAX_RESERVATIONS = 10;
	
	private String licensePlate;
	private Manufacturer manufacturer;
	private int year;
	private Color color;
	private double price;
	private int numberOfSeats;
	private Status status;
	private boolean available;
	private int gasTankSize;
	private String[] reservations;
	private int waiting;
	

	//Default Constructor
	public Vehicle() {
		this.licensePlate = "~~~~~~~";
		this.manufacturer = Manufacturer.OTHER;
		this.year = 2000;
		this.color = Color.OTHER;
		this.price = 100.00;
		this.numberOfSeats = 4;
		this.status = Status.WORKING;
		this.available = true;
		this.gasTankSize = 12;
		this.reservations = new String[MAX_RESERVATIONS];
		this.waiting = 0;
	}
	
	//Parameterized Constructor
	public Vehicle(String sL, Manufacturer mM, String sM, int iY, Color cC, double dP, int iN, Status sS, int iG) {
		this.setLicensePlate(sL);
		this.setManufacturer(mM);
		this.setYear(iY);
		this.setColor(cC);
		this.setPrice(dP);
		this.setNumberOfSeats(iN);
		this.setStatus(sS);
		this.setGasTankSize(iG);
		this.reservations = new String[MAX_RESERVATIONS];
		this.available = true;
		this.waiting = 0;
	}
	
	
	//Accessors
	public String getLicensePlate() {
		return this.licensePlate;
	}
	
	public Manufacturer getManufacturer() {
		return this.manufacturer;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public int getNumberOfSeats() {
		return this.numberOfSeats;
	}
	
	public Status getStatus() {
		return this.status;
	}
	
	public boolean isAvailable() {
		return this.available;
	}
	
	public int getGasTankSize() {
		return this.gasTankSize;
	}
	
	public int getWaiting() {
		return this.waiting;
	}
	
	//Return all reserved users/names
	public String getReservations() {
		//StringBuilder - can convert array of string to a string
		StringBuilder gR = new StringBuilder();
		
		//Check if empty
		if(this.waiting == 0) {
			return "No Reservations";
		}
		
		//Print current user
		gR.append("Current: " + this.reservations[0]);
		
		//Only print if there are people in the waiting reservation
		if(this.waiting > 1) {
			gR.append(" Waiting:");
			
			//Add each one in waiting
			for(int i = 1; i < waiting; i++) {
				gR.append(" " + i + ". " + this.reservations[i]);
			}
			
		}
		
		//Convert to string and return
		return gR.toString();
	}
	
	//Get the current driver/renter
	public String getCurrent() {
		
		if(getWaiting() > 0 && (this.reservations[0] != null && !this.reservations[0].isEmpty())) {
			return this.reservations[0];
		}else {
			return "No reservations";
		}
	}
	
	//Mutators
	public void setLicensePlate(String sL) {
		if(sL != null && !sL.isEmpty()) {
			this.licensePlate = sL;
		}else {
			this.licensePlate = "~~~~~~~";
		}
	}
	
	public void setManufacturer(Manufacturer mM) {
		if(mM != null) {
			this.manufacturer = mM;
		}else {
			this.manufacturer = Manufacturer.OTHER;
		}
	}
	
	public void setYear(int iY) {
		if(iY >= 1900) {
			this.year = iY;
		}
	}
	
	public void setColor(Color cC) {
		if(cC != null) {
			this.color = cC;
		}else {
			this.color = Color.OTHER;
		}
	}
	
	public void setPrice(double dP) {
		if(dP >= 0) {
			this.price = dP;
		}else {
			this.price = 100.00;
		}
	}
	
	public void setNumberOfSeats(int iN) {
		if(iN > 0) {
			this.numberOfSeats = iN;
		}else {
			this.numberOfSeats = 4;
		}
	}
	
	public void setStatus(Status sS) {
		if(sS != null) {
			this.status = sS;
		}else {
			this.status = Status.WORKING;
		}
	}
	
	public void setGasTankSize(int iG) {
		if(iG >= 0) {
			this.gasTankSize = iG;
		}else {
			this.gasTankSize = 12;
		}
	}
	
	//Update Availability Boolean
	public void updateAvailability() {
		if(this.waiting == 0 && this.status == Status.WORKING) {
			this.available = true;
		}else {
			this.available = false;
		}
	}
	
	//Reservation Mutators
	//Add a string (name) to reservations array
	public void addReservation(String sR) {
		if(sR != null && !sR.isEmpty() && this.waiting < MAX_RESERVATIONS) {
			this.reservations[this.waiting] = sR;
		
		
			//Decrease waiting
			this.waiting  = this.waiting + 1;
			
			//Update availability
			this.updateAvailability();
		}
	}
	
	//Remove the current reservation
	public void removeReservation() {
		
		if(this.waiting > 0) {
		
			//Overwrites current renter/driver
			for(int i = 0; i < waiting - 1; i++) {
				reservations[i] = reservations[i+1];
			}
			
			//Remove duplicated 
			this.reservations[this.waiting - 1 ] = null;
			
			//Decrease waiting
			this.waiting  = this.waiting - 1;
			
			//Update availability 
			this.updateAvailability();
			
		}
	}
	
	//Remove name from array
	public void removeReservation(String sN) {
		
		if(sN == null || sN.isEmpty()) {
			return;
		}
		
		boolean replace = false;
		
		for(int i = 0; i < this.waiting && !replace; i++) { 
			
			if(sN.equalsIgnoreCase(this.reservations[i])) {
				
				replace = true;
				
				for(int j = i; j < this.waiting - 1; j++) {
					this.reservations[j] = this.reservations[j+1];
				}
			}
		}
		
		if(replace) {
			this.reservations[this.waiting - 1 ] = null;
			
			//Decrease waiting
			this.waiting  = this.waiting - 1;
		}
				
		//Update availability 
		this.updateAvailability();
		
	}
	
	//ToString Method(s?) (Placeholder)
	public String toString() {
		return "";
	}
	
	
	
	
	
	
	

}
