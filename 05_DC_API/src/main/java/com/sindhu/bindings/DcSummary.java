package com.sindhu.bindings;

import java.util.List;

import lombok.Data;

@Data
public class DcSummary {
	
	private Income income;
	private Education education;
	private List<Children> children;
	private String planName;

}
