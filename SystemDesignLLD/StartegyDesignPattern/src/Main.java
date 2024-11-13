/* 
 * when some of the child classes of parent class have same code in the child classes leads to code 
 * duplicate if the same code is there in parent class then child class can reuse it but it is needed in some 
 * child classes only not in all what should be done in that case we should go with strategy Design Pattern
 *  for More details go through Coding and concept System Design Course in you tube
 */

interface DriveStarategy {
	public void drive();
}

class SportsDriveStarategy implements DriveStarategy{

	@Override
	public void drive() {
		System.out.println("Sports Drive");
		
	}
	
}


class NormalDriveStrategy implements DriveStarategy{
	
	@Override
	public void drive() {
		System.out.println("Normal Drive");
		
	}
}

class Vehicle {
	DriveStarategy driveObj;
	
	
	//constructor injection
	Vehicle(DriveStarategy driveStarategy){
		this.driveObj=driveStarategy;
	}
	
	 void drive() {
		 driveObj.drive();
	 }
	
}

class SportsVehicle extends Vehicle{

	SportsVehicle() {
		super(new SportsDriveStarategy());
	}
	
}

class OffRoadVehicle extends Vehicle{

	OffRoadVehicle() {
		super(new SportsDriveStarategy());
	}
	
}

class NormalVehicle extends Vehicle{

	NormalVehicle() {
		super(new NormalDriveStrategy());
		// TODO Auto-generated constructor stub
	}
	
}

public class Main {

	public static void main(String[] args) {
		
		//sports vehicle
		Vehicle sportsVehicle=new SportsVehicle();
		sportsVehicle.drive();
		
		//OffroadVehicle
		Vehicle offRoadVehicle=new OffRoadVehicle();
		offRoadVehicle.drive();
		
		//NormalVehicle
		Vehicle normalVehicle=new NormalVehicle();
		normalVehicle.drive();
	}

}
