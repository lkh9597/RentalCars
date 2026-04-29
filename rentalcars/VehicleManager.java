package rentalcars;

public class VehicleManager {
    private Vehicle[] vehicles;
    public static final int DEFSIZE = 10;

    public VehicleManager() {
        init(DEFSIZE);
    }

    public VehicleManager(int size) {
        init(size);
    }

    private void init(int size) {
        if (size > 1) {
            vehicles = new Vehicle[size];
        } else {	
            vehicles = new Vehicle[DEFSIZE];
        }
    }

    public boolean addVehicle(Vehicle vehicle) {
        if (vehicle == null || vehicle.getLicensePlate() == null || vehicle.getLicensePlate().trim().isEmpty()) {
            return false;
        }

        String vehicleName = vehicle.getLicensePlate().trim();

        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] != null &&
                vehicles[i].getLicensePlate() != null &&
                vehicles[i].getLicensePlate().trim().equalsIgnoreCase(vehicleName)) {
                return false;
            }
        }

        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] == null) {
                vehicles[i] = vehicle;
                return true;
            }
        }

        return false;
    }

    public boolean removeVehicle(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }

        name = name.trim();
        int removeIndex = -1;

        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] != null &&
                vehicles[i].getLicensePlate() != null &&
                vehicles[i].getLicensePlate().trim().equalsIgnoreCase(name)) {
                removeIndex = i;
                break;
            }
        }

        if (removeIndex == -1) {
            return false;
        }

        for (int i = removeIndex; i < vehicles.length - 1; i++) {
            vehicles[i] = vehicles[i + 1];
        }

        vehicles[vehicles.length - 1] = null;
        return true;
    }

    public Vehicle searchVehicle(String name) {
        if (name == null || name.trim().isEmpty()) {
            return null;
        }

        name = name.trim();

        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] != null &&
                vehicles[i].getLicensePlate() != null &&
                vehicles[i].getLicensePlate().trim().equalsIgnoreCase(name)) {
                return vehicles[i];
            }
        }

        return null;
    }
    
    public void fillDisplayArray(Vehicle[] displayArray, boolean hideUnavailable) {
    	
    	int index = 0;
    	
    	//Add applicable indexes to doisplayArray
    	for(int i = 0; i < vehicles.length; i++) {
    		if(vehicles[i] != null) {
    			if(!hideUnavailable || vehicles[i].isAvailable()) {
    				displayArray[index] = vehicles[i];
    				index++;
    			}
    		}
    	}
    	
    	//Nullify rest of array
    	for(int i = index; i <displayArray.length; i++) {
    		displayArray[i] = null;
    	}
    }
    
    public void sortbyPrice(Vehicle[] displayArray, boolean hideUnavailable) {
    	
    	fillDisplayArray(displayArray, hideUnavailable);
    	
    	
    	boolean swapped = true;
    	
    	while(swapped) {
    		swapped = false;

            for (int i = 0; i < displayArray.length - 1; i++) {
                if (displayArray[i] == null || displayArray[i + 1] == null) {
                    continue;
                }

                if (displayArray[i].getPrice() > displayArray[i + 1].getPrice()) {
                    Vehicle temp = displayArray[i];
                    displayArray[i] = displayArray[i + 1];
                    displayArray[i + 1] = temp;
                    swapped = true;
                }
            }
    	}
    }
    	
    public void sortbyNumberOfSeats(Vehicle[] displayArray, boolean hideUnavailable) {
        	
       	fillDisplayArray(displayArray, hideUnavailable);
        	
        	
       	boolean swapped = true;
        	
       	while(swapped) {
        	swapped = false;
            for (int i = 0; i < displayArray.length - 1; i++) {
            	if (displayArray[i] == null || displayArray[i + 1] == null) {
            		continue;
                }

                if (displayArray[i].getNumberOfSeats() > displayArray[i + 1].getNumberOfSeats()) {
                    Vehicle temp = displayArray[i];
                    displayArray[i] = displayArray[i + 1];
                    displayArray[i + 1] = temp;
                    swapped = true;
                }
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 

    
}