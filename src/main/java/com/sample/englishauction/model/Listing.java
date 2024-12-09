package com.sample.englishauction.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "listings")
public class Listing
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_name")
    private String productName;

    @Lob
    @Column(name = "description",nullable = true)
    private String description;

    @Column(name = "category")
    private String category;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private AppUser appUser;


}
