package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import objets.C_ARTISTE;

public class C_ARTISTETEST {
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
    }
    
    @Test
	//Création et suppression d'un artiste
	public void testcreationArtisteBdd() {
        C_ARTISTE artiste = new C_ARTISTE();
		artiste.setHuman_nom("Georges");
		artiste.setHuman_dob("NULL");
		artiste.setHuman_sexe("NULL");
		artiste.setHuman_prenom("Georgette");

		artiste.setArtiste_nickname("Georginou");
		artiste.setArtiste_dod("NULL");
		
		int i = artiste.creationHumanBdd();
 		 artiste.creationArtisteBdd(2); 
	 	assertEquals(1, i);  
		
		int artiste_id = bdd.C_requetes.rechercheId("SELECT human_id FROM human ORDER BY human_id DESC LIMIT 1");		
		int j = artiste.suppressionHumanBdd(artiste_id);
		assertEquals(1, j);
		 
	}

	@Test
	//Modification de statut
	public void testModifStatut() {
        C_ARTISTE artiste = new C_ARTISTE();
		artiste.setHuman_nom("Georges");
		artiste.setHuman_dob("NULL");
		artiste.setHuman_sexe("NULL");
		artiste.setHuman_prenom("Georgette");

		artiste.setArtiste_nickname("Georginou");
		artiste.setArtiste_dod("NULL");
		
		int i = artiste.creationHumanBdd();
 		 artiste.creationArtisteBdd(2); 
	 	assertEquals(1, i);  
			
 		int j = artiste.blocageHumanBdd(artiste.getHuman_id());
		assertEquals(1, j);
		
		int h = artiste.suppressionHumanBdd(artiste.getHuman_id());
		assertEquals(1, h);
	}

	@Test
	//Modification d'artiste
	public void testModifArtiste() {
        C_ARTISTE artiste = new C_ARTISTE();
		artiste.setHuman_nom("Georges");
		artiste.setHuman_dob("NULL");
		artiste.setHuman_sexe("NULL");
		artiste.setHuman_prenom("Georgette");

		artiste.setArtiste_nickname("Georginou");
		artiste.setArtiste_dod("NULL");
		
		int i = artiste.creationHumanBdd();
 		artiste.creationArtisteBdd(2); 
		 assertEquals(1, i);  
		 
		int l = artiste.suppressionHumanBdd(artiste.getHuman_id());
		assertEquals(1, l);
			
		artiste.setHuman_prenom("Luc");
		int j = artiste.modificationHumanBdd();
 		assertEquals("Luc",artiste.getHuman_prenom()); 
		assertEquals(1, j);
		
		int h = artiste.suppressionHumanBdd(artiste.getHuman_id());
		assertEquals(1, h);
	}
}