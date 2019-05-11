
public class Item{

    private int itemID;
    private String itemName;
    private String seller;
    private String imageLocation;
    private String associatedKeyWords;

    public Item(int itemID){
        this(itemID,"","","","");
    }

    public Item(int itemID, String itemName,String seller, String imageLocation, String associatedKeyWords){
        this.itemID = itemID;
        this.itemName = itemName;
        this.seller = seller;
        this.imageLocation = imageLocation;
        this.associatedKeyWords = associatedKeyWords;
    }

    public int getItemID(){
        return itemID;
    }

    public String getItemName(){
        return itemName;
    }

    public String getSeller(){
        return seller;
    }

    public String getImageLocation(){
        return imageLocation;
    }

    public String getKeyWords(){
        return associatedKeyWords;
    }
}