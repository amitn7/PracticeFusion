package practicsFusion.SimilarDoc;

/**
 * 
 * @author amitn
 * Locality class API converts latitude and longitude values to location.
 * Since one degree corresponds to 67 mile therefore rounded it to decimal and then multiplied 
 * it with 100 so any latitude or longitude of the form 37.655121 is converted to 3765
 * It is done to store values geographically as well in a Map as an Integer will provide more accurate
 * location than double
 */
public class Locality {
	private int latitude;
    private int longitude;
    
    public Locality( int  latitude, int longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
    
    public Locality( double  latitude, double longitude) {
    	int xLat =   (int)((Math.round(latitude*100.0)/100.0) *100);
		int yLong =  (int)((Math.round(longitude *100.0)/100.0)*100);
		this.latitude = xLat;
		this.longitude = yLong;
	}
  
	

	public Locality() {
		// need some API here which will retrieve latitude and longitude from the 
		//location
		
	}
	public Locality(String city) {
		// need here some API which will retrieve latitude and longitude based on 
		//the city name
		
	}
	public Locality(int  zipCode) {
	
		// need here some API which will retrieve latitude and longitude based on 
		//the zipCode
		
	}

	public int getLatitude() {
		return latitude;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + latitude;
		result = prime * result + longitude;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(this.latitude == ((Locality) obj).latitude && this.longitude == ((Locality) obj).longitude)
		return true;
		return false;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}


	/**
	 * @return the longitude
	 */
	public int getLongitude() {
		return longitude;
	}


	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	
    
    
}
