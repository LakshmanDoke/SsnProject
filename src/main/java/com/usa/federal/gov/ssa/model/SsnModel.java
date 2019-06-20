package com.usa.federal.gov.ssa.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
/**
 * SsnModel class Binder class .
 * @author laksh
 *
 */
@NoArgsConstructor
public class SsnModel {

	@Id
	private Integer ssnId;
	private String fname;
	private String lname;
	private String dob;
	private String gender;
	private String state;
	private String phno;
	private LocalDate createDate;
	private LocalDate updateDate;
	private String photopath;

}