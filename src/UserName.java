public class UserName {
    private static UserName single;
    public String username;

    private UserName() {
        username = "";
    }

    public static UserName makeInstance() {
        if (single == null) {
            single = new UserName();
        }
        return single;
    }

    public void setUsername(String un) {
        this.username = un;
    }

    public String getUsername() {
        return this.username;
    }
}
