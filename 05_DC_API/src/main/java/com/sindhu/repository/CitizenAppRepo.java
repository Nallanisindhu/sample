package com.sindhu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sindhu.entity.CitizenAppEntity;

public interface CitizenAppRepo extends JpaRepository<CitizenAppEntity,Serializable> {

}
