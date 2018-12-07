package com.example.codeclanbank.spots.components;

import com.example.codeclanbank.spots.models.Customer;
import com.example.codeclanbank.spots.models.Merchant;
import com.example.codeclanbank.spots.models.Payment;
import com.example.codeclanbank.spots.repositories.CustomerRepository;
import com.example.codeclanbank.spots.repositories.MerchantRepository.MerchantRepository;
import com.example.codeclanbank.spots.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    MerchantRepository merchantRepository;

    @Autowired
    PaymentRepository paymentRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Customer customer = new Customer("Colin", 32);
        customerRepository.save(customer);

        Customer customer2 = new Customer("Genna", 21);
        customerRepository.save(customer2);


        Customer customer3 = new Customer("Sandy", 18);
        customerRepository.save(customer3);

        Customer customer4 = new Customer("Iona", 23);
        customerRepository.save(customer4);


        Merchant merchant = new Merchant("ASOS");
        merchantRepository.save(merchant);


        Merchant merchant2 = new Merchant("Zara");
        merchantRepository.save(merchant2);


        Payment payment = new Payment(1.99, "07-12-18", "BTC", customer2, merchant2);
        paymentRepository.save(payment);

        Payment payment2 = new Payment(1.99, "07-12-18", "BTC", customer4, merchant);
        paymentRepository.save(payment2);

        Payment payment3 = new Payment(1.99, "07-12-18", "BTC", customer, merchant2);
        paymentRepository.save(payment3);

        Payment payment4 = new Payment(1.99, "07-12-18", "BTC", customer3, merchant2);
        paymentRepository.save(payment4);

    }
}
