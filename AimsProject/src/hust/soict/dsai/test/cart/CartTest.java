package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) throws Exception {
        //Create a new cart
        Cart cart = new Cart();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation","Roger Allers",87,19.95f);
        cart.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        cart.addMedia(dvd3);

        //Test the print method
        System.out.println("1,Test print method:");
        cart.print();
        cart.removeMedia(dvd1);
        cart.print();
        //To-do: Test the search methods here
        //Search by ID
        System.out.println("2,Test Search by ID method:");
        cart.searchByID(0);
        cart.searchByID(2);
        //Search by title
        System.out.println("3,Test Search by title method:");
        cart.searchByTitle("Star Wars");
        cart.searchByTitle("Abc");
    }

}
