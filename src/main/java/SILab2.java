import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public boolean function (User user, List<String> allUsers) {
        if (user!=null) { // A
            if (user.getUsername()!=null && user.getEmail()!=null && !allUsers.contains(user.getUsername())) { // B
                boolean atChar = false, dotChar = false; // C
                for (int i=0;i<user.getEmail().length();i++) { // D1, D2, D3
                    if (user.getEmail().charAt(i)=='@') // E
                        atChar = true; // F
                    if (atChar && user.getEmail().charAt(i)=='.') { // G
                        dotChar = true; // H
                    }
                }
                if (atChar && dotChar) { // I
                    return true; // J
                }
            }
        }
        return false; // K
    }
}
