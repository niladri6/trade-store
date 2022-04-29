package com.barclays;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.barclays.entity.TradeDTO;
import com.barclays.service.StoreService;

@EnableScheduling
@SpringBootApplication
public class BarclaysTestApplication {
	
	@Autowired
	private StoreService storeService;
	
	public static void main(String[] args) {
		SpringApplication.run(BarclaysTestApplication.class, args);
	}

}
