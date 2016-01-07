package ie.gmit.sw;

import java.util.*;
import java.util.concurrent.BlockingQueue;

public class Decryptor implements Runnable {
	
	private BlockingQueue<Resultable> queue;
	private String cypherText;
	private int key;
	
	//constructor 
	public Decryptor(BlockingQueue<Resultable> queue,String cypherText, int key){
		super();
		this.queue = queue;
		this.key = key;
		this.cypherText = cypherText;
		
	}//Constructor ends here 
	

	//overRide method from Runnable interface 
	public void run() {
		RailFence rail = new RailFence();
		String decryptedMessage = rail.decrypt(cypherText, key);
		
		Resultable rb = null;
		
		try {
			queue.put(rb);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
