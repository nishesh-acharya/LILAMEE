package com.sample.englishauction.repository;

import com.sample.englishauction.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser,Long>
{

}