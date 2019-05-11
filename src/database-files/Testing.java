import java.util.ArrayList;

public class Testing{

    public static void main(String [] args){
        Data testData = new Data();
        Data.createOrdinairyUser("dude55","1234","dude","123 your mum's house", "123456789", "347 123 45678");
        Data.createOrdinairyUser("dude77","1234567","dudette","123 your dad's house", "123456789", "347 123 45678");
        Data.createSuperUser("dude66","1234","dudedude");
        Data.createFixedItem("Red Dress", "dude55","C:/location","keyword,dress",1000);
        Data.createBidItem("Red Blouse","dude55","C:/location","keyword,red",0l);
        Data.createPurchase(1,"dude55",12345);
        Data.createPurchase(3,"dude55",12345);
        Data.createPurchase(5,"dude77",12345);
        Data.createRating(1,"dude55",3,"I hate this item");
        Data.createNotification("Stop Sending Nudes!", "Please stop sending nudes!", "dude77", true);
        Data.createComplaint("Title", "Message Message", "dude55");
        Data.createFriend("dude55","dude77");
        Data.createFriendRequest("dude55","dude77");
        Data.createTabooWord("Fudge");
        Data.createCancellationRequest(1,"I can't find it");
        System.out.println(Data.isOrdinairyUser("dude55"));
        System.out.println(Data.isOrdinairyUser("dude66"));
        System.out.println(Data.isBidItem(13));
        System.out.println(Data.isFixedItem(12));
        System.out.println(Data.isSuperUser("dude66"));
        System.out.println("Is dude55 vip?: " + Data.isUserVip("dude55"));
        Data.makeUserVip("dude55");
        System.out.println("Is dude55 vip?: " + Data.isUserVip("dude55"));
        Data.makeUserNotVip("dude55");
        System.out.println("Is dude55 vip?: " + Data.isUserVip("dude55"));
        System.out.println("Is dude55 registered? " + Data.isRegisteredUser("dude55"));
        Data.registerUser("dude55");
        System.out.println("Is dude55 registeredd? " + Data.isRegisteredUser("dude55"));

        System.out.println("Is dude55 tempBlocked? " + Data.isTempBlocked("dude55"));
        Data.blockUserTemp("dude55","You have received 2 warnings");
        System.out.println("Is dude55 tempBlocked? " + Data.isTempBlocked("dude55"));
    
        System.out.println("Is dude55 permBlocked? " + Data.isPermBlocked("dude55"));
        Data.blockUserPerm("dude55");
        System.out.println("Is dude55 permBlocked? " + Data.isPermBlocked("dude55"));

        Data.unblockUser("dude55");
        System.out.println("Is dude55 tempBlocked? " + Data.isTempBlocked("dude55"));
        System.out.println("Is dude55 permBlocked? " + Data.isPermBlocked("dude55"));

        User currentUser = Data.getOrdinairyUser("dude55");
        System.out.println("name: " + currentUser.getName() + "\naddress: " + currentUser.getAddress() + "\nphoneNumber: " + currentUser.getPhoneNumber() +  "\nblockMessage: " + currentUser.getBlockMessage());
        
        Item currentItem = Data.getItem(4);
        System.out.println("itemName: " + currentItem.getItemName() + "\nseller: " + currentItem.getSeller() + "\nimageLocation: " + currentItem.getImageLocation());
        
        Data.createBid(4,"dude55",30);
        Data.createBid(4,"dude55",40);
        Data.createBid(4,"dude77",70);
        
        System.out.println("Highest bid: " + Data.getHighestBid(4));
        System.out.println("Winning bidder: " + Data.getBidWinner(4));
        System.out.println("Fixed price: " + Data.getFixedPrice(4));

        Data.registerItem(1);
        Data.registerItem(2);
        Data.registerItem(3);

        ArrayList<Item> itemsOnSale = Data.getItemsOnSale();
        
        for(Item item : itemsOnSale)
            System.out.println("Item on sale: " + item.getItemID());

        ArrayList<Item> searchItems = Data.searchForItems("Red");

        for(Item item : searchItems)
            System.out.println("Search results\nitemID: " + item.getItemID() + " \nname: " +  item.getItemName());
        
        Data.createUserKeyword("dude55","dudes");

        ArrayList<Item> itemsSoldBy = Data.getItemsSoldBy("dude55");

        for(Item item : itemsSoldBy)
            System.out.println("Items sold\nitemID: " + item.getItemID() + "\nitemName: " + item.getItemName());

        ArrayList<Item> itemsPurchasedBy = Data.getItemsPurchasedBy("dude77");

        for(Item item : itemsPurchasedBy)
            System.out.println("Items Purchased\nitemID: " + item.getItemID() + "\nitemName: " + item.getItemName());

        ArrayList<Notification> listOfNotifications = Data.getNotificationsFor("dude77");

        for(Notification note : listOfNotifications)
            System.out.println("Notes\ntitle " + note.getTitle() + "\nmessage: " + note.getMessage());

        ArrayList<String> listOfFriends = Data.getFriendsOf("dude55");

        for(String friend : listOfFriends)
            System.out.println(friend);
        
        ArrayList<String> listOfFriendRequests = Data.getFriendRequestsOf("dude55");

        for(String friendRequestSender : listOfFriendRequests)
            System.out.println("Firned Request: " + friendRequestSender);
        
        System.out.println(Data.getAverageRating("dude55"));

        ArrayList<Item> unregisteredItems = Data.getUnregisteredItems();

        for(Item item : unregisteredItems)
            System.out.println("itemID: " + item.getItemID() + " itemName: " + item.getItemName());

        Data.closeResources();
        
    }
}