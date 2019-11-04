package reference;


import java.util.ArrayList;
import java.util.Random;

import simulator.Drone;
import simulator.Place;

public class RandomDroneController extends DroneControllerSkeleton {
	
	static int nameCount=0;
	
	private static synchronized int getNameCount() {
		return nameCount;
	}

	private static synchronized void setNameCount(int nameCount) {
		RandomDroneController.nameCount = nameCount;
	}


	@Override
	public String getNextDroneName() {
		setNameCount(getNameCount()+1);
		return "Rando Drone "+getNameCount();
	}

	@Override
	public String getCompanyName() {
		return "Randomness Inc.";
	}
	
	@Override
	public void droneIdling(Drone drone) {
		super.droneIdling(drone);
		
		//Get the random number generator
		Random random = this.simulator.getSimulationController().getRandom();
		
		//Pick a random place to go to
		int x = random.nextInt(this.simulator.getPlaces().size());
		ArrayList<Place> picker = new ArrayList<Place>(this.simulator.getPlaces());
		Place next = picker.get(x);
		
		//Set the manifest to that destination and then go to that destination 
		if(next != null){
			simulator.setDroneManifest(drone, next.getName());
			simulator.routeDrone(drone, next.getName());
		}
	}
}

	
	
