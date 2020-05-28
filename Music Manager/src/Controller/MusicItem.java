package Controller;

public abstract class MusicItem {
	protected String ItemId;
	protected String title;
	protected String genre;
	protected String release;
	protected String artist;
	protected String price;
  

	public MusicItem(String itemId, String title, String genre, String release, String artist, String price) {
		super();
		ItemId = itemId;
		this.title = title;
		this.genre = genre;
		this.release = release;
		this.artist = artist;
		this.price = price;
		
	}

	public String getItemId() {
		return ItemId;
	}

	public void setItemId(String itemId) {
		ItemId = itemId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

    
}
