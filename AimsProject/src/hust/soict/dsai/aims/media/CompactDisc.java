package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.DupplicatedItemException;
import hust.soict.dsai.aims.exception.NonExistingItemException;
import hust.soict.dsai.aims.exception.PlayerException;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
	
	private String artist;
	private List<Track> tracks = new ArrayList<>();
	
	public String getArtist() {
		return artist;
	}
	
    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }
	
    public CompactDisc(String title, String category, float cost, String artist) {
        super(title, category, cost);
        this.artist = artist;
    }
    
    public CompactDisc(String title, String category, float cost, String artist, String director) {
        super(title, category, director, cost);
        this.artist = artist;
    }
    
    public CompactDisc(String title, String category, float cost, int length, String director, String artist, ArrayList<Track> tracks) {
        super(title, category, cost);
       
        this.artist = artist;
        this.tracks = tracks;
    }

	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}

    public void addTrack(Track track) throws DupplicatedItemException {
        if (this.tracks.contains(track)) {
            throw new DupplicatedItemException("The track " + track.getTitle() + " is already in the tracklist of " + this.getTitle());
        } else {
            this.tracks.add(track);
            System.out.println("The track " + track.getTitle() + " has been added to the tracklist of " + this.getTitle());
        }



    }

    public void removeTrack(Track track) throws NonExistingItemException {
        if (this.tracks.remove(track)) {
            System.out.println("The track " + track.getTitle() + " has been removed from the tracklist of " + this.getTitle());
        } else {
            throw new NonExistingItemException("The track " + track.getTitle() + " is not in the tracklist of " + this.getTitle());
        }

        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track \"" + track.getTitle() + "\" has been deleted.");
        } else {
            System.out.println("Track \"" + track.getTitle() + "\" does not exist in the list.");
        }
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

	@Override
	public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: CD length is non-positive!");
        } else {
            System.out.println("Playing CD: " + this.getTitle());
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            JPanel p = new JPanel();
            JDialog d = new JDialog();
            JLabel l1 = new JLabel("Now playing: " + this.getTitle());
            p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
            l1.setAlignmentX(Component.CENTER_ALIGNMENT);
            d.setTitle("Media Player");
            p.add(Box.createVerticalGlue());
            p.add(l1);
            p.add(Box.createVerticalGlue());
            d.add(p);
            d.setSize(250,100);
            int w = d.getSize().width;
            int h = d.getSize().height;
            int x = (dim.width - w) / 2;
            int y = (dim.height - h) / 2;
            d.setLocation(x, y);
            d.setVisible(true);
            for (Track track: this.tracks) {
                try {
                    track.play();
                } catch (PlayerException e) {
                    throw e;
                }
            }
        }



	}
	
    public String toString() {
        return "ID: " + this.getId() + " - CD: " + this.getTitle() + " - Category: " + this.getCategory() +
                " - Artist" + this.getArtist() + " - Length: " + this.getLength() + " seconds" + 
                " - Cost: " + this.getCost() + "$";
    }
    
    public String getDetails() {
        StringBuffer tracklist = new StringBuffer();
        if (this.tracks.size() >= 1) {
            tracklist.append(this.tracks.get(0).getTitle());
            for (int i = 1; i < this.tracks.size(); i++) {
                tracklist.append(", " + this.tracks.get(i).getTitle());
            }
        }
        return ("Product ID: " + String.valueOf(this.getId())
                + "\n" + "\t" + "Title: " + this.getTitle()
                + "\n" + "\t" + "Category: " + this.getCategory()
                + "\n" + "\t" + "Artist: " + this.getArtist()
                + "\n" + "\t" + "Director: " + this.getDirector()
                + "\n" + "\t" + "Tracklist: " + tracklist
                + "\n" + "\t" + "Length: " + String.valueOf(this.getLength()) + " minutes"
                + "\n" + "\t" + "Price: $" + String.valueOf(this.getCost()));
    }

	@Override
	public String getType() {
		return "CD";
	}
}
