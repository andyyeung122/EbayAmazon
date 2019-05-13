
public class Message{

    private int id;
    private String title;
    private String message;

    public Message(int id){
        this(id,"","");
    }

    public Message(int id, String title,String message){
        this.id = id;
        this.title = title;
        this.message = message;
    }

    public int getID(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getMessage(){
        return message;
    }

}