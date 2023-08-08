package com.assignment.Model;

import org.springframework.data.domain.ScrollPosition.Direction;

public class RequestToElevator {
	
	private int destToFloor;
	private int maxFloor=1;
	private int minFloor=10;
	private String direction;
	
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getMaxFloor() {
		return maxFloor;
	}

	public void setMaxFloor(int maxFloor) {
		this.maxFloor = maxFloor;
	}

	public int getMinFloor() {
		return minFloor;
	}

	public void setMinFloor(int minFloor) {
		this.minFloor = minFloor;
	}

	public int getDestToFloor() {
		return destToFloor;
	}

	public void setDestToFloor(int destToFloor) {
		this.destToFloor = destToFloor;
	}
	

	

		
	

}
