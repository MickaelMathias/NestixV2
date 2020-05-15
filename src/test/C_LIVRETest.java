package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import objets.C_LIVRE;

class C_LIVRETest {

	@Before
	public void setUp() throws Exception
	{
		
	}
	
	@After
	public void tearDown() throws Exception
	{
		
	}
	
	@Test
	//Cr�ation et suppression d'un livre
	public void testCreationLivreBdd()
	{
		C_LIVRE livre = new C_LIVRE();
		livre.setMedia_titre("Cyrano de Bergerac");
		livre.setMedia_annee("1897");
		livre.setMedia_type("Livre");
		livre.setMedia_lien("unLien");
		
		int i = livre.creationMediaBdd(2);
		assertEquals(1, i);

		int media_id = bdd.C_requetes.rechercheId("SELECT book_id FROM book ORDER BY book_id DESC LIMIT 1");		
		int j = livre.suppressionMediaBdd(media_id);
		assertEquals(1, j);
	}
	
	@Test
	//Modification de l'ISBN et du synopsis du livre
	public void testModificationLivreBdd()
	{
		C_LIVRE livre = new C_LIVRE();
		livre.setMedia_titre("Cyrano de Bergerac");
		livre.setMedia_annee("1897");
		livre.setMedia_type("Livre");
		livre.setMedia_lien("unLien");
		
		livre.setLivre_isbn("9782266152174");
		livre.setLivre_synop("Le malheureux Cyrano de Bergerac, un po�te et bretteur affubl� d\\'un nez d�mesur�ment grand, aime secr�tement sa ravissante cousine Roxane. Se jugeant laid, il n\\'ose lui d�clarer sa flamme. La jeune femme lui confie bient�t sa passion pour un jeune cadet de Gascogne, le s�duisant mais insipide Christian de Neuvillette. Quand Roxane lui fait promettre de prendre son bien-aim� sous sa protection, Cyrano accepte de se sacrifier. Il impose silence � son c�ur et met son esprit et sa verve au service de son rival. Cyrano propose de lui r�diger ses mots d�amour.");
		
		int i = livre.creationMediaBdd(2);
		assertEquals(1, i);

		int media_id = bdd.C_requetes.rechercheId("SELECT book_id FROM book ORDER BY book_id DESC LIMIT 1");
		int j = bdd.C_connexion.ex_Update("UPDATE book SET ISBN = " + livre.getLivre_isbn() + ", book_synop = '" + livre.getLivre_synop() + "' WHERE book_id = " + media_id);
		assertEquals(1, j);
				
		int k = livre.suppressionMediaBdd(media_id);
		assertEquals(1, k);
	}
	
	@Test
	//Cr�ation d'un livre par son id, on teste si l'ISBN du livre est le m�me que celui de la BDD
	public void testCreerLivreAvecId()
	{
		C_LIVRE livre = new C_LIVRE().creerLivreAvecId(106);
		
		System.out.println(livre.toString());
		
		int i = 0;
		if(livre.getLivre_isbn().equals("9782075120401"))
			i = 1;
		assertEquals(1, i);
	}

}
