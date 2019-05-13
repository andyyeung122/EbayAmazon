import java.sql.*;
import java.util.*;

public class Data{

    private static Connection connection;

    static{
        getConnection();
        createUserTable();
        createOrdinairyUserTable();
        createUserKeywordTable();
        createItemTable();
        createFixedItemTable();
        createBidItemTable();
        createItemKeywordsTable();
        createBidTable();
        createPurchaseTable();
        createCancellationRequestTable();
        createRatingTable();
        createNotificationTable();
        createComplaintTable();
        createFriendTable();
        createFriendRequestTable();
        createTabooWordTable();
    }

    private static void executeUpdate(String updateQuery){
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(updateQuery);
            statement.close();
        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    private static void getConnection(){
        try{
            String host = "jdbc:mysql://localhost:3306/";
            String databaseHost = "jdbc:mysql://localhost:3306/EbayAmazon";
            String user = "root";
            String password = "Eque7400";
            String createDatabase = "CREATE DATABASE IF NOT EXISTS EbayAmazon;";

            connection = DriverManager.getConnection(host,user,password);
            Statement statement = connection.createStatement();

            executeUpdate(createDatabase);

            connection = DriverManager.getConnection(databaseHost,user,password);
            statement = connection.createStatement();

            statement.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    //INITIALIZING DATABASE TABLES

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
        + "blockMessage VARCHAR(128),"
        + "registered BOOLEAN,"
        + "vip BOOLEAN,"
        + "outstandingUser BOOLEAN,"
        + "tempBlocked BOOLEAN,"
        + "permBlocked BOOLEAN,"
        + "FOREIGN KEY(username) REFERENCES User(username) ON UPDATE CASCADE ON DELETE CASCADE);";

        executeUpdate(createOrdinairyUserTable);
    }

    private static void createUserKeywordTable(){
        String createUserKeywordTable = "CREATE TABLE IF NOT EXISTS UserKeyword("
        + "user VARCHAR(128),"
        + "keyword VARCHAR(128),"
        + "PRIMARY KEY(user,keyword),"
        + "FOREIGN KEY(user) REFERENCES OrdinairyUser(username) ON UPDATE CASCADE ON DELETE CASCADE)";

        executeUpdate(createUserKeywordTable);
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
        + "FOREIGN KEY(itemID) REFERENCES Item(id) ON UPDATE CASCADE ON DELETE CASCADE);";

        executeUpdate(createFixedItemTable);
    }
    
    private static void createBidItemTable(){
        String createBidItemTable = "CREATE TABLE IF NOT EXISTS BidItem("
        + "itemID INT PRIMARY KEY,"
        + "startOfBid LONG,"
        + "FOREIGN KEY(itemID) REFERENCES Item(id) ON UPDATE CASCADE ON DELETE CASCADE);";

        executeUpdate(createBidItemTable);
    }

    private static void createItemKeywordsTable(){
        String createItemKeywordsTable = "CREATE TABLE IF NOT EXISTS ItemKeyword("
        + "itemID INT,"
        + "keyword VARCHAR(128),"
        + "PRIMARY KEY(itemID,keyword),"
        + "FOREIGN KEY(itemID) REFERENCES Item(id) ON UPDATE CASCADE ON DELETE CASCADE)";

        executeUpdate(createItemKeywordsTable);
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
        + "timeStamp LONG,"
        + "FOREIGN KEY(itemID) REFERENCES Item(id) ON UPDATE CASCADE ON DELETE CASCADE,"
        + "FOREIGN KEY(buyer) REFERENCES OrdinairyUser(username) ON UPDATE CASCADE ON DELETE CASCADE);";

        executeUpdate(createPurchaseTable);
    }

    private static void createCancellationRequestTable(){
        String createCancellationRequestTable = "CREATE TABLE IF NOT EXISTS CancellationRequest("
        + "itemID INT PRIMARY KEY,"
        + "reason VARCHAR(128), "
        + "FOREIGN KEY(itemID) REFERENCES Item(id) ON UPDATE CASCADE ON DELETE CASCADE);";

        executeUpdate(createCancellationRequestTable);
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

    private static void createTabooWordTable(){
        String createTabooWordTable = "CREATE TABLE IF NOT EXISTS TabooWord("
        + "word VARCHAR(128) PRIMARY KEY);";

        executeUpdate(createTabooWordTable);
    }

    //DATABASE INSERTION FUNCTIONS
    //TODO: ADD AUTHENTIFICATION FOR INPUTS/PARAMETERS

    private static void createUser(String username, String password, String name, boolean superUser){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT IGNORE INTO User VALUES(?, ?, ?, ?);");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,name);
            preparedStatement.setBoolean(4,superUser);
            preparedStatement.executeUpdate();
            preparedStatement.close();
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
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT IGNORE INTO OrdinairyUser VALUES(?,?,?,?,?,?,?,?,?,?,?);");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,address);
            preparedStatement.setString(3,creditCard);
            preparedStatement.setString(4,phoneNumber);
            preparedStatement.setString(5,"");
            preparedStatement.setString(6,"");
            preparedStatement.setBoolean(7,false);
            preparedStatement.setBoolean(8,false);
            preparedStatement.setBoolean(9,false);
            preparedStatement.setBoolean(10,false);
            preparedStatement.setBoolean(11,false);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    public static void createUserKeyword(String user, String keyword){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT IGNORE INTO UserKeyword VALUES(?,?)");
            preparedStatement.setString(1,user);
            preparedStatement.setString(2,keyword);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    private static void createItem(String itemName, String sellerUsername, String imageLocation, String associatedKeywords){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT IGNORE INTO Item(name,seller,registered,imageLocation,associatedKeywords) VALUES(?,?,?,?,?);");
            preparedStatement.setString(1,itemName);
            preparedStatement.setString(2,sellerUsername);
            preparedStatement.setBoolean(3,false);
            preparedStatement.setString(4,imageLocation);
            preparedStatement.setString(5,associatedKeywords);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            int itemID = getLastItemIndex();
            String [] keywords = associatedKeywords.split("[ ,]");
            for(String keyword : keywords)
                createItemKeyword(itemID,keyword);

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    public static void createFixedItem(String itemName, String sellerUsername, String imageLocation, String associatedKeywords, int fixedPrice){
        try{
            createItem(itemName,sellerUsername,imageLocation, associatedKeywords);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT IGNORE INTO FixedItem VALUES(?,?);");
            preparedStatement.setInt(1,getLastItemIndex());
            preparedStatement.setInt(2,fixedPrice);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    public static void createBidItem(String itemName, String sellerUsername, String imageLocation, String associatedKeywords, long startOfBid){
        try{
            createItem(itemName,sellerUsername,imageLocation,associatedKeywords);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT IGNORE INTO BidItem VALUES(?,?);");
            preparedStatement.setInt(1,getLastItemIndex());
            preparedStatement.setLong(2,startOfBid);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    public static void createItemKeyword(int itemID, String keyword){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT IGNORE INTO ItemKeyword VALUES(?,?)");
            preparedStatement.setInt(1,itemID);
            preparedStatement.setString(2,keyword);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    public static void createBid(int itemID, String bidder, int amount){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Bid WHERE itemID=? AND bidder=?");
            preparedStatement.setInt(1,itemID);
            preparedStatement.setString(2,bidder);
            preparedStatement.executeUpdate();
            
            preparedStatement = connection.prepareStatement("INSERT IGNORE INTO Bid VALUES(?,?,?);");
            preparedStatement.setInt(1,itemID);
            preparedStatement.setString(2,bidder);
            preparedStatement.setInt(3,amount);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    //TODO: add automatic timeStamp (current time in miliseconds) to each purchase made
    public static void createPurchase(int itemID, String buyer, int price){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT IGNORE INTO Purchase VALUES(?,?,?,?);");
            preparedStatement.setInt(1,itemID);
            preparedStatement.setString(2,buyer);
            preparedStatement.setInt(3,price);
            preparedStatement.setLong(4,0l);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    public static void createCancellationRequest(int itemID,String reason){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT IGNORE INTO CancellationRequest VALUES(?,?);");
            preparedStatement.setInt(1,itemID);
            preparedStatement.setString(2,reason);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    //TODO: everytime a rating is created, if a seller from Item has 3 or more itemIDs with 2 or lower rating, set outstandingUser in OrdinairyUser table to true for the associated username
    public static void createRating(int itemID, String reviewer, int rating, String review){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT IGNORE INTO Rating VALUES(?,?,?,?);");
            preparedStatement.setInt(1,itemID);
            preparedStatement.setString(2,reviewer);
            preparedStatement.setInt(3,rating);
            preparedStatement.setString(4,review);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    public static void createNotification(String title, String message, String receiver, boolean warning){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT IGNORE INTO Notification(title,message,receiver,warning) VALUES(?,?,?,?);");
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,message);
            preparedStatement.setString(3,receiver);
            preparedStatement.setBoolean(4,warning);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    public static void createComplaint(String title, String message, String sender){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT IGNORE INTO Complaint(title,message,sender,handled) VALUES(?,?,?,?);");
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,message);
            preparedStatement.setString(3,sender);
            preparedStatement.setBoolean(4,false);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    //TODO: User should not be able to add themselves as a friend
    public static void createFriend(String user, String friend){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT IGNORE INTO Friend VALUES(?,?);");
            preparedStatement.setString(1,user);
            preparedStatement.setString(2,friend);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    public static void createFriendRequest(String sender, String receiver){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT IGNORE INTO FriendRequest VALUES(?,?);");
            preparedStatement.setString(1,sender);
            preparedStatement.setString(2,receiver);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    public static void createTabooWord(String word){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT IGNORE INTO TabooWord VALUES(?);");
            preparedStatement.setString(1,word);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    //VALIDATION FUNCTIONS

    //returns true if username corresponds to an ordinairy user, false otherwise (tested)
    public static boolean isOrdinairyUser(String username, String password){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM OrdinairyUser INNER JOIN User ON OrdinairyUser.username=User.username WHERE OrdinairyUser.username=? AND password=? ");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

            ResultSet r1 = preparedStatement.executeQuery();
            String name;
            if(r1.next()){
                name =  r1.getString("OrdinairyUser.username");
                if(name.equals(username)) {
                    return true;
                }
            }
            preparedStatement.close();
            r1.close();
        }catch (Exception expt){
            expt.printStackTrace();
        }
        return false;
    }

    //returns true if username corresponds to a superuser, false otherwise (tested)
    public static boolean isSuperUser(String username, String password){
        boolean userIsSuperUser = false;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT superUser FROM User WHERE username=? AND password=?");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet queryOutput = preparedStatement.executeQuery();

            if(queryOutput.next())
                userIsSuperUser = queryOutput.getBoolean("superUser");
            
            preparedStatement.close();
            queryOutput.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
        return userIsSuperUser;
    }

    //returns vip from table OrdinairyUser for the associated username (tested)
    public static boolean isUserVip(String username){
        boolean userIsVip = false;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT vip FROM OrdinairyUser WHERE username=?");
            preparedStatement.setString(1,username);
            ResultSet queryOutput = preparedStatement.executeQuery();

            if(queryOutput.next())
                userIsVip = queryOutput.getBoolean("vip");
            
            preparedStatement.close();
            queryOutput.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }

        return userIsVip;
    }

    //returns registered from table OrdinairyUser for the associated username (tested)
    public static boolean isRegisteredUser(String username){
        boolean userIsRegistered = false;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT registered FROM OrdinairyUser WHERE username=?");
            preparedStatement.setString(1,username);
            ResultSet queryOutput = preparedStatement.executeQuery();

            if(queryOutput.next())
                userIsRegistered = queryOutput.getBoolean("registered");
            
            preparedStatement.close();
            queryOutput.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
        return userIsRegistered;
    }

    //returns tempBlocked from table OrdinairyUser for the associated username (tested)
    public static boolean isTempBlocked(String username){
        boolean userIsTempBlocked = false;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT tempBlocked FROM OrdinairyUser WHERE username=?");
            preparedStatement.setString(1,username);
            ResultSet queryOutput = preparedStatement.executeQuery();

            if(queryOutput.next())
                userIsTempBlocked = queryOutput.getBoolean("tempBlocked");
            
            preparedStatement.close();
            queryOutput.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
        return userIsTempBlocked;
    }

    //returns permBlocked from table OrdinairyUser for the associated username (tested)
    public static boolean isPermBlocked(String username){
        boolean userIsPermBlocked = false;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT permBlocked FROM OrdinairyUser WHERE username=?");
            preparedStatement.setString(1,username);
            ResultSet queryOutput = preparedStatement.executeQuery();

            if(queryOutput.next())
                userIsPermBlocked = queryOutput.getBoolean("permBlocked");

            preparedStatement.close();
            queryOutput.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
        return userIsPermBlocked;
    }

    //true if itemID is found within the BidItem table (tested)
    public static boolean isBidItem(int itemID){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM BidItem WHERE itemID=? ");
            preparedStatement.setInt(1,itemID);
            ResultSet r1=preparedStatement.executeQuery();
            int id;
            if(r1.next()) {
                id =  r1.getInt("itemID");
                if(id==itemID) {
                    return true;
                }
            }
            preparedStatement.close();
            r1.close();

        }catch (Exception expt){
            expt.printStackTrace();
        }
        return false;
    }

    //true if itemID is found within FixedItem (tested)
    public static boolean isFixedItem(int itemID){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM FixedItem WHERE itemID=? ");
            preparedStatement.setInt(1,itemID);
            ResultSet r1=preparedStatement.executeQuery();
            int id;
            if(r1.next()) {
                id =  r1.getInt("itemID");
                if(id==itemID) {
                    return true;
                }
            }
            preparedStatement.close();
            r1.close();
        }catch (Exception expt){
            expt.printStackTrace();
        }
        return false;
    }

    //DATA RETRIEVAL FUNCTIONS

    //returns User object storing the information of the user corresponding to username tested)
    public static User getOrdinairyUser(String username){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM OrdinairyUser join User on OrdinairyUser.username=User.username WHERE OrdinairyUser.username=?");
            preparedStatement.setString(1,username);

            ResultSet queryOutput = preparedStatement.executeQuery();

            if(queryOutput.next()) {
                String name = queryOutput.getString("name");
                String address = queryOutput.getString("address");
                String creditCard = queryOutput.getString("creditCard");
                String phoneNumber = queryOutput.getString("phoneNumber");
                String desiredKeyWords = queryOutput.getString("desiredKeyWords");
                String blockMessage = queryOutput.getString("blockMessage");

                preparedStatement.close();
                queryOutput.close();

                return new User(username,name,address,creditCard,phoneNumber,desiredKeyWords,blockMessage);
            }
        }catch (Exception expt){
            expt.printStackTrace();
        }
        return new User(username);
    }

    //returns an Item object with the qualities associated with itemID (tested)
    public static Item getItem(int itemID){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Item WHERE id=? ");
            preparedStatement.setInt(1,itemID);

            ResultSet queryOutput = preparedStatement.executeQuery();

            if(queryOutput.next()) {
                String name = queryOutput.getString("name");
                String seller = queryOutput.getString("seller");
                String imageLocation = queryOutput.getString("imageLocation");
                String associatedKeywords = queryOutput.getString("associatedKeywords");

                preparedStatement.close();
                queryOutput.close();

                return new Item(itemID,name,seller,imageLocation,associatedKeywords);
            }
        }catch (Exception expt){
            expt.printStackTrace();
        }
        return new Item(itemID);
    }

    //finds the highest bid from the Bid table and returns it (tested)
    public static int getHighestBid(int itemID){
        int amount = 0;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT MAX(amount) FROM Bid WHERE itemID=? ");
            preparedStatement.setInt(1,itemID);

            ResultSet r1=preparedStatement.executeQuery();

            if(r1.next()) {
                amount=r1.getInt("MAX(amount)");
            }
            preparedStatement.close();
            r1.close();

        }catch (Exception expt){
            expt.printStackTrace();
        }
        return amount;
    }

    //returns the username of the winning bid (tested)
    public static String getBidWinner(int itemID) {
        String winner = "";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT bidder FROM Bid WHERE itemID=? ORDER BY amount DESC");
            preparedStatement.setInt(1, itemID);

            ResultSet queryOutput = preparedStatement.executeQuery();

            if (queryOutput.next()) {
                winner = queryOutput.getString("bidder");
            }
            if(queryOutput.next()){
                winner = queryOutput.getString("bidder");
            }
            preparedStatement.close();
            queryOutput.close();
        }catch(Exception expt){
            expt.printStackTrace();
        }
            return winner;
    }

    //finds the price from the FixedItem table and returns it (tested)
    public static int getFixedPrice(int itemID){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `FixedItem` WHERE `itemID`=? ");
            preparedStatement.setInt(1,itemID);

            ResultSet r1=preparedStatement.executeQuery();

            if(r1.next()) {
                int price=r1.getInt("price");
                preparedStatement.close();
                r1.close();
                return  price;
            }

        }catch (Exception expt){
            expt.printStackTrace();
        }
        return 0;
    }

    //returns an ArrayList of users where item keywords match user keywords for the specified itemID (tested)
    public static ArrayList<String> getUsersWithMatchingKeywords(int itemID){
        ArrayList<String> listOfUsers = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT DISTINCT user FROM UserKeyword INNER JOIN ItemKeyword ON UserKeyword.keyword=ItemKeyword.keyword WHERE itemID=?");
            preparedStatement.setInt(1,itemID);
            ResultSet queryOutput = preparedStatement.executeQuery();
            while(queryOutput.next())
                listOfUsers.add(queryOutput.getString("user"));
            queryOutput.close();
            preparedStatement.close(); 
        }catch(Exception expt){
            expt.printStackTrace();
        }
        return listOfUsers;
    }

    //returns a default ArrayList of itemIDs for guest users which are not included in the table Purchase (tested)
    public static ArrayList<Item> getItemsOnSale(){
        ArrayList<Integer> listOfItems = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(" SELECT id FROM Item WHERE id NOT IN (SELECT itemID FROM Purchase) AND registered=true ORDER BY id DESC");
            ResultSet queryOutput = preparedStatement.executeQuery();

            while(queryOutput.next())
                listOfItems.add(queryOutput.getInt("id"));

            preparedStatement.close();
            queryOutput.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
        return toItemList(listOfItems);
    }

    //retrieves buyer from Purchase where Purchase.itemID = itemID (tested)
    public static String getBuyer(int itemID){
        String buyer = "";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT buyer FROM Purchase WHERE itemID=?");
            preparedStatement.setInt(1,itemID);
            ResultSet queryOutput = preparedStatement.executeQuery();
            if(queryOutput.next())
                buyer = queryOutput.getString("buyer");
            preparedStatement.executeUpdate();
            preparedStatement.close(); 
        }catch(Exception expt){
            expt.printStackTrace();
        }
        return buyer;

    }

    //searhes for Item.names and Item.KeyWords that match contents of search (tested)
    public static ArrayList<Item> searchForItems(String search){
        ArrayList<Integer> listOfItems = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM Item WHERE name=? " 
            + "AND registered=true "
            + "AND id NOT IN (SELECT itemID FROM Purchase) "
            + "UNION "
            + "SELECT DISTINCT itemID AS id FROM ItemKeyword WHERE keyword=? ORDER BY id DESC");

            preparedStatement.setString(1,search);
            preparedStatement.setString(2,search);
            ResultSet queryOutput = preparedStatement.executeQuery();

            while(queryOutput.next())
                listOfItems.add(queryOutput.getInt("id"));
            
            preparedStatement.close();
            queryOutput.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
        return toItemList(listOfItems);
    }

    //returns an ArrayList of itemIDs in Purchase where seller from table Item matches username (tested)
    public static ArrayList<Item> getItemsSoldBy(String username){
        ArrayList<Integer> listOfItems = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Item.id FROM Item INNER JOIN Purchase ON Item.id=Purchase.itemID WHERE Item.seller=?");
            preparedStatement.setString(1,username);
            ResultSet queryOutput = preparedStatement.executeQuery();

            while(queryOutput.next())
                listOfItems.add(queryOutput.getInt("id"));

            preparedStatement.close();
            queryOutput.close();         

        }catch(Exception expt){
            expt.printStackTrace();
        }

        return toItemList(listOfItems);
    }

    //returns an ArrayList of itemIDs in Purchase where buyer matches username (tested)
    public static ArrayList<Item> getItemsPurchasedBy(String username){
        ArrayList<Integer> listOfItems = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT itemID FROM Purchase WHERE buyer=?");
            preparedStatement.setString(1,username);
            ResultSet queryOutput = preparedStatement.executeQuery();

            while(queryOutput.next())
                listOfItems.add(queryOutput.getInt("itemID"));

            preparedStatement.close();
            queryOutput.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
        return toItemList(listOfItems);
    }

    //finds ALL notifications with the associated username and returns an ArrayList containing them (tested)
    public static ArrayList<Notification> getNotificationsFor(String username){
        ArrayList<Notification> listOfNotifications = new ArrayList<>();
        int id;
        String title;
        String message;
        boolean warning;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Notification WHERE receiver=?");
            preparedStatement.setString(1,username);
            ResultSet queryOutput = preparedStatement.executeQuery();

            while(queryOutput.next()){
                id = queryOutput.getInt("id");
                title = queryOutput.getString("title");
                message = queryOutput.getString("message");
                warning = queryOutput.getBoolean("warning");
                listOfNotifications.add(new Notification(id,title,message,username,warning));
            }
            preparedStatement.close();
            queryOutput.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
        return listOfNotifications;
    }

    //returns an ArrayList list of friends for user with the specified username (tested)
    public static ArrayList<String> getFriendsOf(String username){
        ArrayList<String> listOfFriends = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT friend FROM Friend WHERE user=?");
            preparedStatement.setString(1,username);
            ResultSet queryOutput = preparedStatement.executeQuery();

            while(queryOutput.next())
                listOfFriends.add(queryOutput.getString("friend"));

            preparedStatement.close();
            queryOutput.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
        return listOfFriends;
    }

    //returns an ArrayList of friendRequests for user with the specified username (tested)
    public static ArrayList<String> getFriendRequestsOf(String username){
        ArrayList<String> listOfFriendRequests = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT sender FROM FriendRequest WHERE receiver=?");
            preparedStatement.setString(1,username);
            ResultSet queryOutput = preparedStatement.executeQuery();

            while(queryOutput.next()){
                listOfFriendRequests.add(queryOutput.getString("sender"));
            }
            preparedStatement.close();
            queryOutput.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
        return listOfFriendRequests;
    }

    //returns the avg of ratings from table Rating of all itemIds where seller = username in table Item (tested)
    public static int getAverageRating(String username){
        int avg = 0;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT AVG(rating) FROM Rating INNER JOIN Item ON Item.id=Rating.itemID WHERE Item.seller=?");
            preparedStatement.setString(1,username);
            ResultSet queryOutput = preparedStatement.executeQuery();
            
            if(queryOutput.next())
                avg = queryOutput.getInt("AVG(rating)");

            preparedStatement.close();
            queryOutput.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
        return avg;
    }

    //returns an ArrayList of itemIDs where registered = false in the Item table (tested)
    public static ArrayList<Item> getUnregisteredItems(){
        ArrayList<Integer> listOfItems = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM Item WHERE registered=false ORDER BY id DESC");
            ResultSet queryOutput = preparedStatement.executeQuery();

            while(queryOutput.next())
                listOfItems.add(queryOutput.getInt("id"));

            preparedStatement.close();
            queryOutput.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
        return toItemList(listOfItems);
    }

    //returns an ArrayList of usernames where registered = false in the OrdinairyUser table (tested)
    public static ArrayList<User> getUnregisteredUsers(){
        ArrayList<String> listOfUsers = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM OrdinairyUser WHERE registered=false");
            ResultSet queryOutput = preparedStatement.executeQuery();

            while(queryOutput.next())
                listOfUsers.add(queryOutput.getString("username"));

            preparedStatement.close();
            queryOutput.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
        return toUserList(listOfUsers);
    }

    //returns an ArrayList of complaintIDs from Complaint table where handled = false (tested)
    public static ArrayList<Complaint> getUnhandledComplaints(){
        ArrayList<Complaint> listOfComplaints = new ArrayList<>();
        int id = 0;
        String title = "";
        String message = "";
        String sender = "";
        boolean handled = false;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Complaint WHERE handled=false");
            ResultSet queryOutput = preparedStatement.executeQuery();

            while(queryOutput.next()){
                id = queryOutput.getInt("id");
                title = queryOutput.getString("title");
                message = queryOutput.getString("message");
                sender = queryOutput.getString("sender");
                handled = queryOutput.getBoolean("handled");
                listOfComplaints.add(new Complaint(id,title,message,sender,handled));
            }
            preparedStatement.close();
            queryOutput.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
        return listOfComplaints;
    }

    //returns an ArrayList of itemIDs with timeStamps from Purchase within the range of startTime and endTime where buyer = Purchase.buyer (tested)
    public static ArrayList<Item> getPurchaseHistory(String buyer, long startTime, long endTime){
        ArrayList<Integer> listOfItems = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Purchase WHERE buyer=? AND timeStamp BETWEEN ? AND ? ORDER BY timeStamp DESC");
            preparedStatement.setString(1,buyer);
            preparedStatement.setLong(2,startTime);
            preparedStatement.setLong(3,endTime);
            ResultSet queryOutput = preparedStatement.executeQuery();

            while(queryOutput.next())
                listOfItems.add(queryOutput.getInt("itemID"));

            preparedStatement.close();
            queryOutput.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
        return toItemList(listOfItems);
    }

    //returns an ArrayList of itemIDs with timeStamps from Purchase within the range of startTime and endTime where seller = Item.seller and Purchase.itemID = Item.id (tested)
    public static ArrayList<Item> getSaleHistory(String seller, long startTime, long endTime){
        ArrayList<Integer> listOfItems = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Purchase INNER JOIN Item ON Purchase.itemID=Item.id WHERE seller=? AND timeStamp BETWEEN ? AND ? ORDER BY timeStamp DESC");
            preparedStatement.setString(1,seller);
            preparedStatement.setLong(2,startTime);
            preparedStatement.setLong(3,endTime);
            ResultSet queryOutput = preparedStatement.executeQuery();

            while(queryOutput.next())
                listOfItems.add(queryOutput.getInt("Purchase.itemID"));

            preparedStatement.close();
            queryOutput.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
        return toItemList(listOfItems);
    }

    //TODO: update outstanding OrdinairyUser status when a seller buys or sells an item
    //returns an ArrayList of all usernames where outstandingUser = true (tested)
    public static ArrayList<User> getOutstandingUsers(){
        ArrayList<String> listOfUsers = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM OrdinairyUser WHERE outstandingUser=true");
            ResultSet queryOutput = preparedStatement.executeQuery();

            while(queryOutput.next())
                listOfUsers.add(queryOutput.getString("username"));

            preparedStatement.close();
            queryOutput.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }

        return toUserList(listOfUsers);
    }

    //returns an ArrayList of words from table TabooWord (tested)
    public static ArrayList<String> getTabooWords(){
        ArrayList<String> listOfWords = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM TabooWord");
            ResultSet queryOutput = preparedStatement.executeQuery();

            while(queryOutput.next())
                listOfWords.add(queryOutput.getString("word"));

            preparedStatement.close();
            queryOutput.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
        return listOfWords;
    }

    //returns an ArrayList of all itemIDs in CancellationRequest table (tested)
    public static ArrayList<CancellationRequest> getCancellationRequests(){
        ArrayList<CancellationRequest> listOfRequests = new ArrayList<>();
        int itemID;
        Item item;
        String reason;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CancellationRequest");
            ResultSet queryOutput = preparedStatement.executeQuery();

            while(queryOutput.next()){
                itemID = queryOutput.getInt("itemID");
                reason = queryOutput.getString("reason");
                item = getItem(itemID);
                listOfRequests.add(new CancellationRequest(item,reason));
            }

        }catch(Exception expt){
            expt.printStackTrace();
        }
        return listOfRequests;
    }


    //DATA MODIFICATION FUNCTIONS

    //NOTE: Call function when purchase is canceled
    //sets registered to true in Item table (tested)
    public static void registerItem(int itemID){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Item SET registered=true WHERE id=?");
            preparedStatement.setInt(1,itemID);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch (Exception expt){
            expt.printStackTrace();
        }
    }

    //sets registered to true in OrdinairyUser table where OrdinairyUser.username = username (tested)
    public static void registerUser(String username){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE OrdinairyUser SET registered=true WHERE username=?");
            preparedStatement.setString(1,username);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    //NOTE: Call this function where a purchase is canceled
    //removes item associated with itemID from Item table (tested)
    public static void removeItem(int itemID){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Item WHERE id=?");
            preparedStatement.setInt(1,itemID);
            preparedStatement.executeUpdate();
            preparedStatement.close(); 
        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    //sets vip in OrdinairyUser to true for the associated username (tested)
    public static void makeUserVip(String username){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE OrdinairyUser SET vip=true WHERE username=?");
            preparedStatement.setString(1,username);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    //sets vip in OrdinairyUser to false for the associated username (tested)
    public static void makeUserNotVip(String username){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE OrdinairyUser SET vip=false WHERE username=?");
            preparedStatement.setString(1,username);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    //TODO: function is called upon every purchase and rating created
    //updates vip statues to true/false based on ratings/spending vip rules
    public static void updateUserVipStatus(String username){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("");
            preparedStatement.executeUpdate();
            preparedStatement.close(); 
        }catch(Exception expt){
            expt.printStackTrace();
        }

    }

    //checks if bid time is up, and if it is, sells the item to getBidWinner()
    public static void updateBidItems(){
        try{
            long currentTime = Calendar.getInstance().getTimeInMillis();
            long bidDuration = 180000;//3 minutes
            PreparedStatement preparedStatement = connection.prepareStatement("");
            preparedStatement.executeUpdate();
            preparedStatement.close(); 
        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    //TODO:update UserKeyword table automatically
    //sets the keywords of associated username to keywords in User table (tested)
    public static void editKeywords(String username, String keywords){
        String [] words = keywords.split("[ ,]");
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM UserKeyword WHERE user=?");
            preparedStatement.setString(1,username);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("UPDATE OrdinairyUser SET desiredKeyWords=? WHERE username=?");
            preparedStatement.setString(1,keywords);
            preparedStatement.setString(2,username);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            for(String word : words)
                createUserKeyword(username,word);
        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    //creates notification(s) based on itemID's keyowrds in Item that match with the desiredKeywords of OrdinairyUsers (is called when an item is registered and put on sale) (tested)
    public static void sendNotificationsFor(int itemID){
        ArrayList<String> listOfUsers = getUsersWithMatchingKeywords(itemID);
        Item itemOnSale = getItem(itemID);
        String messageTitle = "Item is on sale!";
        String messageContents = itemOnSale.getItemName() + " is on sale! If you wish to buy it, simply search for it on the homepage.";
        for(String user : listOfUsers)
            sendMessage(user,messageTitle,messageContents);
    }

    //NOTE: change friend message page and remove Title
    //sends a notification (as a message) from one user to another (users should be friends), place sender username in title (tested)
    public static void sendFriendMessage(String sender, String receiver, String messageTitle, String messageContents){
        String newTitle = "Message From " + sender;
        createNotification(newTitle,messageContents,receiver,false);
    }

    //sends a notification (as a message) from a SuperUser to an Ordinairy user (tested)
    public static void sendMessage(String receiver, String messageTitle, String messageContents){
        createNotification(messageTitle, messageContents, receiver,false);
    }

    //sends a notification (warning) to an OrdinairyUser (tested)
    public static void sendWarning(String receiver, String title, String messageContents){
        String warningTitle = "Warning! " + title;
        createNotification(warningTitle,messageContents,receiver,true);
    }

    //removes entry (user,friend) from table Friend (tested)
    public static void deleteFriend(String user, String friend){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Friend WHERE user=? AND friend=?");
            preparedStatement.setString(1,user);
            preparedStatement.setString(2,friend);
            preparedStatement.executeUpdate();
            preparedStatement.close(); 
        }catch(Exception expt){
            expt.printStackTrace();
        }
    }
    
    //removes entry (sender,receiver) from table FriendRequest (tested)
    public static void deleteFriendRequest(String sender, String receiver){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM FriendRequest WHERE sender=? AND receiver=?");
            preparedStatement.setString(1,sender);
            preparedStatement.setString(2,receiver);
            preparedStatement.executeUpdate();
            preparedStatement.close(); 
        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    //removes word from TabooWord table if it exists (tested)
    public static void removeTabooWord(String word){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM TabooWord WHERE word=?");
            preparedStatement.setString(1,word);
            preparedStatement.executeUpdate();
            preparedStatement.close(); 
        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    //calls cancled canclePurchase and removeItem function on itemID and removes the itemID's occurence from CancellationRequest table (tested)
    public static void approveCancellation(int itemID){
        Item item = getItem(itemID);
        String buyer = getBuyer(itemID);
        String seller = item.getSeller();
        String messageTitle = "Purchase has been canceled";
        String messageContent = "The item " + item.getItemName() + " has been removed from the sale board, with Item-ID " + item.getItemID()
        + ". Any purchases made associated with this item have also been canceled.";
        removeItem(itemID);
        sendMessage(buyer,messageTitle,messageContent);
        sendMessage(seller,messageTitle,messageContent);
    }

    //removes itemId's occurence form the CancellationRequest table (tested)
    public static void rejectCancellation(int itemID){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM CancellationRequest WHERE itemID=?");
            preparedStatement.setInt(1,itemID);
            preparedStatement.executeUpdate();
            preparedStatement.close(); 
        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    //sets handled to true for the associated complaintID in Complaint table (tested)
    public static void handleComplaint(int complaintID){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Complaint SET handled=true WHERE id=?");
            preparedStatement.setInt(1,complaintID);
            preparedStatement.executeUpdate();
            preparedStatement.close(); 
        }catch(Exception expt){
            expt.printStackTrace();
        }
    }
    
    //TODO:(done automatically whenever a 2nd warning is sent)
    //sets the tempBlocked boolean to true and OrdinairyUser.blockMessage to blockMessage in table OrdinairyUser for the associate username (tested)
    public static void blockUserTemp(String username, String blockMessage){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE OrdinairyUser SET tempBlocked=true, blockMessage=? WHERE username=?");
            preparedStatement.setString(1,blockMessage);
            preparedStatement.setString(2,username);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    //sets the blockPerm boolean in table OrdinairyUser to true for associated username (tested)
    public static void blockUserPerm(String username){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE OrdinairyUser SET permBlocked=true WHERE username=?");
            preparedStatement.setString(1,username);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    //sets both tempBlocked and permBlocked to false in OrdinairyUser table for the associated username (tested)
    public static void unblockUser(String username){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE OrdinairyUser SET tempBlocked=false, permBlocked=false, blockMessage=? WHERE username=?");
            preparedStatement.setString(1,"");
            preparedStatement.setString(2,username);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch(Exception expt){
            expt.printStackTrace();
        }
    }

    //MISCELLANEOUS FUNCTIONS

    //converts a string in date format into a long value representing the date in miliseconds
    public static long dateStringToLong(String dateString){
        return 0l;
    }

    public static ArrayList<User> toUserList(ArrayList<String> usernames ){
        ArrayList<User> userList = new ArrayList<>();
        for(String username : usernames)
            userList.add(getOrdinairyUser(username));
        
        return userList;
    }

    public static ArrayList<Item> toItemList(ArrayList<Integer> itemIDList){
        ArrayList<Item> itemList = new ArrayList<>();
        for(int itemID : itemIDList)
            itemList.add(getItem(itemID));
        
        return itemList;
    }

    private static int getLastItemIndex(){
        int id = 0;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM Item ORDER BY id DESC LIMIT 1");
            ResultSet queryOutput = preparedStatement.executeQuery();

            if(queryOutput.next())
                id = queryOutput.getInt("id");
            
            queryOutput.close();
            preparedStatement.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
        return id;
    }

    public static void closeResources(){
        try{
            if(connection != null)
                connection.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }
}


//schemas
/*
User(username:str primKey, password:str, name:str, superUser:boolean)
OrdinaryUser(username:str primKey/frgn key, address:str, creidCard:str, phoneNumber:str, desiredKeyWords:Str, blockMessage:str, vip:bool, outstandingUser:bool, tempBlocked:bool,permBlocked:bool,registered:bool)

Item(id:int primKey, name:str, registered:bool, imageURL/file:str, associatedKeywords:str)
FixedItem(id:int primKey/frgn key, fixedPrice: int) //price is input as string, then converted to float
BidItem(id:int primKey/frgn key, startOfBid:long)//default bid duration: 3 min; startOfBid -> timestamp in milliseconds
Bid(itemID:int frgn key, bidder:str primKey frgn key, amount:float)

Purchase(itemID: int primKey/frgn key, buyer:str frgn key, price: int, timeStamp:long)
CancellationRequest(itemID:int, reason:str)
Rating(itemID: int frgn key, reviewer:str frgn key, rating:int, review:str) primKey(itemID,reviewer)
Notification(id:int primKey, title:str, message:str, receiver:str frgn key, warning:bool) //when retrieving notifications, order them descendingly (so that the lastest notificcation comes first
Complaint(id:int primKey, title:str, message:str, sender:str frgn key, handled:bool)

Friend(user:str frgn key, friend:str frgn key)primKey(user,friend)
FriendRequest(sender:str frgn key, receiver frgn key) primKey(sender, receiver)
TabooWords(word:str)
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
    
    //returns registered from Item table for associated itemID
    public static boolean isRegisteredItem(int itemID){
        return false;
    }

    //if itemID is not in Purchase and registered in Item is true, then return true, and otherwise, return false
    public static boolean isItemOnSale(int itemID){

        try{
            preparedStatement = connection.prepareStatement("SELECT * FROM `Item` WHERE `id`=? ");
            preparedStatement.setInt(1,itemID);
            ResultSet r1=preparedStatement.executeQuery();
            int id;
            if(r1.next()) {
                id =  r1.getInt("itemID");
                if(id==itemID) {
                    return true;
                }
            }
        }catch (Exception expt){
            expt.printStackTrace();
        }
        return false;
    }

*/
