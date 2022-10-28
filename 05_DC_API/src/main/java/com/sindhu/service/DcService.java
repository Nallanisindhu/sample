package com.sindhu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sindhu.bindings.Children;
import com.sindhu.bindings.DcSummary;
import com.sindhu.bindings.Education;
import com.sindhu.bindings.Income;
import com.sindhu.bindings.PlanSelection;

@Service
public interface DcService {
	
	public Long loadCaseNumber (Integer appId);
	
	public List<String>getPlanNames();
	
	public Long saveplanSelection(PlanSelection planSelection);

	public Long saveIncomeData(Income income);
	
	public Long saveEducation(Education educaton);
	
	public Long savedChildren(List<Children> children);
	
	public DcSummary getSummary(Long caseNumber);

}
