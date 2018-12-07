package com.example.codeclanbank.spots.repositories.MerchantRepository;

import com.example.codeclanbank.spots.models.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {
    List<Merchant> merchantsCustomerHasPaid(Long customerId);
}
