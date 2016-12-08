package practicsFusion.SimilarDoc;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import practicsFusion.SimilarDoc.Doctor.Speciality;
/**
 * 
 * @author amitn
 *
 *  This is the Class with the Main entry;
 *   This class Invokes the creation of Other Class Instance and find SImilar Doctors
 */
public class FindDoctorApp 
{
	private static String name;
	private static int distance;
	
	
	public static void main( String[] args )
    {
		
		FindDoctorApp findDoctor= new FindDoctorApp("Amit",40);
        List<String> similarDocList = findDoctor.findSimilarDoctor();
        for(String name: similarDocList){
        	System.out.println(name);        	
        }
    }
	
	/*
	 *   We are passing Doctor Name and distance in which we need to find Similar Doctors
	 *   Returns the list of Doctor Names;
	 */
	public  List<String> findSimilarDoctor(){
		SimilarDoctors similar = new SimilarDoctors(this.name,this.distance);
        List<Doctor> similarDocList = similar.ListOfSimilarDoctors();
        List<String> docListName = new ArrayList<>();
        
        for(Doctor doctor : similarDocList){
        	docListName.add(doctor.getName());
        }
        return docListName;
        
	}
	
	public FindDoctorApp(String name, int distance){
		this.name = name;
		this.distance = distance;
		AddRetrieveDoctor  ardInstance = AddRetrieveDoctor.getInstance();
    	addDoctors(ardInstance);
	}
	
	
	
	
	
	
	/*
	 *   This function created Doctor Object which is used for testing
	 * 
	 */
	public static void addDoctors(AddRetrieveDoctor  ardInstance){

    	ardInstance.addADoctor("John", 5, new Locality(37.3541,121.9552),
    		new ArrayList<Doctor.Speciality>(){{
    		   add(Doctor.Speciality.ANESTHESIOLOGY);
    	       add(Doctor.Speciality.CARDIOLOGY);
    	       add(Doctor.Speciality.ONCOLOGY);
    	    }}
    	);
    	
    	ardInstance.addADoctor("Amit", 10, new Locality(36.9923,121.8812), 
    	    new ArrayList<Doctor.Speciality>(){{
 		       add(Doctor.Speciality.ANESTHESIOLOGY);
 	           add(Doctor.Speciality.CARDIOLOGY);
 	           add(Doctor.Speciality.ONCOLOGY);
 	           add(Doctor.Speciality.DERMATOLOGY);
 	        }}
    	);
    	ardInstance.addADoctor("Jefferey", 8, new Locality(37.33,122.3345), 
        	    new ArrayList<Doctor.Speciality>(){{
     		       add(Doctor.Speciality.CHIROPRACTIC);
     	           add(Doctor.Speciality.HOMEOPATHY);
     	           add(Doctor.Speciality.ONCOLOGY);
     	        }}
        	);
    	
    	ardInstance.addADoctor("Kevin", 20, new Locality(37.3942,121.8812), 
        	    new ArrayList<Doctor.Speciality>(){{
     		       add(Doctor.Speciality.ANESTHESIOLOGY);
     	           add(Doctor.Speciality.ONCOLOGY);
     	           add(Doctor.Speciality.CARDIOLOGY);
     	           add(Doctor.Speciality.DERMATOLOGY);
     	           
     	        }}
        	);
    	ardInstance.addADoctor("Brian", 30, new Locality(37.0123,122.1134), 
        	    new ArrayList<Doctor.Speciality>(){{
     		       add(Doctor.Speciality.ANESTHESIOLOGY);
     	           add(Doctor.Speciality.CARDIOLOGY);
     	           add(Doctor.Speciality.HOMEOPATHY);
     	           add(Doctor.Speciality.PSYCHOLOGY);
     	           add(Doctor.Speciality.DERMATOLOGY);
     	        }}
        	);
    	ardInstance.addADoctor("Mark", 9, new Locality(37.012,122.123), 
        	    new ArrayList<Doctor.Speciality>(){{
     		       add(Doctor.Speciality.PSYCHOLOGY);
     	           add(Doctor.Speciality.CARDIOLOGY);
     	           add(Doctor.Speciality.DENTISTRY);
     	        }}
        	);
    	ardInstance.addADoctor("Jimmy", 2, new Locality(37.3541,121.9652), 
        	    new ArrayList<Doctor.Speciality>(){{
     		       add(Doctor.Speciality.ANESTHESIOLOGY);
     	           add(Doctor.Speciality.CARDIOLOGY);

     	        }}
        	);
    	ardInstance.addADoctor("Johnny", 25, new Locality(39.2212,121.9652), 
        	    new ArrayList<Doctor.Speciality>(){{
     		       add(Doctor.Speciality.ANESTHESIOLOGY);
     	           add(Doctor.Speciality.CARDIOLOGY);
     	           add(Doctor.Speciality.PSYCHOLOGY);
     	        }}
        	);
    	
	}
	
	
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		FindDoctorApp.name = name;
	}
	public static int getDistance() {
		return distance;
	}
	public static void setDistance(int distance) {
		FindDoctorApp.distance = distance;
	}
	
}
