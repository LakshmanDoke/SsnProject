package com.usa.federal.gov.ssa.service;

import org.springframework.stereotype.Repository;

import com.usa.federal.gov.ssa.model.SsnMasterEntity;
/**
 * SsaService interface to use service layer .
 * @author laksh
 *
 */
@Repository
public interface SsaService {
	/**
	 * It saves the ssn to db
	 * @param entity
	 * @return
	 */
	Integer saveSsn(SsnMasterEntity entity);
	/**
	 * Get all the SSN
	 * @return
	 */
	Iterable<SsnMasterEntity> getAllSsn();
	/**
	 * It re
	 * @return
	 */
	Integer getLatestSsinId();
	/**
	 * It returns the state by id .
	 * @param id
	 * @return
	 */
	String getStateBySsid(Integer ssnId);
}
