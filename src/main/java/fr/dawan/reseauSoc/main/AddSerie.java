package fr.dawan.reseauSoc.main;

import javax.persistence.EntityManager;

import fr.dawan.reseauSoc.beans.Episode;
import fr.dawan.reseauSoc.beans.Function;
import fr.dawan.reseauSoc.beans.PeopleContent;
import fr.dawan.reseauSoc.beans.Serie;
import fr.dawan.reseauSoc.dao.Dao;

public class AddSerie {
	
	public static void save() {
		EntityManager em= Dao.createEntityManager("JPA");
		Dao dao= new Dao();
		dao.saveOrUpdate(getCodeQuantum(), em, false);
		em.close();
	}
	
	public static Function acteur= new Function("actor");
	
	public static PeopleContent getScottBakula() {
		PeopleContent actor= new PeopleContent();
		actor.setType("people");
		actor.setFunction(acteur);
		actor.setFirstName("Scott");
		actor.setLastName("Bakula");
		actor.setBiography("Scott Stewart Bakula (born October 9, 1954) is an American actor, known for his role as Sam Beckett in the television series Quantum Leap, for which he won the Golden Globe Award for Best Actor – Television Series Drama in 1991 and was nominated for four Emmy Awards. He also had a prominent role as Captain Jonathan Archer in Star Trek: Enterprise. Bakula also guest starred in seasons two and three of NBC's Chuck as the title character's father Stephen Bartowski. Bakula…");
		actor.setPicture("https://image.tmdb.org/t/p/w600_and_h900_bestv2/7JPMhXnfY5jgPbtByutwkHHZS3M.jpg");
		actor.setBirthDay(1954);
		return actor;
	}
	
	public static PeopleContent getDeanStockwell() {
		PeopleContent actor= new PeopleContent();
		actor.setType("people");
		actor.setFunction(acteur);
		actor.setFirstName("Dean");
		actor.setLastName("Stockwell");
		actor.setBiography("Dean Stockwell (born March 5, 1936) is an American actor of film and television, active for over 60 years. He played Rear Admiral Albert \"Al\" Calavicci in the NBC television series Quantum Leap and in the Sci Fi Channel revival of Battlestar Galactica as Brother Cavil. Description above from the Wikipedia article Dean Stockwell, licensed under CC-BY-SA, full list of contributors on Wikipedia. ​");
		actor.setPicture("https://image.tmdb.org/t/p/w600_and_h900_bestv2/gooE10UOH6t4geqsEbji9NiQalP.jpg");
		actor.setBirthDay(1936);
		return actor;
	}
	
	public static Serie getCodeQuantum() {
		Serie serie= new Serie();
		serie.setTitle("Code Quantum");
		serie.setReleaseDate(1989);
		
		Episode epOne_One=  new Episode("Pilote - Partie 1", 1, 1);
		Episode epOne_Two=  new Episode("Pilote - Partie 2", 1, 2);
		Episode epOne_Three= new Episode("Amours croisées", 1, 3);
		Episode epOne_Four= new Episode("La main droite du Seigneur", 1, 4);
		Episode epOne_Five= new Episode("Le défi est lancé", 1, 5);
		serie.setEpisode(epOne_One);
		serie.setEpisode(epOne_Two);
		serie.setEpisode(epOne_Three);
		serie.setEpisode(epOne_Four);
		serie.setEpisode(epOne_Five);
		
		Episode epTwo_One=  new Episode("La Maure aux trousses", 2, 1);
		Episode epTwo_Two=  new Episode("L'enfer du disco", 2, 1);
		Episode epTwo_Three=  new Episode("Retour vers un futur", 2, 1);
		serie.setEpisode(epTwo_One);
		serie.setEpisode(epTwo_Two);
		serie.setEpisode(epTwo_Three);
		
		serie.setActor(getScottBakula());
		serie.setActor(getDeanStockwell());	
		
		return serie;
	}
}
