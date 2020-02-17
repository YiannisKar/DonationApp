package com.assignment.DonationApp.services;

import com.assignment.DonationApp.Donation;
import com.assignment.DonationApp.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationService {

    @Autowired
    private DonationRepository repo;

    public List<Donation> listAll(){

        return repo.findAll();
    }

    public void save(Donation donation){

        repo.save(donation);

    }

    public Donation get(Long id){

        return repo.findById(id).get();
    }
}
