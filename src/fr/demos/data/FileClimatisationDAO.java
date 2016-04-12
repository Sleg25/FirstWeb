package fr.demos.data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import fr.demos.formation.Climatisation;

public class FileClimatisationDAO implements ClimatisationDAO{
	
	
	public void sauve(Climatisation cl) throws Exception {
		List<Climatisation> listeClimatiseurs;
		
		try{
		listeClimatiseurs = this.rechercheTout();
		}
		catch(Exception  e){
			//Si la recherche plante, ce n'est pas forcément un pb : le fichier n'existe pas encore.
			System.out.println(e.getMessage());
			//On créé la liste car on ne la pas récupérer depuis le fichier
			listeClimatiseurs = new ArrayList<>();
		}
//		try(ObjectInputStream ois =new ObjectInputStream(new BufferedInputStream(new FileInputStream("climatiseurs")));){
//				listeClimatiseurs = (ArrayList)ois.readObject();
//		}
		
// Plus besoin des catch ici car on propage l'exception, les erreurs seront donc géré dans le controller
//		catch(IOException exc){
//			System.out.println(exc.getMessage());
//		}
//		catch(ClassNotFoundException exc){
//			System.out.println(exc.getMessage());
//		}
		
		listeClimatiseurs.add(cl);
		try (ObjectOutputStream oos =new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("climatiseurs")));){
			oos.writeObject(listeClimatiseurs);
			oos.flush();
		}
// Voir plus haut l'explication sur la gestion d'erreur:
//			catch(IOException exc) 
//			{ System.out.println(exc.getMessage());}
	}


	public List<Climatisation> rechercheTout() throws Exception {
		ArrayList<Climatisation> listeClimatiseurs = null;
		try(ObjectInputStream ois =new ObjectInputStream(new BufferedInputStream(new FileInputStream("climatiseurs")));){
			listeClimatiseurs = (ArrayList<Climatisation>)ois.readObject();
		}
		
//Voir explication plus haut.
//		catch(IOException exc){
//			System.out.println(exc.getMessage());
//		}
//		catch(ClassNotFoundException exc){
//			System.out.println(exc.getMessage());
//		}
		return listeClimatiseurs;
	}


	public List<Climatisation> recherche() throws Exception {
		return null;
	}


	@Override
	public int nombreClimatisation(String critere){
		// TODO Auto-generated method stub
		List<Climatisation> listeClimatiseurs = null;
		int nombreClimatisations = 0;
		
		try{
		listeClimatiseurs = this.rechercheTout();
		nombreClimatisations = listeClimatiseurs.size();
		}
		catch(Exception  e){		
			System.out.println(e.getMessage());
		}
		return nombreClimatisations;
	}

}
