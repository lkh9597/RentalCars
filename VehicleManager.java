package FinalProject;

public class VehicleManager {
    private Vehicles[] vehicles;
    public static final int DEFSIZE = 10;

    public VehicleManager() {
        init(DEFSIZE);
    }

    public VehicleManager(int size) {
        init(size);
    }

    private void init(int size) {
        if (size > 1) {
            vehicles = new Vehicles[size];
        } else {	
            vehicles = new Vehicles[DEFSIZE];
        }
    }

    public boolean addVehicle(Vehicles vehicle) {
        if (vehicle == null || vehicle.getName() == null || vehicle.getName().trim().isEmpty()) {
            return false;
        }

        String vehicleName = vehicle.getName().trim();

        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] != null &&
                vehicles[i].getName() != null &&
                vehicles[i].getName().trim().equalsIgnoreCase(vehicleName)) {
                return false;
            }
        }

        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] == null) {
                vehicles[i] = vehicle;
                sortVehiclesByAge();
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
                vehicles[i].getName() != null &&
                vehicles[i].getName().trim().equalsIgnoreCase(name)) {
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

    public Vehicles searchVehicle(String name) {
        if (name == null || name.trim().isEmpty()) {
            return null;
        }

        name = name.trim();

        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] != null &&
                vehicles[i].getName() != null &&
                vehicles[i].getName().trim().equalsIgnoreCase(name)) {
                return vehicles[i];
            }
        }

        return null;
    }
// //7 digits and numbers CGE3514 // No need
//    This is not working / needs to be corrected 
//    public void sortVehiclesLiscense() {
//        boolean swapped;
//        do {
//            swapped = false;
//            for (int i = 0; i < vehicles.length - 1; i++) {
//                if (vehicles[i] == null || vehicles[i + 1] == null) {
//                    continue;
//                }
//
//                if (vehicles[i].getAge() > vehicles[i + 1].getAge()) {
//                    Vehicles temp = vehicles[i];
//                    vehicles[i] = vehicles[i + 1];
//                    vehicles[i + 1] = temp;
//                    swapped = true;
//                }
//            }
//        } while (swapped);
//    }

    public boolean removeVehicle(String name) {
    	if(name == null|| name) {
    		return false;
    	}
    	
    	boolean removed = false;
    	name = name;
    	
    	for(int i = 0; i < vehicles.length && !removed; i++) {
    		if(vehicles[i] != null && vehicles[i].getName() != null && vehicles[i].getName().equalsIgnoreCase(name)) {
    			removed = true;
    			
    			for(int j = i; j<vehicles.length - 1; j++) {
    				behicles[j] = vehicles[j+1];
    			}
    		}
    	}
    	if(removed) {
    		vehicles = null;
    	}
    	
    	return removed;
    }
    
    public Vehicles[] getAllVehicles() {
        return vehicles;
    }
    
}