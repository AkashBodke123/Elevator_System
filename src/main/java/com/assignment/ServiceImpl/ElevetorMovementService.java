package com.assignment.ServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.Model.ElevatorStatus;
import com.assignment.Model.RequestToElevator;
import com.assignment.Service.ElevatorService;
import com.assignment.controller.ElevatorController;

@Service
public class ElevetorMovementService implements ElevatorService{
	
	private static final Logger logger = LoggerFactory.getLogger(ElevatorController.class);
	
	@Autowired(required = false)
	private ElevatorStatus status;
	
	@Autowired(required = false)
	private RequestToElevator request;
	
   private int currentFloor=1;
    int minFloor=1;
    int maxFloor=10;
    String up="up";
    String down="down";
    
   public String moveUp(int destToFloor) {
	   String response= "Lift is moving up to floor "+destToFloor;
	   logger.info("Elevator Movement implementaion : move Elevator to Floor " +destToFloor);
		  currentFloor=destToFloor;
		 return response;
	
   }
   
   public String moveDown(int destToFloor) {

		String response ="Lift is moving down to Floor " +destToFloor;
		logger.info("Elevator Movement implementaion : move Elevator to Floor " +destToFloor);
		 currentFloor=destToFloor;
		return response;
	   
   }

	@Override
	public String moveElevator(int destToFloor,String direction) throws Exception {
		
			if((minFloor<destToFloor)&&(maxFloor>destToFloor)){
				
			     if(up.equalsIgnoreCase(direction)) {
				   ElevetorMovementService call = new ElevetorMovementService();
				   logger.info("Elevator Movement implementaion : moveup() method " +direction);
				   return call.moveUp(destToFloor);
				
			    }else if(down.equalsIgnoreCase(direction)) { 
				   ElevetorMovementService call = new ElevetorMovementService();
				   logger.info("Elevator Movement implementaion : moveDown() method "+direction);
				   return call.moveDown(destToFloor);
			    }
			    else {
				   throw new Exception("Please select direction");
			    }
		    }
			else {
				throw new Exception("Please enter valid Floor number");
			     }
	
	} 

	@Override
	public ElevatorStatus getElevatorStatus() {
		ElevatorStatus status= new ElevatorStatus();
		status.setCurrentFloor(currentFloor);
		return status;
	}
}
