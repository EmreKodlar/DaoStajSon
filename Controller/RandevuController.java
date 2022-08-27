package Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import Dao.DaoRandevu;
import Model.Randevu;

public class RandevuController {
	
	
	DaoRandevu daoR=new DaoRandevu(); 
	
	public void delete_Randevu(Randevu randevu) {

		daoR.deleteRandevu(randevu);
  	
	}

 
	public void add_Randevu(Randevu randevu) {


		daoR.addRandevu(randevu);
		
	}

	 
	public void update_Randevu(Randevu randevu) {
		
		daoR.updateRandevu(randevu);
	}

	 
	public List<Randevu> randevu_Listele(int hastaID) {
		
 
		return daoR.randevuListele(hastaID);
	}

}
