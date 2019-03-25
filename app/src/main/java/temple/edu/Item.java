package temple.edu;
import java.io.Serializable;
import java.util.ArrayList;
public class Item implements Serializable{
    private static final long serialVersionId = 1234;

    private String bookTitle;   //book title and its body
    private String body;

    //constructor for the class
    public Item(String bookTitle, String body){
        this.bookTitle = bookTitle;
        this.body = body;
    }

    public String getTitle(){  //get the title
        return bookTitle;
    }
    public String getBody(){
        return body;
    }
    public static  ArrayList<Item>  getItems(){  //get the books or item
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Meet", "This is Meet books"));
        items.add(new Item("Becomming", "This is Becoming books"));
        items.add(new Item("Educated", "This is Educated books"));
        items.add(new Item("The Complete", "This is The Complete books"));
        items.add(new Item("Calculus", "This is Calculus books"));
        items.add(new Item("Chemistry", "This is Chemistry books"));
    return items;
    }
    @Override
    public String toString(){
        return getTitle();
    }
}
