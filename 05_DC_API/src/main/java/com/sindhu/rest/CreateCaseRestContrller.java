package com.sindhu.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sindhu.service.DcService;

@RestController 
public class CreateCaseRestContrller {
	
	@Autowired
	private DcService service;
	
	@GetMapping("/case/{appId}")
	public ResponseEntity<Long>createCase(@PathVariable Integer appId){
		Long caseNumber = service.loadCaseNumber(appId);
	List<String> planNames = service.getPlanNames();
	
	}

}
