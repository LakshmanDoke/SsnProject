package com.usa.federal.gov.ssa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.usa.federal.gov.ssa.model.SsnMasterEntity;
import com.usa.federal.gov.ssa.repository.SsnMasterRepository;

import lombok.NoArgsConstructor;

/**
 * SsaService implementation class .
 * 
 * @author laksh
 *
 */
@Repository
@NoArgsConstructor
public class SsaServiceImpl implements SsaService {
	/**
	 * repository object.
	 */
	@Autowired
	private SsnMasterRepository ssnRepository;

	@Transactional
	@Override
	public Integer saveSsn(final SsnMasterEntity entity) {
		ssnRepository.save(entity);
		return entity.getSsnId();
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<SsnMasterEntity> getAllSsn() {
		return ssnRepository.findAll();
	}

	@Override
	public Integer getLatestSsinId() {
		return ssnRepository.getLatestSsinId();
	}

	@Override
	@Transactional
	public String getStateBySsid(final Integer ssnId) {
		return ssnRepository.findById(ssnId).get().getState();
	}

}
