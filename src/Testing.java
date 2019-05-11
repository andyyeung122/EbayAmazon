
public class Testing{

    public static void main(String [] args){
        Data testData = new Data();
        Data.createOrdinairyUser("dude55","1234","dude","123 your mum's house", "123456789", "347 123 45678");
        Data.createSuperUser("dude66","1234","dudedude");
        Data.createFixedItem("Red Dress", "dude55","C:/location","keyowrd",1000);
        Data.createBidItem("Red Blouse","dude55","C:/location","keyword",0l);
        Data.createPurchase(1,"dude55",12345);
        Data.createRating(1,"dude55",3,"I hate this item");
        Data.createNotification("Stop Sending Nudes!", "Please stop sending nudes!", "dude55", true);
        Data.createComplaint("Title", "Message Message", "dude55");
        Data.createFriend("dude55","dude55");
        Data.createFriendRequest("dude55","dude55");
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
        Data.closeResources();
        
    }

}