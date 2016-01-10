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
	
	//default 
	public Decryptor() {
	
	}

	public Decryptor(String cypherText, int key) {
		super();
		this.cypherText = cypherText;
		this.key = key;
	}

	//overRide method from Runnable interface 
	public void run() {
		
		RailFence r = new RailFence();
		
		String de=r.decrypt(cypherText, key);
		//System.out.println(de.toString());
		double s = TextScorer.getScore(cypherText);
		
		Resultable r1 =  new Result(de, key, s);
		
		try {
			queue.put(r1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
