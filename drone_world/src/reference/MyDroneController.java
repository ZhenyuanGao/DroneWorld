/*worked with Dempsey Salazar
 *  Team Zhenyuan Gao, Dempsey Salazar
 * 
 */
package reference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import simulator.DistanceCalculator;
import simulator.Drone;
import simulator.Place;

public class MyDroneController extends DroneControllerSkeleton {

	
	
private static int nameCount=0;
	
	private static synchronized int getNameCount() {
		return nameCount;
	}

	private static synchronized void setNameCount(int nameCount) {
		MyDroneController.nameCount = nameCount;
	}


	@Override
	public String getNextDroneName() {
		setNameCount(getNameCount()+1);
		return "Kevin Drone "+getNameCount();
	}

	@Override
	public String getCompanyName() {
		return "Kevin Gao Inc.";
	}
	
	ArrayList<Place> taker = null;
	int nextPlace=0;
	
	
	@Override
	public void droneEmbarkingStart(Drone drone) {
		super.droneIdling(drone);
		if(drone.getPassengers().size()>0){
    		simulator.routeDrone(drone, drone.getPassengers().iterator().next().getDestination());
    }

		
		
		
	}
	
	
	
	
	
	
	
	@Override
	public void droneIdling(Drone drone) {
		super.droneIdling(drone);
	
		//set the manifest to all locations
		Set<Place> loop = this.simulator.getPlaces();
		Iterator<Place> q =loop.iterator();
		Set<String> location = new HashSet<String>();
		
		
		for(int i = 0; i < loop.size(); i++){
			location.add(q.next().getName());
		}
	    simulator.setDroneManifest(drone, location);
	        //if you have a passenger and the drone will go where the passenger want to go.
	        
	    if(drone.getPassengers().size()>0){
	    		simulator.routeDrone(drone, drone.getPassengers().iterator().next().getDestination());
	    }
	
	    //all locations that people contains
	    else{
	    	ArrayList<Place> picker = new ArrayList<Place>(this.simulator.getPlaces());
	    	for(int i = 0;i<picker.size(); i++){
	    		if(picker.get(i).getWaitingToEmbark().size()==0)
	    			picker.remove(i);
	    		
	    	}
	    
	    
	    
	    //Get the random number generator
	    Random random = this.simulator.getSimulationController().getRandom();
	    
	    
	    //Go to a different place.
	    int x = random.nextInt(this.simulator.getPlaces().size());
	    Place next = picker.get(x);
	    
	    
	    if(next != null){
	    	simulator.routeDrone(drone, next.getName());
	    }
	    }
	}
}

	
	

