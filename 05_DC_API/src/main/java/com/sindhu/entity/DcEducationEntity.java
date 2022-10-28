package com.sindhu.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="DC_EDUCATION")
@Data
public class DcEducationEntity {
	
	private Integer eduId;
	private Long caseNum;
	private String highestQualifaction;
	private Integer graduationYear;

}
