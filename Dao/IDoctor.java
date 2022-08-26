package Dao;

import java.util.List;

import Model.Doctor;


public interface IDoctor {
	
	   public String getDoctorsName(int dr_id);
	   public void deleteDoctor(Doctor doctor);
	   public void addUser(Doctor doctor);
	   public void updateDoctor(Doctor doctor);
	   public List<Doctor> getDoctorList();

}
