import java.util.ArrayList;
import java.util.Arrays;

public class main {

	
	public static void main(String[] args){
		
		ArrayList<Double> dX = new ArrayList<Double>(Arrays.asList(1.0,2.0,3.0,4.0,4.0,4.0,5.0,7.0,7.0,7.0,8.0,9.0,8.0,10.0,9.0,1.0,3.0,2.0,1.0,2.0,1.0,2.0,1.0));
		//Rooms
		ArrayList<Double> dY = new ArrayList<Double>(Arrays.asList(350.0,300.0,300.0,250.0,500.0,400.0,450.0,850.0,900.0,1200.0,1500.0,1300.0,1240.0,1700.0,1000.0,800.0,900.0,700.0,900.0,1150.0,1000.0,1200.0,1300.0));
		//Area
		ArrayList<String> dLabel = new ArrayList<String>(Arrays.asList("apartment", "apartment", "apartment", "apartment", "apartment", "apartment", "apartment", "house", "house", "house", "house", "house", "house", "house", "house", "flat", "flat", "flat", "flat", "flat", "flat", "flat", "flat"));
		//Building Type
		
		Dataset set1 = new Dataset(dX,dY,dLabel);
		
		
		
		System.out.println("Nearest Neighbour");
		
		System.out.println("-----------------");
		
		System.out.println("Input: 1, 100    Output: " + set1.findNearestNeighbour(new ArrayList<Double>(Arrays.asList(1.0, 850.0))));
		
		System.out.println("Input: 8, 1200    Output: " + set1.findNearestNeighbour(new ArrayList<Double>(Arrays.asList(8.0, 1200.0))));
		
		System.out.println("Input: 3, 200    Output: " + set1.findNearestNeighbour(new ArrayList<Double>(Arrays.asList(3.0, 200.0))));
		
		
		
		System.out.println("===============================");
		
		System.out.println("kNN k = 1");
		
		System.out.println("-----------------");
		
		System.out.println("Input: 1, 100    Output: " + set1.kNearestNeighbours(new ArrayList<Double>(Arrays.asList(1.0, 850.0)), 1) );
		
		System.out.println("Input: 8, 1200    Output: " + set1.kNearestNeighbours(new ArrayList<Double>(Arrays.asList(8.0, 1200.0)), 1) );
		
		System.out.println("Input: 3, 200    Output: " + set1.kNearestNeighbours(new ArrayList<Double>(Arrays.asList(3.0, 200.0)), 1) );
		
		System.out.println("===============================");		
		
		
		System.out.println("kNN k = 3");
		
		System.out.println("-----------------");
		
		System.out.println("Input: 1, 100    Output: " + set1.kNearestNeighbours(new ArrayList<Double>(Arrays.asList(1.0, 850.0)), 3) );
		
		System.out.println("Input: 8, 1200    Output: " + set1.kNearestNeighbours(new ArrayList<Double>(Arrays.asList(8.0, 1200.0)), 3) );
		
		System.out.println("Input: 3, 200    Output: " + set1.kNearestNeighbours(new ArrayList<Double>(Arrays.asList(3.0, 200.0)), 3) );
		
		System.out.println("===============================");		
		

		
		
		Dataset set2;
		
		System.out.println("===============================");
		
		System.out.println("Dataset 2: Iris data load from file");
		
		
		
		set2  = new Dataset("testData/iris.data");
		
		
		
		
		System.out.println("-----------------");
		
		System.out.println("kNN k = 1");
		
		System.out.println("-----------------");
		
		System.out.println("Input: 5.2, 3.8, 1.2, 0.8    Output: " + set2.kNearestNeighbours(new ArrayList<Double>(Arrays.asList(5.2, 3.8, 1.2, 0.8)), 1) );
		
		System.out.println("Input: 3.4, 2.6, 1.5, 0.3    Output: " + set2.kNearestNeighbours(new ArrayList<Double>(Arrays.asList(3.4, 2.6, 1.5, 0.3)), 1) );
		
		System.out.println("Input: 5.5, 2.4, 4.6, 1.3    Output: " + set2.kNearestNeighbours(new ArrayList<Double>(Arrays.asList(5.5, 2.4, 4.6, 1.3)), 1) );
		
		System.out.println("===============================");		
		
		
		System.out.println("kNN k = 3");
		
		System.out.println("-----------------");
		
		System.out.println("Input: 5.2, 3.8, 1.2, 0.8    Output: " + set2.kNearestNeighbours(new ArrayList<Double>(Arrays.asList(5.2, 3.8, 1.2, 0.8)), 3) );
		
		System.out.println("Input: 3.4, 2.6, 1.5, 0.3    Output: " + set2.kNearestNeighbours(new ArrayList<Double>(Arrays.asList(3.4, 2.6, 1.5, 0.3)), 3) );
		
		System.out.println("Input: 5.5, 2.4, 4.6, 1.3    Output: " + set2.kNearestNeighbours(new ArrayList<Double>(Arrays.asList(5.5, 2.4, 4.6, 1.3)), 3) );
		
		System.out.println("===============================");		
		
		System.out.println("BONUS");
		System.out.println("Input: 5.9,3.0,5.1,1.8    Output: " + set2.kNearestNeighbours(new ArrayList<Double>(Arrays.asList(5.9,3.0,5.1,1.8)), 5) );
		
		
	}

}
