package fr.dawan.reseauSoc.main;

public class Main {
	
	public static void main(String[] args) {
//		AddFilm.saveMovie();
//		AddUser.saveUser();
//		AddSerie.save();
		String p= "Lorem ipsum dolor sip";
		System.out.println(p.length());
		System.out.println(p);
		if(p.length() > 20)
			System.out.println(p.substring(0, 20)+"...");
		else
			System.out.println("on coupe pas");
	}
}
