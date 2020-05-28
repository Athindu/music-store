package Controller;

import java.math.BigDecimal;
import java.util.Objects;

public class CD extends MusicItem {
    private int totalDuration;              //total duration of the music item



    public void setTotalDuration(int totalDuration) {
		this.totalDuration = totalDuration;
	}


	public int getTotalDuration() {
        return totalDuration;
    }


    public CD(String itemId, String title, String genere, String releaseDate, String artist, String price, int totalDuration) {
        super(itemId, title, genere, releaseDate, artist, price);
        this.totalDuration = totalDuration;
    }


}

