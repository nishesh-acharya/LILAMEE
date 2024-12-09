package com.sample.englishauction.repository;

import com.sample.englishauction.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingRepository extends JpaRepository<Listing, Long>
{

}
