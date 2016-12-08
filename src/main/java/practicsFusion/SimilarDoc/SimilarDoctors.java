package practicsFusion.SimilarDoc;
import java.util.*;
/**
 * 
 * @author amitn
 * 
 *  This class is used to find the similar Doctors and return the list of Doctors
 *  Input : distance (radius in miles) in which it has to search and a name of Doctor
 *  
 *  Algorithm : 
 *        It will take into consideration only Doctors in the specified Radius and will not consider Doctor with 
 *        the distance greater than the spedified Distance :
 *        
 *        Below Algorithm will be applied after retrieving the list of Doctors within Radius 
 *        The List would be given by the class NearBYDoctor
 *        
 *        Calculate Score : Higher Similarity will have higher score:
 *                          There is no restriction on higher score
 *                          
 *        Used five criteria to calculate score :
 *          1) Speciality Matching : Out of 100 
 *              Suppose Doctor For which we have to find Similar Doctors has 
 *                Speciality set { "DERMATOLGY" , "CARDIOLOGY","PSYCHOLOGY"
 *              Doctor Which we are comparing have : 
 *              Speciality Set( "DERMATOLGY" , "CARDIOLOGY","ONCOLOGY", "DENTISTRY") 
 *              so now we have 2 speciality in common
 *              so we calculate the score as noOfCommonSpeciality/totalSpeciality for both
 *              so here it would be (2/3)*(2/4) as (2 out of 3)  and (2 out of 4)   speciality are in common
 *              so it would be below 1 so we have multiplied it by 100 ;
 *              
 *          2) Distance :
 *                 on scale of 100 ;
 *                 it will add to score on 100/(dist+1) as distance increases score should reduce
 *           
 *          3) Years of Experience :
 *                More the number of the experience higher will be the score
 *                
 *          4) Review Score:
 *                Doctors review Score is also added to the Similarity Score 
 *          
 *          5) No of Reviews:
 *                Doctors with more no of reviews will have higher score 
 *            
 *  
 */

public class SimilarDoctors {

    private Doctor doctor; 
    private String name;
    private Set<String> specialitySet;
    private int specialitySetSize;
    int distance  ;
   
    
	
	public List<Doctor> ListOfSimilarDoctors(){
		List<Doctor> similarDoc = new ArrayList<>();
		Map<Double,Doctor> nearDoctorList = new NearByDoctors(doctor.getName()).getNearByDoctor(distance);
		Map<Double, Doctor> scoreSorted = new TreeMap<>(Collections.reverseOrder());
		double score;
		for(Map.Entry<Double,Doctor>  entry: nearDoctorList.entrySet()){
			score = 0;
			double dist = entry.getKey();
			Doctor doc = entry.getValue();
			if(doc == doctor ) continue;
			score = score + calculateCosineSimilarity(doc);  // specialityMatching Score
			score = score + 100/(dist+1);                   // distance score
			score = score + (doc.getYearsOfEx()-doctor.getYearsOfEx())*2; // experience score
			score = score + doc.getReviewScore();             // rating Score
			score = score + doc.getReview().size();           // No Of review Score
			scoreSorted.put(score, doc);
		}
	    for(Doctor doctor: scoreSorted.values() ){
	    	similarDoc.add(doctor);
	    }
	    return similarDoc;
	}
    /**
     * 
     * @param doc
     * This Function returns the Similarity in Speciality and returns the score 
     * @return
     */
	double calculateCosineSimilarity(Doctor doc){
		List<Doctor.Speciality> speciality = doc.getSpeciality();
		double count = 0;		
		for(Doctor.Speciality specs: speciality){
			if(specialitySet.contains(specs.toString())) count++;
		}
		double commonSpecFraction1 = count/(double)speciality.size();
		double commonSpecFraction2 =  count/(double)specialitySetSize;
		return commonSpecFraction1*commonSpecFraction2*100;
		
	}
	
	/**
     * 
     * @param name
     * @param distance
     * 
     *   Name and distance is passed for the doctor similar to which we need to find doctors
     *   Have stored the speciality in Set so that we do not need to find again and again
     *   while comparing with Other Doctors
     */
	public SimilarDoctors(String name, int distance) {
		this.name = name;
		doctor = AddRetrieveDoctor.getADoctor(name);
		this.doctor = doctor;
		this.distance = distance;
		specialitySet = new HashSet<>();
		for(Doctor.Speciality speciality: doctor.getSpeciality()){
			specialitySet.add(speciality.toString());
		}
		this.specialitySetSize = specialitySet.size();
	}


	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
}
 