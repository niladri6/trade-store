package com.barclays;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.barclays.Exception.CustomException;
import com.barclays.entity.TradeDTO;
import com.barclays.repository.StoreRepository;
import com.barclays.service.StoreService;

@SpringBootTest
class BarclaysTestApplicationTests {

	@InjectMocks
	private StoreService storeService;

	@Test
	public void testExceptionMessage() throws Exception {
//		StoreService storeService = Mockito.mock(StoreService.class);

		when(storeService.validation(new TradeDTO("T1", "CP-1", "B1", 0, "20/5/2020")))
				.thenThrow(new CustomException("Trade is Not Accepted"));
	}

}
