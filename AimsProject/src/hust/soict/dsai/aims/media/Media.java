package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
	
	private static int nbMedia = 0;
	private int id; 
	private String title;
	private String category;
	private float cost;
	
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}

	public Media() {
		// TODO Auto-generated constructor stub
	}
	
    public Media(String title) {
    	this.id = ++nbMedia;
        this.title = title;
    }
	
    public Media(String title, String category, float cost) {
    	this.id = ++nbMedia;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    
    public boolean isMatch(int id){
        return this.getId() == id;
    }

    public boolean isMatch(String title){
        String[] tmp = title.split(" ",0);
        for (String s : tmp) {
            if (this.getTitle().toLowerCase().contains(s.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
    
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Media media = (Media) object;
        return title != null && title.equalsIgnoreCase(media.getTitle());
    }
    
    public String toString() {
        return "Media: " + this.getTitle() +" - Category: " + this.getCategory() + " - Cost: " + this.getCost() + "$";
    }
    
    public abstract String getType();

    public abstract String getDetails();
}
