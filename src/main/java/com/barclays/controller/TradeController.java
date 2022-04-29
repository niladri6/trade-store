package com.barclays.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.entity.GenericResponse;
import com.barclays.entity.TradeDTO;
import com.barclays.service.StoreService;

@RequestMapping("barclays/api/trade")
@RestController
public class TradeController {

	@Autowired
	private StoreService storeService;

	@GetMapping
	public ResponseEntity<GenericResponse> getTrades() {
		GenericResponse response = storeService.getAll();
		return new ResponseEntity<GenericResponse>(response,
				response.getSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}

	@PostMapping
	public ResponseEntity<GenericResponse> saveTrades(@RequestBody TradeDTO dto) {
		GenericResponse response = new GenericResponse();
		try {
			storeService.validation(dto);
			response.setSuccess(true);
			return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<GenericResponse>(response, HttpStatus.BAD_REQUEST);
		}
	}

}
