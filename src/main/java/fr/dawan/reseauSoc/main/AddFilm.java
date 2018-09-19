package fr.dawan.reseauSoc.main;

import javax.persistence.EntityManager;

import fr.dawan.reseauSoc.beans.Category;
import fr.dawan.reseauSoc.beans.Function;
import fr.dawan.reseauSoc.beans.Movie;
import fr.dawan.reseauSoc.beans.PeopleContent;
import fr.dawan.reseauSoc.dao.Dao;

public class AddFilm {
	
	public static Function acteur= new Function("actor");
	
	static Category adventure= new Category("Adventure");
	static Category comedie= new Category("Comédie");
	static Category drame= new Category("Drame");
	static Category horreur= new Category("Horreur");
	static Category sf= new Category("Science-Fiction");
	static Category thriller= new Category("Thriller");
	
	public static void saveMovie() {
		EntityManager em= Dao.createEntityManager("JPA");
		Dao dao= new Dao();
		dao.saveOrUpdate(getLesDentsDeLaMer(), em, false);
		dao.saveOrUpdate(getRencontresDuTroisièmeType(), em, false);
		dao.saveOrUpdate(getLArnaque(), em, false);
		dao.saveOrUpdate(getExtravagances(), em, false);
		em.close();
	}
	
	public static PeopleContent getRichardDreyfuss() {
		PeopleContent actor= new PeopleContent();
		actor.setType("people");
		actor.setFunction(acteur);
		actor.setFirstName("Richard");
		actor.setLastName("Dreyfuss");
		actor.setBiography("Richard Stephen Dreyfuss (born October 29, 1947) is an American actor best known for starring in a number of film, television, and theater roles since the late 1960s, including the films American Graffiti, Jaws, Close Encounters of the Third Kind, The Goodbye Girl, Stakeout, Always, What About Bob? and Mr. Holland's Opus…");
		actor.setPicture("https://image.tmdb.org/t/p/w600_and_h900_bestv2/7JPMhXnfY5jgPbtByutwkHHZS3M.jpg");
		actor.setBirthDay(1947);
		return actor;
	}
	
	public static PeopleContent getPaulNewman() {
		PeopleContent actor= new PeopleContent();
		actor.setType("people");
		actor.setFunction(acteur);
		actor.setFirstName("Paul");
		actor.setLastName("Newman");
		actor.setBiography("Paul Leonard Newman (January 26, 1925 – September 26, 2008) was an American actor, film director, entrepreneur, humanitarian, professional racing driver, auto racing team owner, and auto racing enthusiast. He won numerous awards, including an Academy Award for best actor for his performance in the 1986 Martin Scorsese film The Color of Money and eight other nominations, three Golden Globe Awards, a BAFTA Award, a Screen Actors Guild Award, a Cannes Film Festival…");
		actor.setPicture("https://image.tmdb.org/t/p/w600_and_h900_bestv2/my0Blo9IBy1WZ0QKbuxUzS0QwV5.jpg");
		actor.setBirthDay(1925);
		return actor;
	}
	
	public static PeopleContent getMelindaDillon() {
		PeopleContent actor= new PeopleContent();
		actor.setType("people");
		actor.setFunction(acteur);
		actor.setFirstName("Melinda");
		actor.setLastName("Dillon");
		actor.setBiography("Melinda Rose Dillon (born October 13, 1939) is an American actress, perhaps best known for her roles in Close Encounters of the Third Kind and the holiday classic A Christmas Story. Description above from the Wikipedia article Melinda Dillon, licensed under CC-BY-SA, full list of contributors on Wikipedia.");
		actor.setPicture("https://image.tmdb.org/t/p/w600_and_h900_bestv2/f4DU3lNCJqNVgwDZmHMlNV96rKV.jpg");
		actor.setBirthDay(1939);
		return actor;
	}
	
	public static PeopleContent getPatrickSwayze() {
		PeopleContent actor= new PeopleContent();
		actor.setType("people");
		actor.setFunction(acteur);
		actor.setFirstName("Patrick");
		actor.setLastName("Swayze");
		actor.setBiography("Patrick Wayne Swayze (August 18, 1952 – September 14, 2009)  was an American actor, dancer and singer-songwriter. He was best-known for his tough-guy roles, as romantic leading men in the hit films Dirty Dancing and Ghost and as Orry Main in the North and South television miniseries. He was named by People magazine as its \"Sexiest Man Alive\" in 1991. His film and TV career spanned 30 years.");
		actor.setPicture("https://image.tmdb.org/t/p/w600_and_h900_bestv2/b5G8AGP609DsUeokQ1asnqYJBSl.jpg");
		actor.setBirthDay(1952);
		return actor;
	}
	
	public static PeopleContent getWesleySnipes() {
		PeopleContent actor= new PeopleContent();
		actor.setType("people");
		actor.setFunction(acteur);
		actor.setFirstName("Wesley");
		actor.setLastName("Snipes");
		actor.setBiography("Wesley Trent Snipes, dit Wesley Snipes, est un acteur et producteur américain, né le 31 juillet 1962 à Orlando, en Floride (États-Unis). Longtemps second rôle de luxe, il accède à la célébrité au début des années 1990 avec Jungle Fever de Spike Lee, New Jack City, et des films à succès comme Passager 57 et Demolition Man, avant de franchir encore une étape dans sa carrière en 1998 grâce au rôle de tueur du vampires de la saga Blade. Il a débuté sa carrière audiovisuelle dans le clip de la chanson Bad de Michael…");
		actor.setPicture("https://image.tmdb.org/t/p/w600_and_h900_bestv2/hQ6EBa6vgu7HoZpzms8Y10VL5Iw.jpg");
		actor.setBirthDay(1962);
		return actor;
	}
	
	public static PeopleContent getRoyScheider() {
		PeopleContent actor= new PeopleContent();
		actor.setType("people");
		actor.setFunction(acteur);
		actor.setFirstName("Roy");
		actor.setLastName("Scheider");
		actor.setBiography("Roy Richard Scheider (November 10, 1932 – February 10, 2008) was an American actor. He was best known for his role as police chief Martin C. Brody in Jaws, as choreographer and film director Joe Gideon in All That Jazz, detective Buddy \"Cloudy\" Russo in The French Connection and his role as Captain Nathan Bridger in science fiction television series seaQuest DSV. Scheider's final performance is to be released posthumously in the 2011 thriller Iron Cross. Described by…");
		actor.setPicture("https://image.tmdb.org/t/p/w600_and_h900_bestv2/gx1jsvIL2OCzG6TOnl7ErgD28ZU.jpg");
		actor.setBirthDay(1932);
		return actor;
	}
	
	public static PeopleContent getRobertShaw() {
		PeopleContent actor= new PeopleContent();
		actor.setType("people");
		actor.setFunction(acteur);
		actor.setFirstName("Robert");
		actor.setLastName("Shaw");
		actor.setBiography("Robert Archibald Shaw (9 August 1927 – 28 August 1978) was an English stage and film actor and novelist, remembered for his performances in The Sting, From Russia with Love, A Man for All Seasons, the original The Taking of Pelham One Two Three (1974), Black Sunday (1977), The Deep (1977) and Jaws, where he played the shark hunter Quint…");
		actor.setPicture("https://image.tmdb.org/t/p/w600_and_h900_bestv2/yXXFj6cxw8l7Hxo16HaqNF4xN6v.jpg");
		actor.setBirthDay(1927);
		return actor;
	}
	
	public static Movie getLesDentsDeLaMer() {
		Movie movie= new Movie();
		movie.setType("movie");
		movie.setTitle("Les Dents de la mer");
		movie.setReleaseDate(1975);
		movie.setSynopsis("À quelques jours du début de la saison estivale, les habitants de la petite station balnéaire d'Amity sont mis en émoi par la découverte sur le littoral du corps atrocement mutilé d'une jeune vacancière. Pour Martin Brody, le chef de la police, il ne fait aucun doute que la jeune fille a été victime d'un requin. Il décide alors d'interdire l'accès des plages mais se heurte à l'hostilité du maire uniquement intéressé par l'afflux des touristes. Pendant ce temps, le requin continue à semer la terreur le long des côtes et à dévorer les baigneurs...");
		movie.setPicture("https://image.tmdb.org/t/p/w600_and_h900_bestv2/tBIvOYGJRK1CmvYkf2A3wiKm7IN.jpg");
		movie.setActor(getRichardDreyfuss());
		movie.setActor(getRobertShaw());
		movie.setActor(getRoyScheider());
		movie.setCategory(horreur);
		movie.setCategory(adventure);
		movie.setCategory(thriller);
		return movie;
	}
	
	public static Movie getRencontresDuTroisièmeType() {
		Movie movie= new Movie();
		movie.setType("movie");
		movie.setTitle("Rencontres du troisième type");
		movie.setReleaseDate(1977);
		movie.setSynopsis("Des faits étranges se produisent un peu partout dans le monde : des avions qui avaient disparu durant la Seconde Guerre mondiale sont retrouvés au Mexique en parfait état de marche, un cargo est découvert échoué au beau milieu du désert de Gobi. Dans l'Indiana, pendant qu'une coupure d'électricité paralyse la banlieue, Roy Neary, un réparateur de câbles, voit une \"soucoupe volante\" passer au-dessus de sa voiture. D'autres personnes sont également témoins de ce type de phénomène : Barry Guiler, un petit garçon de quatre ans, est réveillé par le bruit de ses jouets qui se mettent en route. Cherchant à savoir d'où proviennent ces ovnis, Roy Neary se heurte aux rigoureuses consignes de silence imposées par le gouvernement fédéral. Obsédé par ce qu'il a vu et hanté par une image de montagne qu'il essaie désespérément de reconstituer, il est abandonné par sa femme Ronnie et ses enfants. Il n'y a que Jillian, la mère de Barry, qui le comprenne.");
		movie.setPicture("https://image.tmdb.org/t/p/w600_and_h900_bestv2/7JEJwW3LMaOsmZT2A3DGxQsuP7F.jpg");
		movie.setActor(getRichardDreyfuss());
		movie.setActor(getMelindaDillon());
		movie.setCategory(drame);
		movie.setCategory(sf);
		return movie;
	}
	
	public static Movie getLArnaque() {
		Movie movie= new Movie();
		movie.setType("movie");
		movie.setTitle("L'arnaque");
		movie.setReleaseDate(1973);
		movie.setSynopsis("A Chicago, en 1936, Johnny Hooker et son acolyte Coleman volent sans le savoir le convoyeur de fonds de Doyle Lonnegan, un dangereux gangster de New York. Coleman est aussitôt abattu par le gang de ce dernier et Hooker se réfugie chez Henry Gondorff, un spécialiste de l'arnaque.Ceux-ci décident alors de venger la mort de Coleman en montant une vaste escroquerie destinée à mettre Lonnegan sur la paille. Pour cela, Hooker fait croire au gangster qu'il est capable d'obtenir les résultats des courses avant qu'ils ne soient officiellement connus.");
		movie.setPicture("https://image.tmdb.org/t/p/w600_and_h900_bestv2/23pgQqSLuq7PJoOba9QJdCWPfrG.jpg");
		movie.setActor(getRobertShaw());
		movie.setActor(getPaulNewman());
		return movie;
	}
	
	public static Movie getExtravagances() {
		Movie movie= new Movie();
		movie.setType("movie");
		movie.setTitle("Extravagances");
		movie.setReleaseDate(1995);
		movie.setSynopsis("Trois drags queens en quête de gloire hollywoodienne tombent en panne et se retrouvent coincées pour le weekend dans un petit village perdu des États-Unis. (from french wikipedia)");
		movie.setPicture("https://image.tmdb.org/t/p/w600_and_h900_bestv2/xIDEoG9FQGmMCh5XsbkvSuD8WrW.jpg");
		movie.setActor(getPatrickSwayze());
		movie.setActor(getWesleySnipes());
		movie.setCategory(comedie);
		return movie;
	}
}
