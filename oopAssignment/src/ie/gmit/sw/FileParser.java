package ie.gmit.sw;
import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

//create it's own class file Parser

public class FileParser {
		
	Map <String , Double> map = new ConcurrentHashMap<String , Double>();
	Scanner sarab = new Scanner(System.in);
	
	
	public String fileReader(){
		
		System.out.print("Enter a file name  ");
		String filename = sarab.nextLine();
		File file = new File(filename);
		
		String readLine = "";
		try {
		      BufferedReader br = new BufferedReader(new FileReader(file));
		      while ((readLine = br.readLine()) != null) { 
		        System.out.println();
		      
		        
		      } // end while 
		    } // end try
		    catch (IOException e) {
		      System.err.println("Error Happened: " + e);
		    }
		
		
		
		
		return readLine;
		
	}//mapfinish here 
	

}
