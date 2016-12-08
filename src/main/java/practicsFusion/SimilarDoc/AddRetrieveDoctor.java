package practicsFusion.SimilarDoc;
import java.util.*;

/**
 *  
 * @author amitn
 * 
 *   Singleton Class
 *   
 *   This class is Main Class For retrieving Doctor details and adding doctors in DB.
 *   It is kind of middle Tier
 *   It has two Maps :
 *      DoctorList :  It stores the Doctor object and details and key is the name;
 *      AreaWiseDoctor :  It stored the List of Similar Doctors at the same location:
 *               Key is Locality (latitude and Longitude)
 *   All the operations for finding Similar doctor would use the above two maps
 */
public class AddRetrieveDoctor {
	
	private static AddRetrieveDoctor addDoctorInstance = new AddRetrieveDoctor();
    private static Map<String, Doctor> DoctorList = new HashMap<>();
    private static Map<Locality,List<Doctor>> AreaWiseDoctor = new HashMap<>();
   
	// This function returns the Singleton Object
    
    public static AddRetrieveDoctor getInstance( ) {
        return addDoctorInstance;
     }
    
    // This Function adds Doctor to DataBase and do the pre processing so as to use it Later
    
    public void addADoctor(String name, int yearsOfEx, Locality locality, List<Doctor.Speciality> speciality ){
		Doctor  doctor = new Doctor(name, yearsOfEx,locality,speciality);
		int  xLat = locality.getLatitude();
		int  yLong =  locality.getLongitude();
		DoctorList.put(name, doctor);

		if(AreaWiseDoctor.containsKey(new Locality(xLat,yLong))){
			List<Doctor> docList= AreaWiseDoctor.get(new Locality(xLat,yLong));
			AreaWiseDoctor.put(new Locality(xLat,yLong),docList);
			docList.add(doctor);
			
		}
		else {
			Locality localty= new Locality(xLat,yLong);
			List<Doctor> docList = new ArrayList<>();
			docList.add(doctor);
			AreaWiseDoctor.put(locality,docList);
		}		
	}
    // made Constructor private as it is singleton class
    private AddRetrieveDoctor(){ }
    
    public static Map<Locality, List<Doctor>> getAreaWiseDoctor() {
		return AreaWiseDoctor;
	}
	
	public static Doctor getADoctor( String name){
		Doctor  doctor = DoctorList.get(name);
		return doctor;
	}
	
	public static Map<String, Doctor> getDoctorList() {
		return DoctorList;
	}
	
	public void setDoctorList(Map<String, Doctor> doctorList) {
		DoctorList = doctorList;
	}
    
	
}
