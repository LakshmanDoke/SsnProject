
package com.usa.federal.gov.ssa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "states_master")
/**
 * States Model class
 * 
 * @author laksh
 *
 */
@NoArgsConstructor
public class StatesModel {

	@Id
	@Column(name = "state_id")
	private Integer stateId;

	@Column(name = "state_cd")
	private String stateCode;

	@Column(name = "state_name")
	private String stateName;
}
