
package com.usa.federal.gov.ssa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
 
@Table(name = "states_master")
/**
 * States Model class
 * 
 * @author laksh
 *
 */
public class StatesModel {

	@Id
	@Column(name = "state_id")
	private Integer stateId;

	@Column(name = "state_cd")
	private String stateCode;

	@Column(name = "state_name")
	private String stateName;

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
}
