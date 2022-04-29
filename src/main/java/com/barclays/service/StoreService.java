package com.barclays.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.barclays.Exception.CustomException;
import com.barclays.entity.Expired;
import com.barclays.entity.GenericResponse;
import com.barclays.entity.Store;
import com.barclays.entity.TradeDTO;
import com.barclays.repository.StoreRepository;
import com.barclays.util.Utility;

@Service
public class StoreService {
	@Autowired
	private StoreRepository storeRepository;

	public GenericResponse getAll() {
		GenericResponse response = new GenericResponse();

		try {
			List<Store> storeList = storeRepository.findAll();
			response.setSuccess(true);
			response.setData(storeList);
			response.setTotalItem(storeList.size());
		} catch (Exception e) {
			response.setSuccess(false);
		}

		return response;
	}

	@PostConstruct
	void loadInit() {
		List<TradeDTO> list = new ArrayList<>();
		list.add(new TradeDTO("T1", "CP-1", "B1", 1, "20/5/2020"));
		list.add(new TradeDTO("T2", "CP-2", "B1", 2, "20/5/2021"));
		list.add(new TradeDTO("T2", "CP-1", "B1", 1, "20/5/2022"));
		list.add(new TradeDTO("T3", "CP-3", "B2", 3, "20/5/2014"));
//		data.add("T4", 4, "CP-4", "B4", "20/5/2014");

		for (TradeDTO dto : list) {
			save(dto);
		}
	}

	public boolean validation(TradeDTO dto) throws Exception {
		Optional<Store> storeOpt = storeRepository.findById(dto.getStoreId());
		/* update */
		if (storeOpt.isPresent()) {
			Store store = storeOpt.get();
			if (dto.getVersion() < store.getVersion()) {
				throw new CustomException("Trade is Not Accepted");
			} else if (dto.getVersion() == store.getVersion()) {
				if (!Utility.isTradeExpired(dto.getMaturityDate())) {
					store.setMaturityDate(dto.getMaturityDate());
					store.setCreatedDate(Utility.toDate(new Date()));
					store.setVersion(dto.getVersion());
					storeRepository.save(store);
					return true;
				}
			} else {
				if (!Utility.isTradeExpired(dto.getMaturityDate()))
					save(dto);
				return true;
			}
		} else {
			/* save new trade */
			save(dto);
			return true;
		}
		return false;
	}

	public Store save(TradeDTO dto) {
		Store newStore = new Store();
		newStore.setStoreId(dto.getStoreId());
		newStore.setMaturityDate(dto.getMaturityDate());
		newStore.setCreatedDate(Utility.toDate(new Date()));
		newStore.setVersion(dto.getVersion());
		newStore.setExpired(Expired.N);
		return storeRepository.save(newStore);
	}

	public boolean updateExpiryStatus() {
		try {
			List<Store> storeList = storeRepository.findByExpiry(Expired.N.name());
			if (!storeList.isEmpty()) {
				storeList.stream().forEach(trade -> {
					if (Utility.isTradeExpired(trade.getMaturityDate())) {
						trade.setExpired(Expired.Y);
						storeRepository.save(trade);
					}
				});
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/* 12 am = 0 0 0 * * **/
	@Scheduled(cron = "0 0 0 * * *")
	private void cronJob() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);
		System.out.println("Java cron job expression runs at:: " + strDate);

		boolean isStatusUpdated = updateExpiryStatus();
		System.out.println("trades maturity updated ? " + isStatusUpdated);
	}

//	@Scheduled(cron = "*/50 * * * * *")
//	void cronJobTest() {
//		boolean isStatusUpdated = updateExpiryStatus();
//		System.out.println("trades maturity updated ? " + isStatusUpdated);
//	}

}
