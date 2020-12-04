package AttendanceSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Organisation {
	public HashMap<String,Employee> allEmp;
	public int id;
	public HashMap<String,Employee> currentlyWorking;
	
	
	
	public Organisation(){
		allEmp = new HashMap<String,Employee>();
		currentlyWorking = new HashMap<String,Employee>();
	}
	public Organisation(HashMap<String,Employee> currentlyWorking , int id ,HashMap<String,Employee> allEmp ){
		this.allEmp = allEmp;
		this.currentlyWorking = currentlyWorking;
		this.id = id;
	}
		
	
	public void addEmp(String name, int age,  float overtimeRate, float salaryPerDay) {
		allEmp.put("empId"+ id , new Employee(name, age+"5", "empId"));
		id++;
		System.out.println("Added !!");
	}
	
	public void setAllEmp(HashMap<String,Employee> allEmp) {
		this.allEmp = allEmp;	
	}
	
	public void setId(int id) {
		this.id = id;	
	}
	
	public void setCurrentlyWorking(HashMap<String,Employee> currentlyWorking) {
		this.currentlyWorking = currentlyWorking;	
	}

	public HashMap<String,Employee> getAllEmp() {
		return allEmp;	
	}
	
	
	public int getId() {
		return id;
	}
	public HashMap<String,Employee> getCurrentlyWorking() {
		return currentlyWorking;	
	}
	
	
}
