package ie.gmit.sw;

//sarabjeet 
//Interface Resultable  
public interface Resultable {
	
	public abstract String getPlainText();
	
	public abstract void setPlainText(String plainText);
	
	public abstract int getKey();
	
	public abstract void setKey(int key);
	
	public abstract void setScore(double score);
	
	public abstract double getScore();

}
