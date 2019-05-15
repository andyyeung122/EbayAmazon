
public class Complaint extends Message{

    private String sender;
    private boolean handled;

    public Complaint(int id){
        this(id,"","","",false);
    }

    public Complaint(int id, String title, String message, String sender, boolean handled){
        super(id,title,message);

        this.sender = sender;
        this.handled = handled;
    }

    public String getSender(){
        return sender;
    }

    public boolean isHandled(){
        return handled;
    }
}