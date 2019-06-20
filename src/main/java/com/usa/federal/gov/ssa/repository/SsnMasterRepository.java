package com.usa.federal.gov.ssa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.usa.federal.gov.ssa.model.SsnMasterEntity;
/**
 * SsnMasterRepository to create custom methods and call all custom
 *  and pre defined method in other classes as per use .
 * @author laksh
 *
 */
public interface SsnMasterRepository extends CrudRepository<SsnMasterEntity, Integer> {
	@Query(nativeQuery = true , value = "select max(ssn) from ssn_master")
	public Integer getLatestSsinId();
}
