package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.List;
public class TestMedia {
    public static void main(String[] args) throws Exception  {
        List<Media> mediae = new ArrayList<Media>();

        CompactDisc cd = new CompactDisc("CD01","Fantasy",13f, "Lucas","John");
        DigitalVideoDisc dvd = new DigitalVideoDisc("DVD Title 1","Action","Director 1",120,15.99f);
        Book book = new Book("Book Title 1","Fiction",29.99f,List.of("Robert C. Martin"));

        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        for(Media media : mediae){
            System.out.println(media.toString());
        }
    }
}
