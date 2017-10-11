package com.invoax.partfinder.partservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class CategoryController {
	
	@Autowired
	 MongoTemplate mongoTemplate;
    
    public CategoryController() {
  //      mongoClient = new MongoClient( "localhost" , 27017 );
    ///    database = mongoClient.getDatabase("partfinder");
    //    collection = database.getCollection("parts");
    }

    @RequestMapping(value =  "/parts/categories", method = RequestMethod.GET)
    public List<String> categories() {
    	List<String> cats = mongoTemplate.getCollection("parts").distinct("category");
    	System.out.println(cats);
        return cats;
    }
}