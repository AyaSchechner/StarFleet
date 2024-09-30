package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public class TransportShip extends mySpaceship{

//	private String name;
//	private int commissionYear;
//	private float maximalSpeed;
	private int firePower;
//	private Set<CrewMember> crewMembers;
	private int annualMaintenanceCost;
	private int cargoCapacity; 
	private int passengerCapacity;
	
	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super(name, commissionYear, maximalSpeed, crewMembers);
		this.firePower = 10;
		this.cargoCapacity = cargoCapacity;
		this.passengerCapacity = passengerCapacity; 
		this.annualMaintenanceCost = 3000 + 5*this.cargoCapacity + 3*this.passengerCapacity;
	}

	public int getCargoCapacity() {
		return this.cargoCapacity;
	}
	
	public int getPassengerCapacity() {
		return this.passengerCapacity;
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		return this.annualMaintenanceCost;
	}

	@Override
	public int getFirePower() {
		return this.firePower;
	}

	public String toString() {
		return super.toString() + "\r\n" + "	CargoCapacity=" + this.getCargoCapacity() + "\r\n" + "	PassengerCapacity=" + this.getPassengerCapacity();
	}
	
	
}
