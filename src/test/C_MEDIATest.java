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
	public void testcreationMediaBdd() {
		C_MEDIA media = new C_MEDIA();
		media.setMedia_annee("2001");
		media.setMedia_titre("TitreDeTest");
		media.setMedia_type("Film");
		media.setMedia_lien("blabla");
		int i = media.creationMediaBdd(2);

		assertEquals(1, i);
		
		int media_id = bdd.C_requetes.rechercheId("SELECT media_id FROM media ORDER BY media_id DESC LIMIT 1");		
		int j = media.suppressionMediaBdd(media_id);
		
		assertEquals(1, j);
		
	}

}
