import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Dataset {

	ArrayList<ArrayList<Double>> data;

	ArrayList<String> labels;
	
	
	
	//Create 2-Dimensional Dataset object
	public Dataset(ArrayList<Double> dataX, ArrayList<Double> dataY, ArrayList<String> labels){
		data = new ArrayList<ArrayList<Double>>();
		
		for(int i = 0; i< dataX.size(); i++){
			data.add(new ArrayList<Double>(Arrays.asList(dataX.get(i), dataY.get(i))));
		}
		
		this.labels = labels;
	}
	
	
	//Create 3-D Dataset object from csv file
	public Dataset(String filename){
		
		
		data = new ArrayList<ArrayList<Double>>();
		labels = new ArrayList<String>();
		
		
		 String csvFile = filename;
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";

	        try {

	            br = new BufferedReader(new FileReader(csvFile));
	            while ((line = br.readLine()) != null) {

	            	
	                // use comma as separator
	                String[] lineValues = line.split(cvsSplitBy);

	                ArrayList<Double> thisItem = new ArrayList<Double>();
	                
	                for(int i = 0; i<(lineValues.length-1); i++){
	                	thisItem.add(Double.parseDouble(lineValues[i])); 
	                }
	                
	                if(thisItem.size()>0){
	                	data.add(thisItem);
	                }
	                	
	                	
	                labels.add(lineValues[lineValues.length-1]);

	                
	            }
	            
	            System.out.println("Loaded " + data.size() + " data points of " + data.get(0).size() + "-dimensional data.");

	        } 
	        
	        catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } 
	        
	        catch (IOException e) {
	            e.printStackTrace();
	        } 
	        
	        finally {
	            if (br != null) {
	                try {
	                    br.close();
	                }
	                
	                catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	}

	
	
	public String findNearestNeighbour(ArrayList<Double> dataPoint){
		
		double minDist;
		int minIndex = 0;
		double tmpDist;
		
		
		double tempTotal = 0;
		
		for(int m = 0; m < data.get(0).size(); m++){
			tempTotal += ( data.get(0).get(m) - dataPoint.get(m) ) * ( data.get(0).get(m) - dataPoint.get(m) );
		}
		
		minDist = Math.sqrt( tempTotal );
		
		
		for(int i = 1; i < labels.size(); i++){
			
			tempTotal = 0;
			
			for(int m = 0; m < data.get(0).size(); m++){
				tempTotal += ( data.get(i).get(m) - dataPoint.get(m) ) * ( data.get(i).get(m) - dataPoint.get(m) );
			}
			
			
			tmpDist =  Math.sqrt( tempTotal );
			
			if(tmpDist < minDist){
				minDist = tmpDist;
				minIndex = i;
			}
			
			
		}
		
		
		return labels.get(minIndex);
	}
	
	

	public String kNearestNeighbours(ArrayList<Double> dataPoint, int k){
		
		ArrayList<Double> minDist = new ArrayList<Double>();
		ArrayList<Integer> minIndex = new ArrayList<Integer>();
		double tmpDist;
		
		
		
		double tempTotal = 0;
		
		for(int m = 0; m < data.get(0).size(); m++){
			tempTotal += ( data.get(0).get(m) - dataPoint.get(m) ) * ( data.get(0).get(m) - dataPoint.get(m) );
		}
		
		tmpDist = Math.sqrt( tempTotal );
		
		
		for(int i = 0; i<k; i++){
			minIndex.add(0);
			minDist.add(tmpDist);
			
		}
		
		
		
		for(int i = 1; i < data.size(); i++){
			
			tempTotal = 0;
			
			for(int m = 0; m < data.get(i).size(); m++){
				

				
				tempTotal += ( data.get(i).get(m) - dataPoint.get(m) ) * ( data.get(i).get(m) - dataPoint.get(m) );
			}

			
			
			tmpDist =  Math.sqrt( tempTotal );
			
			
			for(int j = 0; j<k; j++){
			
				if(tmpDist < minDist.get(j)){
					
					for(int m = j; m > 0; m--){
						minDist.set(m-1, minDist.get(m));
						minIndex.set(m-1, m);
					}
					
					minDist.set(j, tmpDist);
					minIndex.set(j, i);
					
					break;
				}
			
			
			}
				
		}
		
		ArrayList<String> nearestLabels = new ArrayList<String>();
		
		for(int i = 0; i<k; i++){
			nearestLabels.add(labels.get(minIndex.get(i)));
		}
		
		
        Set<String> s = new HashSet<String>(nearestLabels);
        
        String result = null;
        int maxFound = -1;
        
        for (String key : s) {
            int count = Collections.frequency(nearestLabels, key);
            if(count > maxFound){
            	result = key;
            	maxFound = count;
            }
            
        }
		
		
		return result;
	}
	
	
}
