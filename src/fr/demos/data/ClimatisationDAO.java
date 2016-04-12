package fr.demos.data;

import java.util.List;

import fr.demos.formation.Climatisation;

//DAO Data access Object
public interface ClimatisationDAO {
	void sauve(Climatisation cl) throws Exception;
	List<Climatisation>rechercheTout() throws Exception;
	List<Climatisation>recherche() throws Exception;
	int nombreClimatisation(String critere);
}
