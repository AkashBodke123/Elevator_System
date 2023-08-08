package com.assignment.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ScrollPosition.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.Model.ElevatorStatus;
import com.assignment.Model.RequestToElevator;
import com.assignment.ServiceImpl.ElevetorMovementService;
import com.assignment.exceptionHandler.ElevatorException;

@RestController
@RequestMapping("/elevator")
public class ElevatorController {
	
	private static final Logger logger = LoggerFactory.getLogger(ElevatorController.class);
	
	@Autowired(required = false)
	private ElevetorMovementService elevetorMovementService;
	
	@Autowired(required = false)
	private ElevatorException elevatorException;
	
	
	@PostMapping("/moveElevator")
	public ResponseEntity<String> moveElevator(@RequestBody RequestToElevator request) throws Exception{
		if(request==null) {
			throw new ElevatorException("Please enter valid floor");
		}
		String response =elevetorMovementService.moveElevator(request.getDestToFloor(),request.getDirection());
		logger.info("Elevator Rest controller implemantation :moveElevator() method ");
		return ResponseEntity.ok().body(response);
		
	}
	
	@GetMapping("/statusOfElevator")
	public ResponseEntity<ElevatorStatus> getElevatorStatus(){
		ElevatorStatus status=elevetorMovementService.getElevatorStatus();
		logger.info("Elevator Rest controller implemantation : getElevatorStatus() method ");
		return ResponseEntity.ok().body(status);
		
	}
	
	
	
	


}

