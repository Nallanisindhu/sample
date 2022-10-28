package com.sindhu.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="DC_CHILDREN")
@Data
public class DcChildrenEntity {
	
	@Id
	@GeneratedValue( strategy =GenerationType.IDENTITY)
	private Integer childId;
	private LocalDate childDob;
	private Long childSsn;
	private Long caseNum;
	
	

}
