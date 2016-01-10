package ie.gmit.sw;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class Checker implements Runnable {
	
	double score  = 0;
	double highScore=-1000;
	Resultable resu ;
	String s;
	BlockingQueue<Resultable> queue = new ArrayBlockingQueue<>(1000);
 	//constructor
	public Checker (BlockingQueue<Resultable>queue,String s){
		this.queue = queue;
		this.s=s;
		
	}
	
	//Result r = new Result(null, score, highScore);
	
	@Override
	public void run() {
		int k=0;
		while(k<s.length()/2){
		try {
			Resultable res = queue.take();
			score = res.getScore();
			if(score > highScore){
				highScore = score;
				resu = res;
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		k++;
		
		}
	}
	
	public Resultable getResu(){
		
		return resu;
		
	}
	
	
	
	
	
	

}
