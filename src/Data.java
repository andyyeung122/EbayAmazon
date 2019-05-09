import java.sql.*;

public class Data{

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    private static ResultSet queryOutput;

    static{
        getConnection();
        createUserTable();
        createOrdinairyUserTable();
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

    private static void executeUpdate(String updateQuery){
        try{
            statement.executeUpdate(updateQuery);
        }catch(Exception expt){
            expt.printStackTrace();
        }
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

            executeUpdate(createDatabase);

            connection = DriverManager.getConnection(databaseHost,user,password);
            statement = connection.createStatement();

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    //initializing database tables

    private static void createUserTable(){
        String createUserTable = "CREATE TABLE IF NOT EXISTS User("
        + "username VARCHAR(128) PRIMARY KEY,"
        + "password VARCHAR(128),"
        + "name VARCHAR(128),"
        + "superUser BOOLEAN);";
        
        executeUpdate(createUserTable);
    }

    private static void createOrdinairyUserTable(){
        String createOrdinairyUserTable = "CREATE TABLE IF NOT EXISTS OrdinairyUser("
        + "username VARCHAR(128) PRIMARY KEY,"
        + "address VARCHAR(128),"
        + "creditCard VARCHAR(128),"
        + "phoneNumber VARCHAR(128),"
        + "desiredKeyWords VARCHAR(128),"
        + "vip BOOLEAN,"
        + "tempBlocked BOOLEAN,"
        + "permBlocked BOOLEAN,"
        + "FOREIGN KEY(username) REFERENCES User(username) ON UPDATE CASCADE ON DELETE CASCADE);";

        executeUpdate(createOrdinairyUserTable);
    }

    private static void createItemTable(){
        String createItemTable = "CREATE TABLE IF NOT EXISTS Item("
        + "id INT AUTO_INCREMENT PRIMARY KEY,"
        + "name VARCHAR(128),"
        + "seller VARCHAR(128),"
        + "registered BOOLEAN,"
        + "imageLocation VARCHAR(128),"
        + "associatedKeywords VARCHAR(128),"
        + "FOREIGN KEY(seller) REFERENCES OrdinairyUser(username) ON UPDATE CASCADE ON DELETE CASCADE);";
        
        executeUpdate(createItemTable);
    }

    private static void createFixedItemTable(){
        String createFixedItemTable = "CREATE TABLE IF NOT EXISTS FixedItem("
        + "itemID INT PRIMARY KEY,"
        + "price INT,"
        + "FOREIGN KEY(itemID) REFERENCES Item(id));";

        executeUpdate(createFixedItemTable);
    }
    
    private static void createBidItemTable(){
        String createBidItemTable = "CREATE TABLE IF NOT EXISTS BidItem("
        + "itemID INT PRIMARY KEY,"
        + "startOfBid LONG,"
        + "FOREIGN KEY(itemID) REFERENCES Item(id));";

        executeUpdate(createBidItemTable);
    }

    private static void createBidTable(){
        String createBidTable = "CREATE TABLE IF NOT EXISTS Bid("
        + "itemID INT,"
        + "bidder VARCHAR(128),"
        + "amount INT,"
        + "PRIMARY KEY(itemID, bidder),"
        + "FOREIGN KEY(itemID) REFERENCES Item(id) ON DELETE CASCADE ON UPDATE CASCADE,"
        + "FOREIGN KEY(bidder) REFERENCES OrdinairyUser(username) ON DELETE CASCADE ON UPDATE CASCADE);";

        executeUpdate(createBidTable);
    }

    private static void createPurchaseTable(){
        String createPurchaseTable = "CREATE TABLE IF NOT EXISTS Purchase("
        + "itemID INT PRIMARY KEY,"
        + "buyer VARCHAR(128),"
        + "price INT,"
        + "FOREIGN KEY(itemID) REFERENCES Item(id) ON UPDATE CASCADE ON DELETE CASCADE,"
        + "FOREIGN KEY(buyer) REFERENCES OrdinairyUser(username) ON UPDATE CASCADE ON DELETE CASCADE);";

        executeUpdate(createPurchaseTable);
    }

    private static void createRatingTable(){
        String createRatingTable = "CREATE TABLE IF NOT EXISTS Rating("
        + "itemID INT,"
        + "reviewer VARCHAR(128),"
        + "rating INT,"
        + "review VARCHAR(128),"
        + "PRIMARY KEY(itemID,reviewer),"
        + "FOREIGN KEY(itemID) REFERENCES Item(id) ON UPDATE CASCADE ON DELETE CASCADE,"
        + "FOREIGN KEY(reviewer) REFERENCES OrdinairyUser(username) ON UPDATE CASCADE ON DELETE CASCADE);";

        executeUpdate(createRatingTable);
    }

    private static void createNotificationTable(){
        String createNotificationTable = "CREATE TABLE IF NOT EXISTS Notification("
        + "id INT AUTO_INCREMENT PRIMARY KEY,"
        + "title VARCHAR(128),"
        + "message VARCHAR(128),"
        + "receiver VARCHAR(128),"
        + "warning BOOLEAN,"
        + "FOREIGN KEY(receiver) REFERENCES OrdinairyUser(username) ON UPDATE CASCADE ON DELETE CASCADE);";

        executeUpdate(createNotificationTable);
    }

    private static void createComplaintTable(){
        String createComplaintTable = "CREATE TABLE IF NOT EXISTS Complaint("
        + "id INT AUTO_INCREMENT PRIMARY KEY,"
        + "title VARCHAR(128),"
        + "message VARCHAR(128),"
        + "sender VARCHAR(128),"
        + "handled BOOLEAN,"
        + "FOREIGN KEY(sender) REFERENCES OrdinairyUser(username) ON UPDATE CASCADE ON DELETE CASCADE);";

        executeUpdate(createComplaintTable);
    }

    private static void createFriendTable(){
        String createFriendTable = "CREATE TABLE IF NOT EXISTS Friend("
        + "user VARCHAR(128),"
        + "friend VARCHAR(128),"
        + "PRIMARY KEY(user,friend),"
        + "FOREIGN KEY(user) REFERENCES OrdinairyUser(username) ON UPDATE CASCADE ON DELETE CASCADE,"
        + "FOREIGN KEY(friend) REFERENCES OrdinairyUser(username) ON UPDATE CASCADE ON DELETE CASCADE);";

        executeUpdate(createFriendTable);
    }

    private static void createFriendRequestTable(){
        String createFriendRequestTable = "CREATE TABLE IF NOT EXISTS FriendRequest("
        + "sender VARCHAR(128),"
        + "receiver VARCHAR(128),"
        + "PRIMARY KEY(sender,receiver),"
        + "FOREIGN KEY(sender) REFERENCES OrdinairyUser(username) ON UPDATE CASCADE ON DELETE CASCADE,"
        + "FOREIGN KEY(receiver) REFERENCES OrdinairyUser(username) ON UPDATE CASCADE ON DELETE CASCADE);";

        executeUpdate(createFriendRequestTable);
    }

    //database insertion functions
    //TODO: ADD AUTHENTIFICATION FOR INPUTS/PARAMETERS

    private static void createUser(String username, String password, String name, boolean superUser){
        try{
            preparedStatement = connection.prepareStatement("INSERT IGNORE INTO User VALUES(?, ?, ?, ?);");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,name);
            preparedStatement.setBoolean(4,superUser);
            preparedStatement.executeUpdate();
        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    public static void createSuperUser(String username, String password, String name){
        createUser(username,password,name,true);
    }

    public static void createOrdinairyUser(String username, String password, String name, String address, String creditCard, String phoneNumber){
        try{
            createUser(username,password,name,false);
            preparedStatement = connection.prepareStatement("INSERT IGNORE INTO OrdinairyUser VALUES(?,?,?,?,?,?,?,?);");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,address);
            preparedStatement.setString(3,creditCard);
            preparedStatement.setString(4,phoneNumber);
            preparedStatement.setBoolean(5,false);
            preparedStatement.setBoolean(6,false);
            preparedStatement.setBoolean(7,false);
            preparedStatement.setString(8,"");
            preparedStatement.executeUpdate();

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    private static void createItem(String itemName, String sellerUsername, String imageLocation, String associatedKeywords){
        try{
            preparedStatement = connection.prepareStatement("INSERT IGNORE INTO Item(name,seller,registered,imageLocation,associatedKeywords) VALUES(?,?,?,?,?);");
            preparedStatement.setString(1,itemName);
            preparedStatement.setString(2,sellerUsername);
            preparedStatement.setBoolean(3,false);
            preparedStatement.setString(4,imageLocation);
            preparedStatement.setString(5,associatedKeywords);
            preparedStatement.executeUpdate();

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    public static void createFixedItem(String itemName, String sellerUsername, String imageLocation, String associatedKeywords, int fixedPrice){
        try{
            createItem(itemName,sellerUsername,imageLocation, associatedKeywords);
            preparedStatement = connection.prepareStatement("INSERT IGNORE INTO FixedItem VALUES(?,?);");
            preparedStatement.setInt(1,getLastItemIndex());
            preparedStatement.setInt(2,fixedPrice);
            preparedStatement.executeUpdate();

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    public static void createBidItem(String itemName, String sellerUsername, String imageLocation, String associatedKeywords, long startOfBid){
        try{
            createItem(itemName,sellerUsername,imageLocation,associatedKeywords);
            preparedStatement = connection.prepareStatement("INSERT IGNORE INTO BidItem VALUES(?,?);");
            preparedStatement.setInt(1,getLastItemIndex());
            preparedStatement.setLong(2,startOfBid);
            preparedStatement.executeUpdate();
        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    //TODO: Erase previous bid of associated user-item when adding a new bid
    public static void createBid(int itemID, String bidder, int amount){
        try{
            preparedStatement = connection.prepareStatement("INSERT IGNORE INTO Bid VALUES(?,?,?);");
            preparedStatement.setInt(1,itemID);
            preparedStatement.setString(2,bidder);
            preparedStatement.setInt(3,amount);
            preparedStatement.executeUpdate();
        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    public static void createPurchase(int itemID, String buyer, int price){
        try{
            preparedStatement = connection.prepareStatement("INSERT IGNORE INTO Purchase VALUES(?,?,?);");
            preparedStatement.setInt(1,itemID);
            preparedStatement.setString(2,buyer);
            preparedStatement.setInt(3,price);
            preparedStatement.executeUpdate();

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    public static void createRating(int itemID, String reviewer, int rating, String review){
        try{
            preparedStatement = connection.prepareStatement("INSERT IGNORE INTO Rating VALUES(?,?,?,?);");
            preparedStatement.setInt(1,itemID);
            preparedStatement.setString(2,reviewer);
            preparedStatement.setInt(3,rating);
            preparedStatement.setString(4,review);
            preparedStatement.executeUpdate();

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    public static void createNotification(String title, String message, String receiver, boolean warning){
        try{
            preparedStatement = connection.prepareStatement("INSERT IGNORE INTO Notification(title,message,receiver,warning) VALUES(?,?,?,?);");
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,message);
            preparedStatement.setString(3,receiver);
            preparedStatement.setBoolean(4,warning);
            preparedStatement.executeUpdate();

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    public static void createComplaint(String title, String message, String sender){
        try{
            preparedStatement = connection.prepareStatement("INSERT IGNORE INTO Complaint(title,message,sender,handled) VALUES(?,?,?,?);");
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,message);
            preparedStatement.setString(3,sender);
            preparedStatement.setBoolean(4,false);
            preparedStatement.executeUpdate();

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    //TODO: User should not be able to add themselves as a friend
    public static void createFriend(String user, String friend){
        try{
            preparedStatement = connection.prepareStatement("INSERT IGNORE INTO Friend VALUES(?,?);");
            preparedStatement.setString(1,user);
            preparedStatement.setString(2,friend);
            preparedStatement.executeUpdate();

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    public static void createFriendRequest(String sender, String receiver){
        try{
            preparedStatement = connection.prepareStatement("INSERT IGNORE INTO FriendRequest VALUES(?,?);");
            preparedStatement.setString(1,sender);
            preparedStatement.setString(2,receiver);
            preparedStatement.executeUpdate();

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    private static int getLastItemIndex(){
        int id = 0;
        try{
            queryOutput = statement.executeQuery("SELECT id FROM Item ORDER BY id DESC LIMIT 1");

            if(queryOutput.next())
                id = queryOutput.getInt("id");

        }catch(Exception expt){
            expt.printStackTrace();
        }
        return id;
    }

    public static void closeResources(){
        try{
            if(connection != null)
                connection.close();
            if(statement != null)
                statement.close();
            if(preparedStatement != null)
                preparedStatement.close();
            if(queryOutput != null)
                queryOutput.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }
}

/*
schemas

User(username:str primKey, password:str, name:str, superUser:boolean)
OrdinaryUser(username:str primKey/frgn key, address:str, creidCard:str, phoneNumber:str, vip:bool, tempBlocked:bool,permBlocked:bool,desiredKeyWords:Str)

Item(id:int primKey, name:str, registered:bool, imageURL/file:str, associatedKeywords:str)
FixedItem(id:int primKey/frgn key, fixedPrice: int) //price is input as string, then converted to float
BidItem(id:int primKey/frgn key, startOfBid:long)//default bid duration: 3 min; startOfBid -> timestamp in milliseconds
Bid(itemID:int frgn key, bidder:str primKey frgn key, amount:float)

Purchase(itemID: int primKey/frgn key, buyer:str frgn key, price: int)
Rating(itemID: int frgn key, reviewer:str frgn key, rating:int, review:str) primKey(itemID,reviewer)
Notification(id:int primKey, title:str, message:str, receiver:str frgn key, warning:bool) //when retrieving notifications, order them descendingly (so that the lastest notificcation comes first
Complaint(id:int primKey, title:str, message:str, sender:str frgn key, handled:bool)

Friend(user:str frgn key, friend:str frgn key)primKey(user,friend)
FriendRequest(sender:str frgn key, receiver frgn key) primKey(sender, receiver)
*/

//removed code
/*
    private static void createSuperUserTable(){
        try{
            String createSuperUserTable = "CREATE TABLE IF NOT EXISTS SuperUser("
            + "username VARCHAR(128) PRIMARY KEY,"
            + "FOREIGN KEY(username) REFERENCES User(username) ON UPDATE CASCADE ON DELETE CASCADE);";
            
            statement.executeUpdate(createSuperUserTable);

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }
*/