package com.example.codeclanbank.spots.repositories.MerchantRepository;

import com.example.codeclanbank.spots.models.Merchant;

import java.util.List;

public interface MerchantRepositoryCustom {
    List<Merchant> merchantsCustomerHasPaid(Long customerId);
}
