# Assumptions : 

   1)  ** Names ** of each Doctor is Unique: 
   2)   All the address are stored in Latitude and Longitude
   3)   difference in 1 degree longitude = 69 mile
             Have used location such that first it will round up to decimal Places 
			 and then multiplied by 100
			 So all the Locality stored are integer ;
			 so unit difference of Locality. latitude and Locality.Longitude = 0.7 mile;
	     When I have to calculate the NearBy Doctor within Distance have divided the latitude by distance/0.7
		 and then searched in (lat- dist/0.7) to (lat + dist/0.7)
    4)   Have used distance formula to calculate distance between two points  sqrt((x1-x2)^2 + (y1-y2)^2); 
    5)   Returns the list of doctor names based on similarity Score	
    6 )  Have used Junit for testing	
    7)   A doctor can have more than one speciality
    8)   taking consideration for calculation similarity score only for the doctors who are within the distance
		 
# Major DataStructure Used:
	
	HashMap<name, Doctor> DoctorList  --> stores Doctor List and retrieves in O(1) when required;
        HashMap<Locality, List<Doctor>>  AreaWiseDoctor --> While Adding a Doctor in the DB have created a Map
	                              which stores the Doctor AreaWiseDoctor
				      At each Location there can be many Doctors so have taken List of Doctors
	
	TreeMap<Score, Doctor>   Score = It will store the Doctor sorted in Descending Order of the score.
	                               Have used tree Map to store to avoid sorting Later;
	
	
#Class Description :
	
	FindDoctorApp :  This is the Class with the Main entry;
                     This class Invokes the creation of Other Class Instance and find SImilar Doctors 
	
	AddRetrieveDoctor:    SINGLETON CLASS	
	                 This class is Main Class For retrieving Doctor details and adding doctors in DB.
                      It is kind of middle Tier
                      It has two Maps :
                      DoctorList :  It stores the Doctor object and details and key is the name;
                      AreaWiseDoctor :  It stored the List of Similar Doctors at the same location:
                                   Key is Locality (latitude and Longitude)
                      All the operations for finding Similar doctor would use the above two maps
					  
	
	Similar Doctors  : 	This class is used to find the similar Doctors and return the list of Doctors
                      Input : distance (radius in miles) in which it has to search and a name of Doctor
					  
	NearByDoctors:  Function getNearByDoctor(int Distance)  will take input distance in which it has to find the doctors;
                  
 				    Output : TreeMap of doctors sorted with distance
	
	Doctor   :      Contains information about Doctors:
	
	Locality :       process Latitude and Longitude to be stored as int to process information accurately
	
	
#Algorithm to find Similar Doctors : 
	
	       It will take into consideration only Doctors in the specified Radius and will not consider Doctor with 
       the distance greater than the spedified Distance :
       
       Below Algorithm will be applied after retrieving the list of Doctors within Radius 
       The List would be given by the class NearBYDoctor
       
       Calculate Score : Higher Similarity will have higher score:
                         There is no restriction on higher score
                         
       Used five criteria to calculate score :
         1) Speciality Matching : Out of 100 
             Suppose Doctor For which we have to find Similar Doctors has 
               Speciality set { "DERMATOLGY" , "CARDIOLOGY","PSYCHOLOGY"
             Doctor Which we are comparing have : 
             Speciality Set( "DERMATOLGY" , "CARDIOLOGY","ONCOLOGY", "DENTISTRY") 
             so now we have 2 speciality in common
             so we calculate the score as noOfCommonSpeciality/totalSpeciality for both
             so here it would be (2/3)*(2/4) as (2 out of 3)  and (2 out of 4)   speciality are in common
             so it would be below 1 so we have multiplied it by 100 ;
             
         2) Distance :
                on scale of 100 ;
                it will add to score on 100/(dist+1) as distance increases score should reduce
          
         3) Years of Experience :
               More the number of the experience higher will be the score
               
         4) Review Score:
               Doctors review Score is also added to the Similarity Score 
         
         5) No of Reviews:
               Doctors with more no of reviews will have higher score 


			   
#Improvements which can be made :
      1) can use some Spring Framework which makes tasting easy and less lines of codes  but requires settings and provides many functionality
	  2) Names can be similar(I have assumed in my code that names are unique) and can use some kind of hashing based on Location , speciality as well
	  3) For calculating the similaity between Doctors we can have taken consideration into reviews as well and the contents of review
	     If some doctors are having similar review then chances of similarity would be more. This can be done by comparing the reviews and
		 calculating the similaity between them. 
	  4) Some more fields in Doctor can be added like  a separate class for reviewScore.
	  5) We can give users more choice whether the user wants doctor to be sorted by rating , distance , speciality and we can implement that 
	     as well
	  6) When the users are browsing can use cookies as well so as to remember what was their last search
	  7)  We can connect to some API which will tell whether the doctor is available currently or not and can return the doctor on the basis of availability 
	      as well
	  8)  There can be numerous other factors which should be taken into consideration while returning the result such as fees Charged
	  
