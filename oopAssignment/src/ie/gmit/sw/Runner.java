package ie.gmit.sw;

import java.nio.MappedByteBuffer;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Runner {
	
	public static void main(String[] args) throws Exception{
		
		Scanner Sarab = new Scanner(System.in);
		
			//RailFence rf = new RailFence();
			FileParser fl = new FileParser();
			
			Map <String , Double> yo = new ConcurrentHashMap<String,Double>();
			//yo = fl.parse("");
			yo= fl.fileReader();
			TextScorer tt= new TextScorer(yo);
			BlockingQueue<Resultable> queue= new ArrayBlockingQueue<>(1000);
			
			System.out.println("Enter the Text encrypt");
			String userInput = Sarab.next() ;
			
			System.out.println("Enter the Key");
			int Key = Sarab.nextInt();
			
			String s = new RailFence().encrypt(userInput, Key);
			System.out.println(" -> " + s);
			
			for(int i = 2; i< s.length();i++){
				Thread t = new Thread(new Decryptor(queue, s, i));
				t.start();
				
			}
			
			Checker c = new Checker(queue,s);
			Thread t = new Thread(c);
			t.start();
			t.join();
			
			Resultable rt = c.getResu();
			System.out.println(rt.getPlainText());
			System.out.println(rt.getScore());
			System.out.println( rt.getPlainText() + " "+ rt.getScore() + " " +rt.getKey());
		
		
			
			//String s = new RailFence().decrypt("TTFOHATGRNREEANOETYRCIMHHAKT", 5);
			//System.out.println(">" + s);
			
			
			//Decryptor d = new Decryptor("sarabjeet", 4);
			//d.run();
			
			
		}
		
}//end of class 
