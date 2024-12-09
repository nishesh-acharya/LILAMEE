package com.sample.englishauction.service.listing;

import com.sample.englishauction.model.Listing;

import java.util.Collection;

public interface ListingService
{
    public abstract void createListingService(ListingService listingService);

    void createListingService(Listing listing);

    public abstract ListingService getListingService(int id);

    public abstract ListingService updateListingService(int id, ListingService listingService);

    public abstract Collection<ListingService> getListingService();

    public abstract void deleteListingService(int id);
}
