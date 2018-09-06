package fr.dawan.reseauSoc.fixtures;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.dawan.reseauSoc.beans.Category;
import fr.dawan.reseauSoc.beans.Serie;

public class SerieFixture {
	
	Serie serieCodeQuantium= new Serie();
	Serie serieMagnum= new Serie();


	public SerieFixture() {
		super();
		serieCodeQuantium.setId(1);
		serieCodeQuantium.setNom("Code Quantium");
		Category catSF= new Category();
		
		catSF.setId(1);
		catSF.setName("science-fiction");
		serieCodeQuantium.setCategory(catSF);

		serieCodeQuantium.setReleaseDate(LocalDate.of(1989, 1, 1));
		
		serieMagnum.setId(2);
		serieMagnum.setNom("Magnum");
		Category catpoliciere= new Category();
		
		catSF.setId(1);
		catSF.setName("policière");
		serieMagnum.setCategory(catpoliciere);

		serieMagnum.setReleaseDate(LocalDate.of(1980, 1, 1));
	}

	public List<Serie> listSerie() {
		
		List<Serie> listSerie= new ArrayList<Serie>();
		listSerie.add(serieCodeQuantium);
		listSerie.add(serieMagnum);
		return listSerie;
	}
}
