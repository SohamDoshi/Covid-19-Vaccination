package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.VaccinationCenter;

@Repository
public interface VaccinationCenterRepo extends JpaRepository<VaccinationCenter, Integer>{

}
