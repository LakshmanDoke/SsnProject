package com.usa.federal.gov.ssa.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
 
/**
 * SsnModel class Binder class .
 * @author laksh
 *
 */
 
public class SsnModel {

	public Integer getSsnId() {
		return ssnId;
	}
	public void setSsnId(Integer ssnId) {
		this.ssnId = ssnId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	public LocalDate getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}
	public String getPhotopath() {
		return photopath;
	}
	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}
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