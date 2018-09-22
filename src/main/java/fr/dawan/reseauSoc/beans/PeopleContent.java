package fr.dawan.reseauSoc.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name= "PeopleContent")
@PrimaryKeyJoinColumn(name="id")
public class PeopleContent extends Likable {
	
	private String lastName;
	private String firstName;
	private String nickName;
	@Column(length = 800)
	private String biography;
	private String picture;
	
	@Column
	private Integer birthDay;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
		name= "PeopleContent_Function",
		joinColumns = { @JoinColumn(name = "peopleContent_id") },
		inverseJoinColumns = { @JoinColumn(name = "function_id") }
	)
	private List<Function> functions= new ArrayList<>();
	
	/* ****************************************************************************************
	 * ***************************CONSTRUCTEUR************************************************
	 * ***************************************************************************************/
	public PeopleContent() {

	}
	
	
	/* ****************************************************************************************
	 * ***************************GETTERS / SETTERS PERSONEL**********************************
	 * ***************************************************************************************/
	public void setFunction(Function function) {
		functions.add(function);
	}
	
	/* ****************************************************************************************
	 * ***************************GETTERS / SETTERS*******************************************
	 * ***************************************************************************************/
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(int year) {
		this.birthDay = year;
	}
	public List<Function> getFunctions() {
		return functions;
	}
	public void setFunctions(List<Function> functions) {
		this.functions = functions;
	}
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		if(biography.length() < 800) {
			this.biography = biography;
		} else {
			this.biography = biography.substring(0, 799);
		}
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}

	/* ****************************************************************************************
	 * ***************************OVERRIDE****************************************************
	 * ***************************************************************************************/
	@Override
	public String toString() {
		return "PeopleContent [lastName=" + lastName + ", firstName=" + firstName + ", nickName="
				+ nickName + ", birthDay=" + birthDay + ", functions=" + functions + "]";
	}
}
