package hust.soict.dsai.aims.screen;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {
    private Store store;
    private Cart cart;

    public CartScreen(Store store, Cart cart) {
        super();
        this.store = store;
        this.cart = cart;
        this.setSize(1024,768); 
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);          
        this.setTitle("Cart");      
        this.setVisible(true);   
        JFrame frame = this;
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new StoreScreen(store, cart); 
            }
        });
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource("cart.fxml"));       
                    CartScreenController controller = new CartScreenController(store, cart, frame);
                    loader.setController(controller);   
                    Parent root = loader.load();        
                    fxPanel.setScene(new Scene(root)); 
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}