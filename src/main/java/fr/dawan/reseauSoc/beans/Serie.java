package fr.dawan.reseauSoc.beans;

import java.util.List;

public class Serie extends CulturalContent {

	private List<PeopleContent> showRunners;
	private List<Episode> episodes;
	
	/*
	 * *********GETTERS/SETTERS
	 */
	public List<PeopleContent> getShowRunners() {
		return showRunners;
	}
	public void setShowRunners(List<PeopleContent> showRunners) {
		this.showRunners = showRunners;
	}
	public List<Episode> getEpisodes() {
		return episodes;
	}
	public void setEpisodes(List<Episode> episodes) {
		this.episodes = episodes;
	}
}
