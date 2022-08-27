package Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import Dao.DaoHasta;
import Model.Hasta;

public class HastaController {
	
	
	DaoHasta daoH=new DaoHasta();
	
	
	public void add_Hasta(Hasta has) {
		 
		daoH.addHasta(has); 
		
			}

	 
	public void update_Hasta(Hasta has) {
				
		daoH.updateHasta(has); 
				 
			}

	 
	public List<Hasta> get_HastaList() {
				 
			 return daoH.getHastaList();
			}

	
	public void get_HastaName() {
				 
		
				
			}

	 
	public void delete_Hasta(Hasta has) {

			 
		daoH.deleteHasta(has);
				
			}
			


}
