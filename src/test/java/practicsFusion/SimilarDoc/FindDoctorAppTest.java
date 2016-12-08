package practicsFusion.SimilarDoc;


import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
/**
 * Unit test for simple App.
 */
public class FindDoctorAppTest 
{
	@Test
	public void testFindDoctorApp(){
	     FindDoctorApp findDoctor = new FindDoctorApp("John",50);
	     List<String> actualDocListName = findDoctor.findSimilarDoctor();
	     String [] actualNames = actualDocListName.toArray(new String[actualDocListName.size()]);
	     String [] expected = {"Kevin","Jimmy","Amit","Brian","Mark","Jefferey"};    	
	     Assert.assertArrayEquals(expected, actualNames);
	}
	@Test
	public void testFindDoctorAppbyDistance2(){
	     FindDoctorApp findDoctor = new FindDoctorApp("John",20);
	     List<String> actualDocListName = findDoctor.findSimilarDoctor();
	     String [] actualNames = actualDocListName.toArray(new String[actualDocListName.size()]);
	     String [] expected = {"Kevin","Jimmy"};    	
	     Assert.assertArrayEquals(expected, actualNames);
	}
	@Test
	public void testFindDoctorAppbyDistance3(){
	     FindDoctorApp findDoctor = new FindDoctorApp("Amit",40);
	     List<String> actualDocListName = findDoctor.findSimilarDoctor();
	     String [] actualNames = actualDocListName.toArray(new String[actualDocListName.size()]);
	     String [] expected = {"Kevin","Brian","John","Jimmy","Mark",};    	
	     Assert.assertArrayEquals(expected, actualNames);
	}
}
