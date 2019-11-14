public class Admin {
    private String name;
    protected String userName;
    protected String password;

    public Admin(){}
    public Admin(String name ,String userName, String password){
        this.name = name;
       this.userName = userName;
       this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void displayText(){
        System.out.println("");
    }
}
