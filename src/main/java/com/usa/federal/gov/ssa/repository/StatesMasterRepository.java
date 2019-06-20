package com.usa.federal.gov.ssa.repository;

import org.springframework.data.repository.CrudRepository;

import com.usa.federal.gov.ssa.model.StatesModel;
/**
 * Sates Master repository to call all method .
 * @author laksh
 *
 */
public interface StatesMasterRepository extends CrudRepository<StatesModel, Integer> {

}
