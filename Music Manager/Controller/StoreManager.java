package Controller;

public interface StoreManager {
	
	    void addItem(MusicItem item);
	    boolean deleteItem(MusicItem item);
	    void print();
	    void sort();
	    void buy(MusicItem item);
	    
}
