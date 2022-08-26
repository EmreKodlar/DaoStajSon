package Dao;

import java.util.List;

import Model.Doctor;
import Model.Hasta;


public interface IHasta {
	
	   public void getHastaName();
	   public void deleteHasta(Hasta hasta);
	   public void addHasta(Hasta hasta);
	   public void updateHasta(Hasta hasta);
	   public List<Hasta> getHastaList();

}
