package com.invoax.partfinder.partservice.model;


import org.springframework.data.mongodb.core.mapping.Document;

public class SubPart {

    private long quantity;
    private String colour;
    private Location location;
    
    
    public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
    public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
