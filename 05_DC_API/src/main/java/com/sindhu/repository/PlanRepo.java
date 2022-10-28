package com.sindhu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sindhu.entity.PlanEntity;

public interface PlanRepo extends JpaRepository<PlanEntity, Serializable

> {

}
