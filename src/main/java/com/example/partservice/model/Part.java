package com.invoax.partfinder.partservice.model;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="parts")
public class Part {

	@Id private String _id;

    private String description;
    private String category;
    private String image;
    
    @Field("sub_parts")
    @JsonProperty("sub_parts")
    private List<SubPart> subParts;
    
    
    

	public Part() {
		super();
	}
	
	
	public Part(String _id, String description, String category, String image, List<SubPart> subParts) {
		super();
		this._id = _id;
		this.description = description;
		this.category = category;
		this.image = image;
		this.subParts = subParts;
	}


	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public void setSubParts(List<SubPart> subParts) {
		this.subParts = subParts;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
    public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


    public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<SubPart> getSubParts() {
		return subParts;
	}

	
	
}