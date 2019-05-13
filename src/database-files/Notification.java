
public class Notification extends Message{

    private int id;
    private String title;
    private String message;
    private String receiver;
    private boolean warning;

    public Notification(int id){
        this(id,"","","",false);
    }

    public Notification(int id, String title,String message,String receiver,boolean warning){
        super(id,title,message);
        this.receiver = receiver;
        this.warning = warning;
    }
    
    public String getReceiver(){
        return receiver;
    }

    public boolean isWarning(){
        return warning;
    }
}