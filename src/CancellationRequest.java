
public class CancellationRequest{

    private Item item;
    private String reason;

    public CancellationRequest(Item item, String reason){
        this.item = item;
        this.reason = reason;
    }

    public Item getItem(){
        return item;
    }

    public String getReason(){
        return reason;
    }
}