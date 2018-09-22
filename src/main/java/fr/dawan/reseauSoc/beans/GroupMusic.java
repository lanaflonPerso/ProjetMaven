package fr.dawan.reseauSoc.beans;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="GroupMusic")
public class GroupMusic extends Likable {

	private String bandName;
//	@ManyToOne
//	private List<PeopleContent> members= new ArrayList<>();
	@OneToMany(mappedBy="band")
	private List<Album> albums= new LinkedList<>();
	@Column(length=1000)
	private String biography;

	/* ****************************************************************************************
	 * ***************************CONSTRUCTEUR************************************************
	 * ***************************************************************************************/
	public GroupMusic() {
	}
	public GroupMusic(String bandName) {
		super();
		this.bandName = bandName;
	}


	/* ****************************************************************************************
	 * ****************************GETTERS / SETTERS*******************************************
	 * ***************************************************************************************/
//	public List<PeopleContent> getMembers() {
//		return members;
//	}
//	public void setMembers(List<PeopleContent> members) {
//		this.members = members;
//	}
	public String getBandName() {
		return bandName;
	}
	public void setBandName(String bandName) {
		this.bandName = bandName;
	}
	public List<Album> getAlbums() {
		return albums;
	}
	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
}
