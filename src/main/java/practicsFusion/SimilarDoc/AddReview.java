package practicsFusion.SimilarDoc;
import java.util.*;
/*
 *   This class would be used to add review and update rating accordingly
 */
public class AddReview {
	public String review;
	public String name;
	
    public AddReview(String name,String review){
    	Doctor doctor = AddRetrieveDoctor.getInstance().getADoctor(name);
    	List<String> reviewList = doctor.getReview();
    	reviewList.add(review);
    	updateRating(doctor,reviewList);
    }
    
    private void updateRating(Doctor doctor, List<String> reviewList){
    	int updatedScore = 4;// it can be any value
    	doctor.setReviewScore(updatedScore);
    	// Have to write some logic to update after every update
    }
}
