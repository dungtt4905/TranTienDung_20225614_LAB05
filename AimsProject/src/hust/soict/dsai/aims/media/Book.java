package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.DupplicatedItemException;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	private int contentLength;
	private List<String> authors = new ArrayList<>();
	
	public List<String> getAuthors() {
		return authors;
	}
    public int getContentLength() {
        return contentLength;
    }
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }
    
    public Book(String title, String category, float cost, List<String> authors) {
        super(title, category, cost);
        this.authors = authors;
    }
    
    public Book(String title, String category, int contentLength, float cost) {
        super(title, category, cost);
        this.contentLength = contentLength;
    }
	
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

    public void addAuthor(String authorName) throws DupplicatedItemException {
        for (String name: this.authors) {
            if (name.toLowerCase().equals(authorName.toLowerCase())) {
                throw new DupplicatedItemException(name + " is already in the list of authors.");
            }
        }
        this.authors.add(authorName);
        System.out.println(authorName + " has been added to the " + this.getTitle() + " list of authors.");

//        if (!authors.contains(authorName)) {
//            authors.add(authorName);
//        } else {
//            System.out.println("Author already exists: " + authorName);
//        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        } else {
            System.out.println("Author not found: " + authorName);
        }
    }
    
    public String getType() {
        return "Book";
    }
    
    @Override
    public String toString() {
        return "ID: " + this.getId() + " - Book: " + this.getTitle() +
                " - Category: " + this.getCategory() +
                " - Cost: " + this.getCost() + "$";
    }
    
    public String getDetails() {
        StringBuffer authorsList = new StringBuffer();
        if (this.authors.size() >= 1) {
            authorsList.append(this.authors.get(0));
            for (int i = 1; i < this.authors.size(); i++) {
                authorsList.append(", " + this.authors.get(i));
            }
        }
        return ("Product ID: " + String.valueOf(this.getId())
                + "\n" + "\t" + "Title: " + this.getTitle()
                + "\n" + "\t" + "Category: " + this.getCategory()
                + "\n" + "\t" + "Authors: " + authorsList
                + "\n" + "\t" + "Content Length: " + String.valueOf(this.getContentLength()) + " pages"
                + "\n" + "\t" + "Price: $" + String.valueOf(this.getCost()));
    }
}
