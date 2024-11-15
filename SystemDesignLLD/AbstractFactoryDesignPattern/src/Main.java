/*
 * creates famlies of realated objects without specifying the concrete classes is called abstract Factory Design 
 * Pattern(Factory of Factories)
 */


enum vehicleList {
	MERCEDES, BMW, TATA, MAHINDRA
}

interface Vehicle {
	void getName();
}

class MERCEDES implements Vehicle {

	@Override
	public void getName() {
		System.out.println("MERCEDES");

	}

}

class BMW implements Vehicle {

	@Override
	public void getName() {
		System.out.println("BMW");

	}

}

class TATA implements Vehicle {

	@Override
	public void getName() {
		System.out.println("TATA");

	}

}

class MAHINDRA implements Vehicle {

	@Override
	public void getName() {
		System.out.println("MAHINDRA");

	}

}

interface VehicleFactory {

	Vehicle getVehicle(vehicleList x);
}

class LuxuryVehicleFactory implements VehicleFactory {

	@Override
	public Vehicle getVehicle(vehicleList x) {

		switch (x) {
		case MERCEDES:
			return new MERCEDES();
		case BMW:
			return new BMW();
		default:
			return null;

		}
	}

}

class OrdinaryVehicleFactory implements VehicleFactory {

	@Override
	public Vehicle getVehicle(vehicleList x) {

		switch (x) {
		case TATA:
			return new TATA();
		case MAHINDRA:
			return new MAHINDRA();
		default:
			return null;

		}
	}

}

enum OrdinaryLuxuryVehicleList {
	LUXURY, ORDINARY
}

class LuxuryOrdinaryFactory {

	VehicleFactory getVehicleFactory(OrdinaryLuxuryVehicleList x) {
		switch (x) {

		case LUXURY:
			return new LuxuryVehicleFactory();

		case ORDINARY:
			return new OrdinaryVehicleFactory();
			
		default:
			return null;
		}

	}
}

public class Main {

	public static void main(String[] args) {
		LuxuryOrdinaryFactory obj=new LuxuryOrdinaryFactory();
		VehicleFactory luxuryFactory =obj.getVehicleFactory(OrdinaryLuxuryVehicleList.LUXURY);
		Vehicle luxuryVehicle=luxuryFactory.getVehicle(vehicleList.MERCEDES);
		luxuryVehicle.getName();
		
		VehicleFactory ordinaryFactory =obj.getVehicleFactory(OrdinaryLuxuryVehicleList.ORDINARY);
		Vehicle ordinaryVehicle=ordinaryFactory.getVehicle(vehicleList.TATA);
		ordinaryVehicle.getName();
		

	}

}
