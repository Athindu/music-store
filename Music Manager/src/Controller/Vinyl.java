package Controller;

public class Vinyl extends MusicItem {

    private int diameter;
    private int speed;
    
    
    public void setdiameter(int diameter) {
		this.diameter = diameter;
	}
    
    
    public int getdiameter() {
        return diameter;
    }
    
    public void setspeed(int speed) {
		this.speed = speed;
	}
    
    public int getspeed(){
    	return speed;
    }
   

    public Vinyl(String itemId, String title, String genere, String releaseDate, String artist, String price, int speed, int diameter) {
        super(itemId, title, genere, releaseDate, artist, price);
        this.diameter = diameter;
        this.speed = speed;
    }
	
}
