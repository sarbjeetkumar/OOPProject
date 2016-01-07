package ie.gmit.sw;


import java.util.*;
import java.util.concurrent.*;
public class Encryptor implements Runnable {

	private BlockingQueue<Resultable> queue;
	private String encruptedMessage;
	private int key;
	
	public Encryptor(BlockingQueue<Resultable> queue, String encruptedMessage,
			int key) {
		super();
		this.queue = queue;
		this.encruptedMessage = encruptedMessage;
		this.key = key;
	}


	@Override
	public void run() {

	}

}//class finish here 
