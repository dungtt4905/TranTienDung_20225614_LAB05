package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.exception.DupplicatedItemException;
import hust.soict.dsai.aims.exception.NonExistingItemException;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public Store(){
    }
    
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void addMedia(Media media) throws DupplicatedItemException {
        if (itemsInStore.contains(media) || media.getTitle() == null) {
            throw new DupplicatedItemException();
        }
        else {
        	itemsInStore.add(media);
            System.out.println(media.getTitle() + " has been added to the store.");
        }
    }

    public void removeMedia(Media media) throws NonExistingItemException {
        if (this.itemsInStore.remove(media)) {
            System.out.println(media.getTitle() + " has been removed from the store.");
        } else {
            throw new NonExistingItemException(media.getTitle() + " is not in the store.");
        }
    }
    
    public Media getMedia(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equals(title)) {
                return m;
            }
        }
        return null;
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
    
    public void printStore(){
        System.out.println("***********************STORE***********************");
        System.out.println("Items in Store:");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println(itemsInStore.get(i).toString());
        }
        System.out.println("***************************************************");
    }
}