package com.sindhu.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Children {
	private Integer childId;
	private LocalDate childDob;
	private Long childSsn;
	private Long caseNum;

}
