package ie.gmit.sw;
import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

//create it's own class file Parser

public class FileParser {
	
	public Scanner console = new Scanner(System.in);
	
	private int value;
	private String key;
	
	public Map<String , Double> fileReader(){
		
		Map <String , Double> map = new ConcurrentHashMap<String , Double>();
		
		//File file = new File("4grams.txt");
		
		String readLine = "";
		
		try {
		      BufferedReader br = new BufferedReader(new FileReader("4grams.txt"));
		      while ((readLine = br.readLine()) != null) { 
		    	  		
		    	  	
		    	  String []args  = readLine.split(" ");
		    	  		
		    	  		key = args[0];
		    	  		
		    	  		value = Integer.parseInt(args[1]);
		    	  		
		    	  		map.put(readLine, (double) value);		//adding the key and value to the map.
		    
		      } // end while 
		    } // end try
		    catch (IOException e) {
		      System.err.println("Error Happened: " + e);
		    }
		
		
		
		
		return map;
		
	}//mapfinish here 
	

}
