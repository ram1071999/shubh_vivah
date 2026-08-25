package com.Shubh_Vivah.Shubh_Vivah.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.Shubh_Vivah.Shubh_Vivah.Model.VivahModel;

public interface VivahRepository extends JpaRepository<VivahModel, Integer> , JpaSpecificationExecutor<VivahModel> {

	

}
