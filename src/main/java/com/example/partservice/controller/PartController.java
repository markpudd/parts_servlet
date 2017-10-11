package com.invoax.partfinder.partservice.controller;


import com.invoax.partfinder.partservice.model.Location;
import com.invoax.partfinder.partservice.model.Part;
import com.invoax.partfinder.partservice.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;


@RestController
public class PartController {
	
	@Autowired
    private PartRepository repository;
    

	
    public PartController() {
    }

    @RequestMapping("/parts")
    public List<Part> getParts(@RequestParam(value="category", defaultValue="") String category) {
    	return repository.findByCategory(category);
    }
    

    @RequestMapping(value = "/parts", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Part savePart(@RequestBody Part part) {
    	return repository.save(part);
    }    
    

    @RequestMapping(value = "/parts/{part_id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Part updatePart(@RequestBody Part part) {
    	// look up object  (update would be better here)
    	Part dbPart = repository.findOne(part.get_id());
    	dbPart.setDescription(part.getDescription());
    	dbPart.setCategory(part.getCategory());
    	return repository.save(dbPart);
    }   
    
    @RequestMapping("/parts/{part_id}")
    public Part getPart(@PathVariable String part_id) {
    	return repository.findOne(part_id);
    }
    
    @RequestMapping("/parts/store/{place_id}/{store_id}")
    public List<Part> getPartsForStore(@PathVariable String place_id,@PathVariable String store_id) {
    	return repository.findBySubPartsLocation(new Location(place_id,store_id));
    
    }   

    @RequestMapping("/parts/place")
    public Map<String,String> place(@RequestParam(value="part_id") String part_id,
    		          @RequestParam(value="store_id") String store_id,
    		          @RequestParam(value="place_id") String place_id)  {
    	// Two options here
    	//  - Use low level  - can update existing object on DB
    	//  - use the repo   - requires us to get objects and then store them (a bigger transact problem)
    	Part part  = repository.findOne(part_id);
    	Location loc = new Location(place_id,store_id);
    	part.getSubParts().get(0).setLocation(loc);
    	repository.save(part);
    	
   /* 	Store store = storeRepository.findOne(store_id);
    	Map<String,List<String>> stored = store.getStored();
    	if(stored==null) {
    		// Mongos maps are ordered
    		stored = new TreeMap<String,List<String>>();
    		store.setStored(stored);
    	}
    	List<String> itemsInPlace = stored.get(place_id);
    	if(itemsInPlace==null) {
    		itemsInPlace = new ArrayList<String>();
    		stored.put(place_id, itemsInPlace);
    	}
    	itemsInPlace.add(part_id);
    	storeRepository.save(store);*/
    		
    	return new TreeMap<String,String>();
    }

    @RequestMapping("/parts/unplace")
    public  Map<String,String> unplace(@RequestParam(value="part_id") String part_id,
	          @RequestParam(value="store_id") String store_id,
	          @RequestParam(value="place_id") String place_id) {
    	Part part  = repository.findOne(part_id);
       	part.getSubParts().get(0).setLocation(null);
    	repository.save(part);
    	
    /*	Store store = storeRepository.findOne(store_id);
    	System.out.println(store.getStored());
    	System.out.println(store.getStored().get(place_id));
    	System.out.println(place_id);

    	
    	store.getStored().get(place_id).remove(part_id);
    	storeRepository.save(store);
*/
    	
    	return new TreeMap<String,String>();
  
    }

}