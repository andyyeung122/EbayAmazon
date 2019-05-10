
public class Testing{

    public static void main(String [] args){
        Data testData = new Data();
        Data.createOrdinairyUser("dude55","1234","dude","123 your mum's house", "123456789", "347 123 45678");
        Data.createSuperUser("dude66","1234","dudedude");
        Data.createFixedItem("Red Dress", "dude55","C:/location","keyowrd",1000);
        Data.createPurchase(1,"dude55",12345);
        Data.createRating(1,"dude55",3,"I hate this item");
        Data.createNotification("Stop Sending Nudes!", "Please stop sending nudes!", "dude55", true);
        Data.createComplaint("Title", "Message Message", "dude55");
        Data.createFriend("dude55","dude55");
        Data.createFriendRequest("dude55","dude55");
        Data.createTabooWord("Fudge");
        Data.createCancellationRequest(1,"I can't find it");
        Data.closeResources();
        
    }

}