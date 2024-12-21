package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import hust.soict.dsai.aims.exception.CartFullException;
import hust.soict.dsai.aims.exception.NonExistingItemException;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
//    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public void addMedia(Media media) throws CartFullException {
        if (this.itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
            throw new CartFullException("The cart is full.");
        } else {
            this.itemsOrdered.add(media);
            System.out.println(media.getTitle() + " has beed added to the cart.");
        }
    }

    public void removeMedia(Media media) throws NonExistingItemException {
        if (this.itemsOrdered.remove(media)) {
            System.out.println(media.getTitle() + " has been removed from the cart.");
        } else {
            throw new NonExistingItemException(media.getTitle() + " is not in the cart.");
        }
    }
    


    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return Math.round(total * 100.0f) / 100.0f;
    }
    

    
    //6 in ra danh sách đĩa trong giỏ
    public void print(){
        System.out.println("**********************CART**********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            Media media = itemsOrdered.get(i);
            if (media != null) {
                System.out.println((i + 1) + ". " + media.getTitle() + " - " + media.getCost());
            } else {
                System.out.println((i + 1) + ". Null item");
            }
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("*************************************************");
    }
    
   
    
    public void searchCart(String title) {
        boolean matchFound = false;
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                System.out.println("Found " + media);
                matchFound = true;
            }
        }
        if (!matchFound) {
            System.out.println("Media with title \"" + title + "\" were not found.");
        }
    }
    
    public void searchCart(int id) {
        boolean matchFound = false;
        for (Media media : itemsOrdered) {
            if (media.isMatch(id)) {
                System.out.println("Found " + media);
                matchFound = true;
            }
        }
        if (!matchFound) {
            System.out.println("Media with id " + id + " were not found.");
        }
    }
    
    public Media search(int id) {
        for (Media item : itemsOrdered){
            if (item.getId() == id){
                return item;
            }
        }
        return null;
    }

    public Media search(String title) {
        for (Media item : itemsOrdered){
            if (item.isMatch(title)){
                return item;
            }
        }
        return null;
    }
    
    public ArrayList<Media> filterById(int id) {
        ArrayList<Media> media = new ArrayList<Media>();
        for (Media item : itemsOrdered){
            if (item.getId() == id){
                media.add(item);
            }
        }
        return media;
    }

    public ArrayList<Media> filterByTitle(String title) {
        ArrayList<Media> media = new ArrayList<Media>();
        for (Media item : itemsOrdered){
            if (item.isMatch(title)){
                media.add(item);
            }
        }
        return media;
    }
    
    public void sortMediaByTitle() {
        Collections.sort((List<Media>)itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        Iterator<Media> iterator = itemsOrdered.iterator();
        iterator = itemsOrdered.iterator();
    
        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
    }
    public void sortMediaByCost() {
        Collections.sort((List<Media>)itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        Iterator<Media> iterator = itemsOrdered.iterator();
        iterator = itemsOrdered.iterator();
    
        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
    }
    public void playMedia(Media media) throws PlayerException {
        if (media instanceof DigitalVideoDisc) {
            DigitalVideoDisc dvd = (DigitalVideoDisc) media;
            dvd.play();
        }
        if (media instanceof CompactDisc) {
            CompactDisc cd = (CompactDisc) media;
            cd.play();
        }
    }

	public ObservableList<Media> getItemsOrdered() {
		// TODO Auto-generated method 
		return itemsOrdered;
	}
	
    public int getSize() {
        return this.itemsOrdered.size();
    }

    public void empty() {
        this.itemsOrdered.clear();
    }
}