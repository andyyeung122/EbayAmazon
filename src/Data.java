import java.sql;

public class Data{
    static{

    }
}

/*
schemas

User(username:str primKey, password:str, name:str)
OrdinaryUser(username:str primKey/frgn key, password frgn key, address:str, creidCard:str, phoneNumber:str, vip:bool, tempBlocked:bool,permBlocked:bool,desiredKeyWords:Str)
Superuser(username:str primKey, password:str, name:str)

Item(id:int primKey, name:str, registered:bool, imageURL/file:str, associatedKeywords:str) 
BidItem(id:int primKey/frgn key, highestBid: str)//update highest bid whenever bid is added; default bid duration: 3 min
FixedItem(id:int primKey/frgn key, fixedPrice: str)

Purchase(itemID: int primKey/frgn key, seller:str frgn key, buyer:str frgn key, price: str)
Rating(itemID: int frgn key, reviewer:str frgn key, seller:str frgn key, rating:float, review:str) primKey(itemID, reviewer)//if rating for (itemID, reviewer) already exists, do not prompt for review/rating
Notification(id:int primKey, title:str, message:str, receiver:str frgn key, timeStamp:long, warning:bool) //timestamp should be in milliseconds
Complaint(id:int primKey, title:str, message:str, sender:str frgn key, handled:bool)

Friend(user:str frgn key, friend:str frgn key)primKey(user,friend)
FriendRequest(sender:str frgn key, receiver frgn key) primKey(sender, receiver)
*/