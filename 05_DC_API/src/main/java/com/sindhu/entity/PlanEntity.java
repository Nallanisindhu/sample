package com.sindhu.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="PLAN_MASTER")
public class PlanEntity {
	@Id
	@GeneratedValue
	@Column(name = "PLAN_ID")
	private Integer planId;

	@Column(name = "PLAN_NAME")
	private String planName;

	@Column(name = "PLAN_START_DATE")
	private LocalDate planStartDate;

	@Column(name = "PLAN_END_DATE")
	private LocalDate planEndDate;

	@Column(name = "ACTIVE_SWITCH")
	private String activeSw;// to enable or disable data( y or N)

	@Column(name = "PLAN_CATEGORY_ID")
	private Integer planCategoryId;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "CREATED_DATE", updatable = false) // once the record got created that column should not be updated
	@CreationTimestamp // date updated automatically
	private LocalDate createdate;

	@Column(name = "UPDATED_DATE", insertable = false) // once the record got updated that column should not be inserted
	@UpdateTimestamp // date updated automatically
	private LocalDate updateDate;


}
