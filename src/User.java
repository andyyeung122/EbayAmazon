
public class User{

    private String username;
    private String name;
    private String address;
    private String creditCard;
    private String phoneNumber;
    private String desiredKeyWords;
    private String blockMessage;

    public User(String username){
        this(username,"","","","","","");
    }

    public User(String username, String name, String address, String creditCard, String phoneNumber, String desiredKeyWords, String blockMessage){
        this.username = username;
        this.name = name;
        this.address = address;
        this.creditCard = creditCard;
        this.phoneNumber = phoneNumber;
        this.desiredKeyWords = desiredKeyWords;
        this.blockMessage = blockMessage;
    }

    public String getUsername(){
        return username;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public String getCreditCard(){
        return creditCard;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getKeyWords(){
        return desiredKeyWords;
    }

    public String getBlockMessage(){
        return blockMessage;
    }
}