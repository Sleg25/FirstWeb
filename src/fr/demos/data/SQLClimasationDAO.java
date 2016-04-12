package fr.demos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import fr.demos.formation.Climatisation;

public class SQLClimasationDAO implements ClimatisationDAO{
	
	private DataSource ds;

	public SQLClimasationDAO() throws Exception{
		//recherhce dans l'annuaire du pool de connexions (utilisation de la librairie JNDI)
		Context context = new InitialContext();
		ds = (DataSource)context.lookup("jdbc/appliclim");
	}

	
	@Override
	public void sauve(Climatisation cl) throws Exception {
		
		//on demande une connexion au pool 
		Connection cx = ds.getConnection();
		//On va pouvoir préparer notre requête SQL
		PreparedStatement psmt = cx.prepareStatement("insert into climatisation values (?,?,?,?)");
		psmt.setString(1, cl.getNomEmetteur());
		psmt.setDouble(2, cl.getTemperature());
		psmt.setDouble(3, cl.getPression());
		psmt.setLong(4, cl.getDatation());
		psmt.executeUpdate();
		//On rend la connexion au pool
		cx.close();
		
		
	}

	@Override
	public List<Climatisation> rechercheTout() throws Exception {
		Connection cx = ds.getConnection();
		PreparedStatement psmt = cx.prepareStatement("select * from climatisation");
		ResultSet rs = psmt.executeQuery();
		ArrayList<Climatisation> liste = new ArrayList<>();
		while(rs.next()){
			String nomAppareil = rs.getString(1);
			double temperature = rs.getDouble(2);
			double pression = rs.getDouble(3);
			long datation = rs.getLong(4);
			Climatisation cl = new Climatisation(temperature,pression,nomAppareil);
			liste.add(cl);
		}
		return liste;
	}

	@Override
	public List<Climatisation> recherche() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nombreClimatisation(String critere) {
		int nb=0;
		try{
			List<Climatisation> liste = this.rechercheTout();
			nb = liste.size();
		}
		catch(Exception exc){}
		return nb;
	}

}
