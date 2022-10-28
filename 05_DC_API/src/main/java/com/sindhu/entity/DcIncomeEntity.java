package com.sindhu.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="DC_INCOME")
@Data
public class DcIncomeEntity {
	
	private Integer incomeId;
	private Long caseNum;
	private Double empIncome;
	private Double propertyIncome;

}
