package reference;

import java.util.Random;

import simulator.interfaces.SimulationController;

public class MySimulationController implements SimulationController {
	
	//Set this to true to get consistent behavior each run while debugging
	//Set it to false to get different random numbers on each run
	static private final boolean SAME_RANDOM_NUMBERS_EACH_TIME=true;
	
	//True if you want to render the drones (longer to start up)
	static private final boolean HIGH_RESOLUTION=true;
	
	//1 for real-time
	//100 (max) to run the simulator as fast as possible
	static private final int SIMULATOR_SPEED= 100;
	
	//While debugging it is helpful to not have the simulator quarantine your drones because
	//if you pause your code to debug it, then that pause causes your drone to be quarantined
	static private final boolean QUARANTINE_DRONES= false;
	
	
	// A global source of randomness
	public static final Random random;
	static{
		if(SAME_RANDOM_NUMBERS_EACH_TIME){
			random = new Random(10);
		}
		else{
			random = new Random();
		}
	}
	
	public Random getRandom() {
		return random;
	}

	@Override
	public boolean isHighResolution() {
		return HIGH_RESOLUTION;
	}

	@Override
	public long simulatorSpeed() {
		return SIMULATOR_SPEED;
	}
	
	@Override
	public boolean shouldQuarantineDrones(){
		return QUARANTINE_DRONES;
	}

}
