
package practicsFusion.SimilarDoc;
/**
 *  This class calculates the distance between two doctors and returns the list of doctors 
 *  sorted by distance from  the Doctor we need to find
 *   
 */

import java.util.*;


public class NearByDoctors {
	
	
	// COnstructor Class
	// It will take input Doctors name and 
     public NearByDoctors(String name) {
		this.name = name;
	}
   
    /*
     * Function getNearByDoctor(int Distance)  will take input distance in which it has to find the doctors;
     * 
     * Output : TreeMap of doctors sorted with distance
     * 
     * have divided distance by 0.7 as latitude and longitudes are already multiplied by 100;
     *  Suppose we have to look for 100 miles
     *  Since 1 degree = 69 miles;
     *  so 100 degree differece in stored latitude will correspond to 69 miles
     *  so for 100 miles we have to look 100*100/69 ;
     *  so divided by 0.7 
     */
     
    public Map<Double, Doctor> getNearByDoctor(int distance){
    	Map<String,Doctor> docMap= AddRetrieveDoctor.getDoctorList();
    	Map<Locality, List<Doctor>> AreaWiseDoctorMap= AddRetrieveDoctor.getAreaWiseDoctor();
    	Doctor doctor = docMap.get(name);
    	int xLat = doctor.getLocality().getLatitude();
    	int yLong = doctor.getLocality().getLongitude();
		int unitToLook = (int)(distance/0.7) ;
		List<Doctor> doctorList = new ArrayList<>();
		for(int i = xLat-unitToLook;i <xLat+unitToLook;i++ ){
			for(int j = yLong-unitToLook;j <yLong+unitToLook;j++ ){
			    List<Doctor> doctorAreaWise = AreaWiseDoctorMap.get(new Locality(i,j));
				if(doctorAreaWise!=null && doctorAreaWise.size()!=0 ) doctorList.addAll(doctorAreaWise);		
			}
		}
		
		Map<Double,Doctor> distanceFromDoctor = new TreeMap<>();
		for(Doctor doc: doctorList){
			double dist = calculateDistance(doc,doctor);
			if(dist>distance) continue;
			distanceFromDoctor.put(dist, doc);
		}
		return distanceFromDoctor;	
    }
    
    /*
     *  calculates the distance by using distance formula;
     */
    
    private double calculateDistance(Doctor d1,Doctor d2){
    	double xLat1  = d1.getLocality().getLatitude();
    	double yLong1 = d1.getLocality().getLongitude();
		double xLat2  = d2.getLocality().getLatitude();
    	double yLong2 = d2.getLocality().getLongitude();
        return Math.pow((Math.pow((xLat1-xLat2),2)+Math.pow((yLong1- yLong2),2)),0.5);
    }
	private String name;
     
}
