package Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import Dao.DaoDoctor;
import Model.Doctor;

public class DoctorController {
	
	
	DaoDoctor daoD=new DaoDoctor();
	
	
	public String get_DoctorsName(int id) {


		return daoD.getDoctorsName(id);
	 
	}

	
	public void delete_Doctor(Doctor doctor) {
		

		daoD.deleteDoctor(doctor);

		
	}

	
	public void add_User(Doctor doc) {


		daoD.addUser(doc);
		
	}

	public List<Doctor> get_DoctorList() {
 
		 
	 
		return daoD.getDoctorList();
	}

	 
	public void update_Doctor(Doctor doctor) {
		
 
		daoD.updateDoctor(doctor);
		
	}

}
