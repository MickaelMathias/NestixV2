package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import objets.C_MEDIA;

public class C_MEDIATest {
	

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	//Création et suppression de media
	public void testcreationMediaBdd() {
		C_MEDIA media = new C_MEDIA();
		media.setMedia_annee("2002");
		media.setMedia_titre("TitreDeTest");
		media.setMedia_type("Film");
		media.setMedia_lien("blabla");
		
		int i = media.creationMediaBdd(2);
		assertEquals(1, i);
		
		int media_id = bdd.C_requetes.rechercheId("SELECT media_id FROM media ORDER BY media_id DESC LIMIT 1");		
		int j = media.suppressionMediaBdd(media_id);
		assertEquals(1, j);
		
	}
	
	@Test
	//Pas de doublons année/titre/type
	public void testcreationMediaBddDoublon() {
		C_MEDIA media = new C_MEDIA();
		media.setMedia_annee("2003");
		media.setMedia_titre("TitreDeTest");
		media.setMedia_type("Film");
		media.setMedia_lien("blabla");
		
		int i = media.creationMediaBdd(2);
		assertEquals(1, i);
		
		int j = media.creationMediaBdd(2);
		assertEquals(-1, j);
		
		int media_id = bdd.C_requetes.rechercheId("SELECT media_id FROM media ORDER BY media_id DESC LIMIT 1");		
		int k = media.suppressionMediaBdd(media_id);
		assertEquals(1, k);
	}
	
	@Test
	//Modification de statut
	public void testModifStatut() {
		C_MEDIA media = new C_MEDIA();
		media.setMedia_annee("2003");
		media.setMedia_titre("TitreDeTest");
		media.setMedia_type("Film");
		media.setMedia_lien("blabla");
		
		int i = media.creationMediaBdd(2);
		assertEquals(1, i);
		
		int media_id = bdd.C_requetes.rechercheId("SELECT media_id FROM media ORDER BY media_id DESC LIMIT 1");		
		int j = media.blocageMediaBdd(media_id);
		assertEquals(1, j);
		
		int k = media.suppressionMediaBdd(media_id);
		assertEquals(1, k);
	}
	
	/*
	@Test
	//Vérification de la concaténation de media_link pour ne pas dépasser 255 caractères
	public void testLength() {
		String str = "abcde";
		String longStr = str.repeat(53); //5*53 = 265 caractères
		int length = longStr.length();
		assertEquals(265, length);
		
		C_MEDIA media = new C_MEDIA();
		media.setMedia_annee("2003");
		media.setMedia_titre("TitreDeTest");
		media.setMedia_type("Film");
		media.setMedia_lien(longStr);
		
		int i = media.creationMediaBdd(2);
		assertEquals(1, i);
		
		int media_id = bdd.C_requetes.rechercheId("SELECT media_id FROM media ORDER BY media_id DESC LIMIT 1");	
		String [][] mediaFound = bdd.C_requetes.rechercheMedia("SELECT * FROM media WHERE media_id ="+media_id+"");	
		String media_link = mediaFound[0][5];
		int length2 = media_link.length();
		assertEquals(255, length2);
		
		int k = media.suppressionMediaBdd(media_id);
		assertEquals(1, k);
	}
	*/
	

}

