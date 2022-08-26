package Controller;

 

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import Dao.DaoClinic;
import Model.Clinic;

public class ClinicController {
	
	DaoClinic cli=new DaoClinic();
	
	public void delete_Clinic(Clinic clinic) {

		cli.deleteClinic(clinic);
		 
	}
	
	 
	public void add_Clinic(Clinic clinic) {
		
		cli.addClinic(clinic);
	 
	}

	 
	public void update_Clinic(Clinic clinic) {
		
		cli.updateClinic(clinic);
	}

	 
	public List<Clinic> get_ClinicList() {

	 
	 
		return cli.getClinicList();
	}
	
	
	public String get_ClinicName(int id) {

 
		return cli.getClinicName(id);
	 
	}

}
