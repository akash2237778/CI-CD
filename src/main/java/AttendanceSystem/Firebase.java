package AttendanceSystem;
import java.io.*;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.errorprone.annotations.Var;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
public class Firebase {
	FirebaseDatabase db;
	DatabaseReference dbref;
	String result;
	
	
	 public Firebase() {
		 try {
	    		File file = new File("attendancesystem-7604d-firebase-adminsdk-kdrhc-ef35be211b.json");
	 	        FileInputStream serviceAccount = new FileInputStream(file);
	 	        FirebaseOptions options = new FirebaseOptions.Builder()
	 			  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
	 			  .setDatabaseUrl("https://attendancesystem-7604d.firebaseio.com/")
	 			  .build();
	 			
	 			FirebaseApp.initializeApp(options);
	 			
	    	 }catch(Exception e) {
	    		 System.out.println("Error" + e.getMessage());
	    	 }
		 db = FirebaseDatabase.getInstance();

	 }
	 
	 
	 public DatabaseReference  setRef( String ref) {
		  dbref = db.getReference(ref);
		  return dbref;
	 }
	 
	 public FirebaseDatabase getDb() {
	        return db;
	    }
	 
	 public void saveData(String child, String value) {
		 dbref.child(child).setValueAsync(value);
	 }
	 
	 
	 public void SleepThread(int time) {
		 try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	 }
	 
	 
	 public void saveData(String child, Employee value) {
		 dbref.child(child).setValueAsync(value);
	 }
	 public void saveData(String child, Organisation value) {
		 dbref.child(child).setValueAsync(value);
	 }
	 public String retriveData(String child) {
		 int i =0;
			 dbref.child(child).addValueEventListener(new ValueEventListener() {
	   		  @Override
	   		  public void onDataChange(DataSnapshot dataSnapshot) {
	   		    result = dataSnapshot.getValue().toString();
	   		   // System.out.println( result);
	   		  }
	
	   		  @Override
	   		  public void onCancelled(DatabaseError databaseError) {
	   		    System.out.println("The read failed: " + databaseError.getCode());
	   		  }
	   		});
			 while(result == null) {
				System.out.println( "Retriving.....     " );
				
				 i++;
	
			 }
			 //SleepThread(100);
			 if(result == null) {
				// System.out.println(result + "     ");
			 return "5";
			 }
			 else {
				//System.out.println(result + "     5returning.....");
				 return result;
			 }
		 }
	 
	 public String convertToJSON(String Total) {
		
		 	Total =Total.replace("={", "\" : {");
	    	Total =Total.replace("=[", "\" : [");
	    	Total =Total.replace("=", "\" : \"");
	    	Total = Total.replace("{", "{ \"");
	    	Total = Total.replace(", ", "\" , \"");
	    	Total = Total.replace("}\"", "\" } ");
	    	Total = Total.replace("}]\"", "\"}]");
	    	//Total = Total.replace("0}", "0\"}");
	    	Total = Total.replace("st\" : [",     "st\" : [ \"");
	    	Total = Total.replace("]\" , \"", "\"] , \"");
	    	Total = Total.replace("d\" : [", "d\" : [\"");
			Total = Total.replace(", \"{",", {");
			Total = Total.replace("\"}\"","\"}");
			Total = Total.replace("}\" } ", "\"} } ");
			Total = Total.replace("]}}}", "\"]}}}");
			Total = Total.replace("]\"", "\"]");
			Total = Total.replace("}}}", "\"}}}");
			//System.out.println(Total);
	    	return Total;
	 }
	 
	 public Organisation addEmptoOrg(Organisation org , String nam, int age,  float overtimeRate, float salaryPerDay) {
		 org.addEmp(  nam , age, overtimeRate, salaryPerDay);
		 
		// org.allEmp.get("empId"+(org.id-1)).setTemperature(0.0f);
		 saveData("Organisation", org);
		 SleepThread(100);
		 return org;
	 }
	 

}
