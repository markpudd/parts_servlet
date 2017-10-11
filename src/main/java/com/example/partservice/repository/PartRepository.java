package com.example.partservice.repository;


import com.example.partservice.model.Location;
import com.example.partservice.model.Part;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "hate_parts", path = "hate_parts")
public interface PartRepository extends MongoRepository<Part, String> {

	public List<Part> findByCategory(@Param("category")String category);
	public List<Part> findBySubPartsLocation(@Param("location")Location location);
	
}