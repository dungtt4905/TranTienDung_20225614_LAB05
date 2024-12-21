package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

import javax.swing.*;
import java.awt.*;

public class DigitalVideoDisc extends Disc implements Playable{

    public DigitalVideoDisc( String title) {
        super(title);
    }
    public DigitalVideoDisc(String title, String category, float cost) {
    	super(title, category, cost);
    }
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category,director, cost);
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
    	super(title, category, director, length, cost);
    }
    
    @Override
    public String toString() {
        return "ID: " + this.getId() + " - DVD: " + this.getTitle() + " - Category: " + this.getCategory() +
                " - Director: " + this.getDirector() + " - DVD length: " + this.getLength() +
                " - Cost: " + this.getCost() + "$";
    }

	@Override
	public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        } else {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());

            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            JPanel p = new JPanel();
            JDialog d = new JDialog();
            JLabel l1 = new JLabel("Now playing: " + this.getTitle());
            JLabel l2 = new JLabel("DVD length: " + this.getLength());
            p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
            l1.setAlignmentX(Component.CENTER_ALIGNMENT);
            l2.setAlignmentX(Component.CENTER_ALIGNMENT);
            d.setTitle("Media Player");
            p.add(Box.createVerticalGlue());
            p.add(l1);
            p.add(l2);
            p.add(Box.createVerticalGlue());
            d.add(p);
            d.setSize(250,100);
            int w = d.getSize().width;
            int h = d.getSize().height;
            int x = (dim.width - w) / 2;
            int y = (dim.height - h) / 2;
            d.setLocation(x, y);
            d.setVisible(true);
        }
//
//		// TODO Auto-generated method stub
//        System.out.println("Playing Track: " + this.getTitle());
//        System.out.println("Track length: " + this.getLength());
//
	}
	
    public String getDetails() {
        return ("Product ID: " + String.valueOf(this.getId())
                + "\n" + "\t" + "Title: " + this.getTitle()
                + "\n" + "\t" + "Category: " + this.getCategory()
                + "\n" + "\t" + "Director: " + this.getDirector()
                + "\n" + "\t" + "Length: " + String.valueOf(this.getLength()) + " minutes"
                + "\n" + "\t" + "Price: $" + String.valueOf(this.getCost()));
    }
    
    public String getType() {
        return "DVD";
    }
}
