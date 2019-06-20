package com.usa.federal.gov.ssa.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ssn_master")
/**
 * States Entity Class . 
 * @author laksh
 *
 */
@NoArgsConstructor
public class SsnMasterEntity {
	public void setDob(String dob) {
		LocalDate date = LocalDate.parse(dob);
		this.dob = date;
	}

	public void setPhno(String phno) {
		this.phno = Long.parseLong(phno);
	}

	public void setCreateDate() {
		this.createDate = LocalDateTime.now();
	}

	public void setUpdateDate() {
		this.updateDate = LocalDateTime.now();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ssn_number")
	@SequenceGenerator(name = "ssn_number", initialValue = 525_835_271, allocationSize = 1)
	@Column(name = "ssn")
	@Getter
	@Setter
	private Integer ssnId;

	@Column(name = "fname")
	@Getter
	@Setter
	private String fname;
	@Column(name = "lname")
	@Getter
	@Setter
	private String lname;
	@Column(name = "dob")
	@Getter
	private LocalDate dob;
	@Column(name = "gender")
	@Getter
	@Setter
	private String gender;
	@Column(name = "state_name")
	@Getter
	@Setter
	private String state;

	@Column(name = "phno")
	@Getter
	private Long phno;
	
	@Column(name = "create_dt")
	@Getter
	private LocalDateTime createDate;

	@Column(name = "update_dt")
	@Getter
	private LocalDateTime updateDate;



	@Setter
	@Getter
	private String photopath;

}
