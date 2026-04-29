package rentalcars;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class VehicleManagerFE_GUI {

    private static VehicleManager vehicleManager = new VehicleManager();

    private static JPanel listPanel;
    
    //Display array
    private static Vehicle[] displayArray = new Vehicle[20];
    
   
    private static JTextField licensePlateField, yearField, priceField, numberOfSeatsField, gasTankSizeField, gasMilageField, cargoCapacityField, loadCapacityField,removeVehicleField;
    private static JComboBox<Manufacturer> manufacturerComboBox;
    private static JComboBox<Color> colorComboBox;
    private static JComboBox<Status> statusComboBox;
    private static JComboBox<Type> typeComboBox;
    
    
    private static boolean hideUnavailable = false;
    private static boolean priceSort = false;
    private static boolean seatSort = false;


    public static void main(String[] args) {

        JFrame frame = new JFrame("Vehicle Manager");
        frame.setSize(1500, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        

        // =========================
        // Input Panel
        // =========================
        JPanel inputPanel = new JPanel(null);
        inputPanel.setBounds(10, 10, 295, 310);
        inputPanel.setBorder(new TitledBorder("Vehicle Information"));
        frame.add(inputPanel);

        
        
        JLabel licensePlateLabel = new JLabel("License Plate:");
        licensePlateLabel.setBounds(15, 30, 100, 25);
        inputPanel.add(licensePlateLabel);

        licensePlateField = new JTextField();
        licensePlateField.setBounds(120, 30, 160, 25);
        inputPanel.add(licensePlateField);
        
        
        
        JLabel manufacturerLabel = new JLabel("Manufacturer:");
        manufacturerLabel.setBounds(15, 65, 100, 25);
        inputPanel.add(manufacturerLabel);

        manufacturerComboBox = new JComboBox<>(Manufacturer.values());
        manufacturerComboBox.setBounds(120, 65, 160, 25);
        inputPanel.add(manufacturerComboBox);

        
        
        JLabel yearLabel = new JLabel("Year:");
        yearLabel.setBounds(15, 100, 100, 25);
        inputPanel.add(yearLabel);

        yearField = new JTextField();
        yearField.setBounds(120, 100, 160, 25);
        inputPanel.add(yearField);

        
        
        JLabel colorLabel = new JLabel("Color:");
        colorLabel.setBounds(15, 135, 100, 25);
        inputPanel.add(colorLabel);

        colorComboBox = new JComboBox<>(Color.values());
        colorComboBox.setBounds(120, 135, 160, 25);
        inputPanel.add(colorComboBox);
        
        
        
        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setBounds(15, 170, 100, 25);
        inputPanel.add(priceLabel);
        
        priceField = new JTextField();
        priceField.setBounds(120, 170, 160, 25);
        inputPanel.add(priceField);
        
        
        
        JLabel numberOfSeatsLabel = new JLabel("Number of Seats:");
        numberOfSeatsLabel.setBounds(15, 205, 100, 25);
        inputPanel.add(numberOfSeatsLabel);
        
        numberOfSeatsField = new JTextField();
        numberOfSeatsField.setBounds(120, 205, 160, 25);
        inputPanel.add(numberOfSeatsField);
        
        
        
        JLabel gasTankSizeLabel = new JLabel("Gas Tank Size:");
        gasTankSizeLabel.setBounds(15, 240, 100, 25);
        inputPanel.add(gasTankSizeLabel);
        
        gasTankSizeField = new JTextField();
        gasTankSizeField.setBounds(120, 240, 160, 25);
        inputPanel.add(gasTankSizeField);
        
        
        
        JButton addVehicle = new JButton("Add Vehicle");
        addVehicle.setBounds(15, 275, 130, 25);
        inputPanel.add(addVehicle);
        
        addVehicle.addActionListener(e -> addVehicle());
   
        JButton clearVehicle = new JButton("Clear Vehicle");
        clearVehicle.setBounds(150, 275, 130, 25);
        inputPanel.add(clearVehicle);
        
        clearVehicle.addActionListener(e -> clearVehicleFields());


        // =========================
        // Optional Panel
        // =========================
        
        JPanel optionPanel = new JPanel(null);
        optionPanel.setBounds(10, 320, 295, 320);
        optionPanel.setBorder(new TitledBorder("Extra Options"));
        frame.add(optionPanel);

        
        	// =========================
        	// Car Sub-Panel
        	// =========================
        
        
        JPanel carPanel = new JPanel(null);
        carPanel.setBounds(10, 20, 275, 140);
        carPanel.setBorder(new TitledBorder("Car Information"));
        optionPanel.add(carPanel);
        
        
        
        JLabel gasMilageLabel = new JLabel("Gas Milage:");
        gasMilageLabel.setBounds(15, 30, 75, 25);
        carPanel.add(gasMilageLabel);
        
        gasMilageField = new JTextField();
        gasMilageField.setBounds(95, 30, 165, 25);
        carPanel.add(gasMilageField);
        
        
        
        JLabel typeLabel = new JLabel("Type:");
        typeLabel.setBounds(15, 65, 75, 25);
        carPanel.add(typeLabel);

        typeComboBox = new JComboBox<>(Type.values());
        typeComboBox.setBounds(95, 65, 165, 25);
        carPanel.add(typeComboBox);
        
        
        
        JButton addCar = new JButton("Add Car");
        addCar.setBounds(15, 100, 120, 25);
        carPanel.add(addCar);
        
        addCar.addActionListener(e -> addCar());
        
        JButton clearCar = new JButton("Clear Car");
        clearCar .setBounds(140, 100, 120, 25);
        carPanel.add(clearCar);
        
        clearCar.addActionListener(e -> clearCarFields());

        
        
        	// =========================
    		// Truck Sub-Panel
    		// =========================
        
        JPanel truckPanel = new JPanel(null);
        truckPanel.setBounds(10, 170, 275, 140);
        truckPanel.setBorder(new TitledBorder("Truck Information"));
        optionPanel.add(truckPanel);
        
        
        JLabel cargoCapacityLabel = new JLabel("Cargo Capacity:");
        cargoCapacityLabel.setBounds(15, 30, 100, 25);
        truckPanel.add(cargoCapacityLabel);
        
        cargoCapacityField = new JTextField();
        cargoCapacityField.setBounds(120, 30, 140, 25);
        truckPanel.add(cargoCapacityField);
        
        
        
        JLabel loadCapacityLabel = new JLabel("Load Capacity:");
        loadCapacityLabel.setBounds(15, 65, 100, 25);
        truckPanel.add(loadCapacityLabel);

        loadCapacityField = new JTextField();
        loadCapacityField.setBounds(120, 65, 140, 25);
        truckPanel.add(loadCapacityField);
        
        
        
        JButton addTruck = new JButton("Add Truck");
        addTruck.setBounds(15, 100, 120, 25);
        truckPanel.add(addTruck);
        
        addTruck.addActionListener(e -> addTruck());
        
        JButton clearTruck = new JButton("Clear Truck");
        clearTruck .setBounds(140, 100, 120, 25);
        truckPanel.add(clearTruck);
        
        clearTruck.addActionListener(e -> clearTruckFields());
        
        
        // =========================
        // Remove Vehicle Panel
        // =========================(10, 320, 295, 320)
                
        JPanel removePanel = new JPanel(null);
        removePanel.setBounds(10, 640, 295, 105);
        removePanel.setBorder(new TitledBorder("Remove Vehicle"));
        frame.add(removePanel);

        
        JLabel removeVehicleLabel = new JLabel("License Plate:");
        removeVehicleLabel.setBounds(15, 30, 100, 25);
        removePanel.add(removeVehicleLabel);

        removeVehicleField = new JTextField();
        removeVehicleField.setBounds(120, 30, 160, 25);
        removePanel.add(removeVehicleField);
        
        
        
        JButton removeVehicle = new JButton("Remove Vehicle");
        removeVehicle.setBounds(15, 65, 130, 25);
        removePanel.add(removeVehicle);
        
        removeVehicle.addActionListener(e -> removeVehicle());

        // =========================
        // Filter Panel
        // =========================
        JPanel filterPanel = new JPanel(null);
        filterPanel.setBounds(370, 10, 360, 80);
        filterPanel.setBorder(new TitledBorder("Filter By:"));
        frame.add(filterPanel);


        
        //Clear Filter or show all
        JButton allButton = new JButton("Show All:");
        allButton.setBounds(10, 25, 110, 30);
        filterPanel.add(allButton);
        
        allButton.addActionListener(e -> {
        	priceSort = false;
            seatSort = false;
            hideUnavailable = false;
            updateDisplay();
        });
        
        
        
        JButton priceButton = new JButton("Price");
        priceButton.setBounds(125, 25, 100, 30);
        filterPanel.add(priceButton);
        
        priceButton.addActionListener(e -> {
        	priceSort = true;
        	seatSort = false;
        	updateDisplay();
        });
        
        
        
        JButton seatButton = new JButton("Seats");
        seatButton.setBounds(230, 25, 100, 30);
        filterPanel.add(seatButton);
        
        seatButton.addActionListener(e -> {
        	priceSort = false;
        	seatSort = true;
        	updateDisplay();
        });
        
        JCheckBox hiddenCheckBox = new JCheckBox("Hide Unavailable");
        hiddenCheckBox.setBounds(10, 55, 150, 20);
        filterPanel.add(hiddenCheckBox);
        
        hiddenCheckBox.addActionListener(e -> {
        	hideUnavailable = hiddenCheckBox.isSelected();
            updateDisplay();
        });

        // =========================
        // Display Panel
        // =========================
        JPanel displayPanel = new JPanel(null);
        displayPanel.setBounds(370, 100, 1150, 600);
        displayPanel.setBorder(new TitledBorder("Vehicle Records"));
        frame.add(displayPanel);

        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setBounds(15, 25, 1100, 550);
        
        displayPanel.add(scrollPane);

        

        frame.setVisible(true);
    }

    private static void addVehicle() {
        String licensePlate = licensePlateField.getText();
        Manufacturer selectedManufacturer = (Manufacturer) manufacturerComboBox.getSelectedItem();
        int year = Integer.parseInt(yearField.getText());
        Color selectedColor = (Color) colorComboBox.getSelectedItem();
        double price = Double.parseDouble(priceField.getText());
        int numberOfSeats = Integer.parseInt(numberOfSeatsField.getText());
        int gasTankSize = Integer.parseInt(gasTankSizeField.getText());
        

        vehicleManager.addVehicle(new Vehicle(licensePlate, selectedManufacturer, year, selectedColor, price, numberOfSeats, Status.WORKING, gasTankSize));

        
        JOptionPane.showMessageDialog(
                null,
                "Vehicle '" + licensePlate + "' has been added.\n",
                "Added",
                JOptionPane.INFORMATION_MESSAGE
        );

        
        updateDisplay();
        
    }
    
    private static void addCar() {
        String licensePlate = licensePlateField.getText();
        Manufacturer selectedManufacturer = (Manufacturer) manufacturerComboBox.getSelectedItem();
        int year = Integer.parseInt(yearField.getText());
        Color selectedColor = (Color) colorComboBox.getSelectedItem();
        double price = Double.parseDouble(priceField.getText());
        int numberOfSeats = Integer.parseInt(numberOfSeatsField.getText());
        int gasTankSize = Integer.parseInt(gasTankSizeField.getText());
        double gasMilage = Double.parseDouble(gasMilageField.getText());
        Type selectedType = (Type) typeComboBox.getSelectedItem();
        

        vehicleManager.addVehicle(new Car(licensePlate, selectedManufacturer, year, selectedColor, price, numberOfSeats, Status.WORKING, gasTankSize, gasMilage, selectedType));

        
        JOptionPane.showMessageDialog(
                null,
                "Car '" + licensePlate + "' has been added.\n",
                "Added",
                JOptionPane.INFORMATION_MESSAGE
        );

        
        updateDisplay();
        
    }
    
    private static void addTruck() {
        String licensePlate = licensePlateField.getText();
        Manufacturer selectedManufacturer = (Manufacturer) manufacturerComboBox.getSelectedItem();
        int year = Integer.parseInt(yearField.getText());
        Color selectedColor = (Color) colorComboBox.getSelectedItem();
        double price = Double.parseDouble(priceField.getText());
        int numberOfSeats = Integer.parseInt(numberOfSeatsField.getText());
        int gasTankSize = Integer.parseInt(gasTankSizeField.getText());
        double cargoCapacity = Double.parseDouble(cargoCapacityField.getText());
        double loadCapacity = Double.parseDouble(loadCapacityField.getText());
        

        vehicleManager.addVehicle(new Truck(licensePlate, selectedManufacturer, year, selectedColor, price, numberOfSeats, Status.WORKING, gasTankSize, cargoCapacity, loadCapacity));

        
        JOptionPane.showMessageDialog(
                null,
                "Truck '" + licensePlate + "' has been added.\n",
                "Added",
                JOptionPane.INFORMATION_MESSAGE
        );

        
        updateDisplay();
        
    }

    private static void removeVehicle() {
        String licensePlate = removeVehicleField.getText();
        vehicleManager.removeVehicle(licensePlate);

        JOptionPane.showMessageDialog(
                null,
                "Vehicle '" + licensePlate + "' has been removed from the database.",
                "Removed",
                JOptionPane.INFORMATION_MESSAGE
        );

       
        updateDisplay();
    }

    private static void updateDisplay() {
    	
    	if (priceSort) {
            vehicleManager.sortbyPrice(displayArray, hideUnavailable);
        }
        else if (seatSort) {
            vehicleManager.sortbyNumberOfSeats(displayArray, hideUnavailable);
        }
        else {
            vehicleManager.fillDisplayArray(displayArray, hideUnavailable);
        }
        
    	listPanel.removeAll();
    	
    	for(int i = 0; i < displayArray.length; i++) {
    		if(displayArray[i] != null) {
    			listPanel.add(createVehicleDisplayRow(displayArray[i]));
    		}
    	};
    	}
    	
    	listPanel.revalidate();
    	listPanel.repaint();
    	
    }
    
    
    private static JPanel createVehicleDisplayRow(Vehicle vV) {
    	
    	JPanel row = new JPanel(new BorderLayout());
    	row.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
    	
    	row.setPreferredSize(new Dimension(1100, 30));
    	row.setMaximumSize(new Dimension(Short.MAX_VALUE, 30));
    	row.setMinimumSize(new Dimension(0, 30));
    	
    	JLabel info = new JLabel(vV.toString());
    	
    	info.setFont(new Font("SansSerif", Font.PLAIN, 11));
    	
    	info.setVerticalAlignment(SwingConstants.CENTER);
        info.setHorizontalAlignment(SwingConstants.LEFT);
    	
    	row.add(info, BorderLayout.CENTER);
    	
    	JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT, 3, 2));
    	
    	//Add Reservation
    	JButton addReservation = new JButton("Add Reservation");
    	addReservation.addActionListener(e -> {
    		String name = JOptionPane.showInputDialog("Enter Name:");
    		if(name != null && !name.isBlank()) {
    			vV.addReservation(name);
    			updateDisplay();
    		}
    		
    	});
    	
    	//Return
    	JButton returnVehicle = new JButton("Return Vehicle");
    	returnVehicle.addActionListener(e -> {
    		vV.removeReservation();
    		updateDisplay();
    	});
    	
    	//Remove Name
    	JButton removeName = new JButton("Remove Name");
    	removeName.addActionListener(e -> {
    		String name = JOptionPane.showInputDialog("Enter Name:");
    		if(name != null && !name.isBlank()) {
    			vV.removeReservation(name);
    			updateDisplay();
    		}
    	});
    	
    	//All Information
    	JButton moreInfo = new JButton("More Info");
    	moreInfo.addActionListener(e -> {
    		JOptionPane.showMessageDialog(null, vV.toStringAll(), "Vehicle Info:", JOptionPane.INFORMATION_MESSAGE);
    	});
    	
    	JButton changeStatus = new JButton("Status");
    	changeStatus.addActionListener(e -> {
    		Status statusChanged = (Status) JOptionPane.showInputDialog(null, "Select Status:", "Change Status", JOptionPane.QUESTION_MESSAGE, null, Status.values(), vV.getStatus());
    		
    		if(statusChanged != null) {
    			vV.setStatus(statusChanged);
    			updateDisplay();
    		}
    	});
    	
    	actions.add(addReservation);
    	actions.add(returnVehicle);
    	actions.add(removeName);
    	actions.add(moreInfo);
    	actions.add(changeStatus);
    	
    	row.add(actions, BorderLayout.EAST);
    	
    	return row;
    }

    private static void clearVehicleFields() {
        licensePlateField.setText("");
        manufacturerComboBox.setSelectedIndex(0);
        yearField.setText("");
        colorComboBox.setSelectedIndex(0);
        priceField.setText("");
        numberOfSeatsField.setText("");
        gasTankSizeField.setText("");
    }
    
    private static void clearCarFields() {
    	gasMilageField.setText("");
    	typeComboBox.setSelectedIndex(0);
    }
    
    private static void clearTruckFields() {
    	cargoCapacityField.setText("");
    	loadCapacityField.setText("");
    }

}
