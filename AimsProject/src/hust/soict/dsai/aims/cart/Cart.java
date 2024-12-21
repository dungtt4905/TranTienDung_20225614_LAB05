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
    
//    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
//        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
//            itemsOrdered[qtyOrdered++] = disc;
//            System.out.println("The disc \"" + disc.getTitle() + "\" has been added to the cart.");
//        } else {
//            System.out.println("The cart is full.");
//        }
//    }

//    public void RemoveDigitalVideoDisc(DigitalVideoDisc disc) {
//        if (qtyOrdered == 0) {
//            System.out.println("The cart is empty.");
//            return;
//        }
//        for (int i = 0; i < qtyOrdered && itemsOrdered[i] != null; i++) {
//            if (itemsOrdered[i].equals(disc)) {
//                for (int j = i; j < qtyOrdered - 1; j++) {
//                    itemsOrdered[j] = itemsOrdered[j + 1];
//                }
//                itemsOrdered[qtyOrdered - 1] = null;
//                System.out.println("The disc \"" + disc.getTitle() + "\" has been removed.");
//                qtyOrdered--;
//                return;
//            }
//        }
//        System.out.println("The disc \"" + disc.getTitle() + "\" is not in the cart. Unable to remove.");
//    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return Math.round(total * 100.0f) / 100.0f;
    }
    
//    //2.1
//     public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
//         if (qtyOrdered + dvdList.length <= MAX_NUMBERS_ORDERED) {
//             for (int i = 0 ; i < dvdList.length ; i++) {
//                 itemsOrdered[qtyOrdered] = dvdList[i];
//                 qtyOrdered++;
//                 System.out.println("The disc \"" + dvdList[i].getTitle() + "\" has been added to the cart.");
//             }
//         }
//         else {
//             System.out.println("Please reduce the number of discs.");
//         }
//     }

//    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
//        if (qtyOrdered + dvdList.length <= MAX_NUMBERS_ORDERED) {
//            for (DigitalVideoDisc dvd : dvdList) {
//                itemsOrdered[qtyOrdered] = dvd;
//                qtyOrdered++;
//                System.out.println("The disc \"" + dvd.getTitle() + "\" has been added to the cart.");
//            }
//        } else {
//            System.out.println("Please reduce the number of discs.");
//        }
//    }
//
//    //2.2
//    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
//        if (qtyOrdered + 2 <= MAX_NUMBERS_ORDERED) {
//            itemsOrdered[qtyOrdered] = dvd1;
//            qtyOrdered++;
//            itemsOrdered[qtyOrdered] = dvd2;
//            qtyOrdered++;
//            System.out.println("\"" + dvd1.getTitle() + "\" and \"" + dvd2.getTitle() + "\" has been added to the cart.");
//        }
//        else {
//            System.out.println("Please reduce the number of discs.");
//        }
//    }
    
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
    
    //Tìm đĩa theo id
//    public void searchCart(int id){
//        int check = 0;
//        for (int i = 0; i < qtyOrdered; i++) {
//            if (itemsOrdered[i].isMatch(id)) {
//                check = 1;
//                System.out.println("Item found: " + itemsOrdered[i].toString());
//                break;
//            }
//        }
//        if (check == 0) {
//            System.out.println("Item not found");
//        }
//    }

    //Tìm đĩa theo title
//    public void searchCart(String title){
//        int check = 0;
//        for (int i = 0; i < qtyOrdered; i++) {
//            if (itemsOrdered[i].isMatch(title)) {
//                check = 1;
//                System.out.println("Item found: " + itemsOrdered[i].toString());
//                break;
//            }
//        }
//        if (check == 0) {
//            System.out.println("Item not found");
//        }
//    }
    
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