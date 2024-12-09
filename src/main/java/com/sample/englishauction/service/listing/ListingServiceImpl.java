package com.sample.englishauction.service.listing;

import com.sample.englishauction.exception.ResourceNotFoundException;
import com.sample.englishauction.model.Listing;
import com.sample.englishauction.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;


public class ListingServiceImpl implements ListingService
{

    @Autowired
    private ListingRepository listingRepository;
    @Override
    public void createListingService(Listing listing)
    {
        try
        {
            listingRepository.save(listing);
        }
        catch (Exception e)
        {
            System.out.println("Illegal Creation: Please add all the required credential!");
            e.printStackTrace();

        }
    }



    @Override
    public ListingService getListingService(int id) {
        return listingRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Listing with : " + id + " id does not exist!"));
    }

    @Override
    public ListingService updateListingService(int id, ListingService listingService) {
        return null;
    }

    @Override
    public Collection<ListingService> getListingService() {
        return null;
    }

    @Override
    public void deleteListingService(int id) {

    }
}
