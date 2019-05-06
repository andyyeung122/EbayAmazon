import java.sql.*;

public class Data{

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement prepedStatement;

    static{
        getConnection();
        createUserTable();
        createOrdinairyUserTable();
        createSuperUserTable();
        createItemTable();
        createFixedItemTable();
        createBidItemTable();
        createBidTable();
        createPurchaseTable();
        createRatingTable();
        createNotificationTable();
        createComplaintTable();
        createFriendTable();
        createFriendRequestTable();
    }

    private static void getConnection(){
        try{
            String host = "jdbc:mysql://localhost:3306/";
            String databaseHost = "jdbc:mysql://localhost:3306/EbayAmazon";
            String user = "root";
            String password = "209539352";
            String createDatabase = "CREATE DATABASE IF NOT EXISTS EbayAmazon;";

            connection = DriverManager.getConnection(host,user,password);
            statement = connection.createStatement();

            statement.executeUpdate(createDatabase);

            connection = DriverManager.getConnection(databaseHost,user,password);
            statement = connection.createStatement();
            
        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    private static void createUserTable(){
        try{

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    private static void createOrdinairyUserTable(){
        try{

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    private static void createSuperUserTable(){
        try{

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    private static void createItemTable(){
        try{

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    private static void createFixedItemTable(){
        try{

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }
    
    private static void createBidItemTable(){
        try{

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    private static void createBidTable(){
        try{

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    private static void createPurchaseTable(){
        try{

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    private static void createRatingTable(){
        try{

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    private static void createNotificationTable(){
        try{

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    private static void createComplaintTable(){
        try{

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    private static void createFriendTable(){
        try{

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    private static void createFriendRequestTable(){
        try{

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }


    public static void closeAllResources(){
        try{
            if(connection != null)
                connection.close();
            if(statement != null)
                statement.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }
}

/*
schemas

User(username:str primKey, password:str, name:str)
OrdinaryUser(username:str primKey/frgn key, password frgn key, address:str, creidCard:str, phoneNumber:str, vip:bool, tempBlocked:bool,permBlocked:bool,desiredKeyWords:Str)
Superuser(username:str primKey, password:str, name:str)

Item(id:int primKey, name:str, registered:bool, imageURL/file:str, associatedKeywords:str) 
FixedItem(id:int primKey/frgn key, fixedPrice: float) //price is input as string, then converted to float
BidItem(id:int primKey/frgn key, highestBid: float, startOfBid:long)//update highest bid whenever bid is added; default bid duration: 3 min; startOfBid -> timestamp in milliseconds
Bid(itemID:int frgn key, user:str frgn key, amount:float)

Purchase(itemID: int primKey/frgn key, seller:str frgn key, buyer:str frgn key, price: float)
Rating(itemID: int frgn key, reviewer:str frgn key, seller:str frgn key, rating:float, review:str) primKey(itemID, reviewer)//if rating for (itemID, reviewer) already exists, do not prompt for review/rating
Notification(id:int primKey, title:str, message:str, receiver:str frgn key, timeStamp:long, warning:bool) //timestamp should be in milliseconds
Complaint(id:int primKey, title:str, message:str, sender:str frgn key, handled:bool)

Friend(user:str frgn key, friend:str frgn key)primKey(user,friend)
FriendRequest(sender:str frgn key, receiver frgn key) primKey(sender, receiver)
*/