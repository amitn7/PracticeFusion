package practicsFusion.SimilarDoc;
import java.util.*;
/**
 * @author amitn
 *
 *Doctor class Stores the information about the doctors. 
 * Locality, name, year of experience ,review score, review are some of the fields
 * Doctors can be specialized in more than one speciality. Hence taken Speciality as an ArrayList
 * Locality is stored in Latitude and longitude
 */
 
public class Doctor {
    enum Speciality{
		ANESTHESIOLOGY, CARDIOLOGY, CHIROPRACTIC, DENTISTRY,
		DERMATOLOGY, HOMEOPATHY, ONCOLOGY, PSYCHOLOGY, OTHERS
	}
	private String name;
	private int yearsOfEx;
    private Locality locality;
    private List<Speciality> speciality;
    private float reviewScore;
    private List<String> review;
    
    // Constructor
	public Doctor(String name, int yearsOfEx, Locality locality, List<Speciality> speciality) {
		this.name = name;
		this.yearsOfEx = yearsOfEx;
		this.locality = locality;
		this.speciality = speciality;
		review = new ArrayList<>();
	}
	
	// Below are getters and Setters Method
	public int getYearsOfEx() {
		return yearsOfEx;
	}
	public void setYearsOfEx(int yearsOfEx) {
		this.yearsOfEx = yearsOfEx;
	}
	public Locality getLocality() {
		return locality;
	}
	public void setLocality(Locality locality) {
		this.locality = locality;
	}
	public List<Speciality> getSpeciality() {
		return speciality;
	}
	public void setSpeciality(List<Speciality> speciality) {
		this.speciality = speciality;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(float reviewScore) {
		this.reviewScore = reviewScore;
	}
	public List<String> getReview() {
		return review;
	}
	public void setReview(List<String> review) {
		this.review = review;
	}	
}