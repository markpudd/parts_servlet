package com.invoax.partfinder.partservice.model;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {

	
    @Field("place_id")
    @JsonProperty("place_id")
	private String placeId;
    
    @Field("store_id")
    @JsonProperty("store_id")
    private String storeId;
    

	
    
    
	public Location( String placeId,String storeId) {
		super();
		this.placeId = placeId;
		this.storeId = storeId;

	}

	
	public String getStoreId() {
		return storeId;
	}


	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}


	public String getPlaceId() {
		return placeId;
	}


	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}









}