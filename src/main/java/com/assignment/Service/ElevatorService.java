package com.assignment.Service;

import org.springframework.data.domain.ScrollPosition.Direction;

import com.assignment.Model.ElevatorStatus;

public interface ElevatorService {
	public String moveElevator(int destToFloor,String direction) throws Exception;
	
	public String moveUp(int destToFloor);
	public String moveDown(int destToFloor);
    public ElevatorStatus getElevatorStatus();
}
