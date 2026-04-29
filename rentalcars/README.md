Rental Vehicle Manager
A simple Java Swing application for managing a small vehicle rental system using a graphical user interface (GUI). This project demonstrates object-oriented programming (OOP) principles, inheritance, enums, array-based data management, GUI development, and event handling. It is designed as a final course project and compatible with Eclipse IDE.
Table of Contents
· Overview
· Key Features
· Requirements
· Getting Started in Eclipse
· How to Use
· UML Diagram
· Testing Checklist
· Future Enhancements
· Credits
· License
Overview
Rental Vehicle Manager allows users to add, remove, sort, filter, reserve, return, and view vehicles. The program supports general vehicles, cars, and trucks. Each vehicle includes a license plate, manufacturer, year, color, price, number of seats, status, gas tank size, and reservation information.
The program uses a separate manager/controller class to store and organize vehicle objects, while the GUI class provides the front end for user interaction. The Car and Truck classes extend the parent Vehicle class, which helps avoid repeated code and demonstrates inheritance.
Main Java concepts illustrated:
•	Classes and encapsulation using Vehicle, Car, Truck, and VehicleManager
•	Inheritance through Car extends Vehicle and Truck extends Vehicle
•	Enums for Manufacturer, Color, Status, and Type
•	Arrays for storing vehicles and reservation names
•	GUI event handling using Swing components and action listeners
•	Object arrays and manager/controller structure
Key Features
1. Add Vehicles – Input basic vehicle information such as license plate, manufacturer, year, color, price, seats, and gas tank size.
2. Add Cars – Add a car with gas mileage and vehicle type.
3. Add Trucks – Add a truck with cargo capacity and load capacity.
4. Remove Vehicles – Remove a vehicle from the system using its license plate.
5. View Vehicles – Display all stored vehicles in the GUI list area.
6. Reservations – Add a customer name to a vehicle, remove a specific customer name, or return the current vehicle.
7. Status Changes – Change a vehicle status using the status option in the displayed vehicle row.
8. Filter and Sort – Show all vehicles, sort by price, sort by number of seats, or hide unavailable vehicles.
Requirements
•	Eclipse IDE for Java Developers
•	JDK 17 or higher
Getting Started in Eclipse
Step 1 — Import the Project
1. Open Eclipse IDE.
2. Go to File → New → Java Project.
3. Enter a project name, e.g., RentalVehicleManager.
4. Click Finish.
5. Copy your .java files into the new project src folder.
6. Make sure all files use the same package declaration: package rentalcars;
Step 2 — Required Java Files
•	Vehicle.java
•	Car.java
•	Truck.java
•	VehicleManager.java
•	VehicleManagerFE_GUI.java
•	Manufacturer.java
•	Color.java
•	Status.java
•	Type.java
Step 3 — Run the Program
1. Locate the main GUI file: VehicleManagerFE_GUI.java.
2. Right-click the file → Run As → Java Application.
3. The Vehicle Manager GUI window should open, allowing you to add and manage vehicle records.
Step 4 — Optional: Export as Runnable JAR
1. Right-click your project → Export... → Runnable JAR File.
2. Choose the launch configuration for VehicleManagerFE_GUI.
3. Select Package required libraries into generated JAR.
4. Click Finish.
How to Use
1. Launch the app from Eclipse.
2. Enter the basic vehicle information in the Vehicle Information panel.
3. Click Add Vehicle to add a general vehicle.
4. For cars, enter gas mileage and select a type, then click Add Car.
5. For trucks, enter cargo capacity and load capacity, then click Add Truck.
6. Use the Remove Vehicle panel to remove a vehicle by license plate.
7. Use the buttons on each displayed vehicle row to add a reservation, return the vehicle, remove a reservation name, view more information, or change the status.
8. Use the filter panel to show all vehicles, sort by price, sort by seats, or hide unavailable vehicles.
UML Diagram
 
Testing Checklist
•	App compiles and runs successfully.
•	GUI window opens without errors.
•	Add Vehicle works for a general vehicle.
•	Add Car works with gas mileage and type.
•	Add Truck works with cargo capacity and load capacity.
•	Remove Vehicle works using the correct license plate.
•	Show All displays vehicles currently stored in the manager.
•	Price sorting displays vehicles in the expected order.
•	Seat sorting displays vehicles in the expected order.
•	Hide Unavailable hides rented vehicles when selected.
•	Add Reservation updates the vehicle reservation list.
•	Return Vehicle removes the current reservation.
•	Remove Name removes a specific name from the reservation list.
•	More Info displays complete vehicle information.
•	Status button changes the vehicle status.
Future Enhancements
•	File persistence to save and load vehicle data from CSV or JSON
•	Search feature by license plate, manufacturer, color, status, or vehicle type
•	Stronger validation for license plate format, year, price, gas tank size, and capacity values
•	Edit screen for changing vehicle details after creation
•	Theme customization or a more modern GUI layout
Credits
Developed by Group 4
Instructor: Dr. Jiandong (Jin) Wang
Course: CSE 1325 – Object-Oriented Programming
License
For educational use only.

