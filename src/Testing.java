
public class Testing{

    public static void main(String [] args){
        Data testData = new Data();
        Data.createOrdinairyUser("dude55","1234","dude","123 your mum's house", "123456789", "347 123 45678");
        Data.createSuperUser("dude66","1234","dudedude");
        Data.createBidItem("Red Blouse", "dude66","C:/still-at-your-moms-house","red,dress,blouse",12345123131l);
        Data.closeResources();
        
    }

}