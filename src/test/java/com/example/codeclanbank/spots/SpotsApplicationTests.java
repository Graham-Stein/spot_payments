package com.example.codeclanbank.spots;

import com.example.codeclanbank.spots.models.Merchant;
import com.example.codeclanbank.spots.repositories.CustomerRepository;
import com.example.codeclanbank.spots.repositories.MerchantRepository.MerchantRepository;
import com.example.codeclanbank.spots.repositories.PaymentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpotsApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	MerchantRepository merchantRepository;

	@Test
	public  void canDoMerchantsCustomerHasPaidQuery(){

		List<Merchant> found = merchantRepository.merchantsCustomerHasPaid(1L);
		assertEquals(found.get(0).getName(), "Zara");

	}




}
