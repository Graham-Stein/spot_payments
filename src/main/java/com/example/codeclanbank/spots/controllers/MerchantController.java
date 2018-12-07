package com.example.codeclanbank.spots.controllers;

import com.example.codeclanbank.spots.models.Merchant;
import com.example.codeclanbank.spots.repositories.MerchantRepository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/merchants")
public class MerchantController {

    @Autowired
    MerchantRepository merchantRepository;

    @GetMapping("/paid/{id}")
    public List<Merchant> getMerchantsCustomersPaid(@PathVariable Long id){
        return merchantRepository.merchantsCustomerHasPaid(id);
    }
}
