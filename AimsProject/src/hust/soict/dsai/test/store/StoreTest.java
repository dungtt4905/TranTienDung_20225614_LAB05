package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.exception.DupplicatedItemException;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) throws Exception {
        Store store = new Store();
        //Create a new cart

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation","Roger Allers",87,19.95f);
        store.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        store.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        store.addMedia(dvd3);
        //Print list DVD in Store
        store.print();
        //Remove DVD
        store.removeMedia(dvd1);
        store.removeMedia(dvd1);
        //Print list DVD in Store
        store.print();
    }
}
