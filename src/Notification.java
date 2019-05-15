
public class Notification extends Message{

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

    @Override
    public String toString(){
        return getTitle();
    }
}