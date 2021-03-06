package simulator.interfaces;

import simulator.Drone;
import simulator.Simulator;

public interface DroneController {
	
	/**
	 * This is called by the simulator so that the Controller can have access to the people, places and drones that simulator keeps track of
	 *  
	 * @param simulator
	 */
	void setSimulator(Simulator simulator);
	
	/* Life cycle call backs */
	void droneEmbarkingStart(Drone drone);
	void droneEmbarkingAGroupStart(Drone drone);
	void droneEmbarkingAGroupEnd(Drone drone);
	void droneEmbarkingEnd(Drone drone);
	
	void droneAscendingStart(Drone drone);
	void droneAscendingEnd(Drone drone);
	
	void droneTransitingStart(Drone drone);
	/**
	 * Intermediate notification of transit progress.
	 * @param drone, A copy of the drone that is transiting
	 * @param percent, How far along *original* trip the drone has gone.  If the drone is rerouted midstream to a destination further away than the original destination,
	 * then this can be greater than 100.
	 */
	void droneTransiting(Drone drone,double percent);
	void droneTransitingEnd(Drone drone);
	
	/** 
	 * The drone has run out of charge mid flight and is exploding
	 * @param drone
	 */
	void droneExploding(Drone drone);
	/**
	 * This drone has crashed and is no longer in service
	 * @param drone
	 */
	void droneHasDied(Drone drone);
	
	void droneDescendingStart(Drone drone);
	void droneDescendingEnd(Drone drone);
	
	void droneDisembarkingStart(Drone drone);
	void droneDisembarkingGroupStart(Drone drone);
	void droneDisembarkingGroupEnd(Drone drone);
	void droneDisembarkingEnd(Drone drone);
	
	void droneRechargingStart(Drone drone);
	void droneRecharging(Drone drone,double percent);
	void droneDoneRecharging(Drone drone);
	
	/**
	 * A drone that is idling should have it's start and destination be the same and be the place where it current is
	 * @param drone
	 */
	void droneIdling(Drone drone);
	
	/* End Lifecyle routines */

	
	
	
	/**
	 * This method should return human relevant names for drones.  It can return as many or as few unique ones as desired.
	 * @return The name of a drone, e.g., "Grumpy"
	 */
	String getNextDroneName();

	/**
	 * This method should return the name of the company that made this controller.  
	 * @return The company name, e.g., "Patterson Intelligent Drone Corporation"
	 */
	String getCompanyName();




}
