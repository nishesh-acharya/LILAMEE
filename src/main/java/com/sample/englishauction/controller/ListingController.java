package com.sample.englishauction.controller;

import com.sample.englishauction.exception.ResourceNotFoundException;
import com.sample.englishauction.model.Listing;
import com.sample.englishauction.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/listings")
public class ListingController
{
    @Autowired
    private ListingRepository listingRepository;

    @PostMapping
    public Listing createListing(@RequestBody Listing listing) {
        return listingRepository.save(listing);
    }

    @GetMapping("{id}")
    public Listing getListingById(@PathVariable long id){
        Listing listing = listingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Listing do not exist with id:" + id));
        return listing;
    }

    @PutMapping("{id}")
    public ResponseEntity<Listing> updateListing(@PathVariable long id, @RequestBody Listing listingDetails) {
        Listing updateListing = listingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Listing do not exist with id: " + id));


        updateListing.setProductName(listingDetails.getProductName());
        updateListing.setCategory(listingDetails.getCategory());
        updateListing.setDescription(listingDetails.getDescription());

        listingRepository.save(updateListing);

        return ResponseEntity.ok(updateListing);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteListing (@PathVariable long id)
    {
        Listing listing = listingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Listing with that id does not exist!"));
        listingRepository.delete(listing);

        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
