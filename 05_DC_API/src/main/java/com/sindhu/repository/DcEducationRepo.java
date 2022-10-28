package com.sindhu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sindhu.entity.DcEducationEntity;

public interface DcEducationRepo extends JpaRepository<DcEducationEntity, Serializable> {

	public DcEducationEntity findByCaseNum(Long caseNum);
}
