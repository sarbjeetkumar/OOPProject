package ie.gmit.sw;

import java.util.*;
import java.util.concurrent.*;

public class CypherBreaker {

	private BlockingQueue<Resultable> queue;		//blocking queue
	public static final int MAX_SIZE_Queue = 1000;		//give it a size 
	private String cypherText ;
	
	//constructor 
	
	public CypherBreaker(String cypherText){
		queue= new ArrayBlockingQueue<Resultable>(MAX_SIZE_Queue);
		this.cypherText= cypherText;
		
	}
	
	//for decreptor 
	public void forDecryptor(){
		for (int i=2;i <cypherText.length()/2;i++){				//take the text lenght and divide it by 2 
			new Thread(new Decryptor(queue, cypherText,i)).start();		//******start a thread and decrypt it .
		}//for ends here 
		
		
	}//decryptor finish here 
	

}
