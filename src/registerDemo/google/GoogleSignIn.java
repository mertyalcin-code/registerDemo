package registerDemo.google;

import java.util.ArrayList;
import java.util.List;

public class GoogleSignIn {

    List<String> googleUser= new ArrayList<String>() ;
    String password;
    String emailToGo;

        public List<String> signIn(String email) {
            emailToGo=email;
            googleUser.add(emailToGo);
            password="PasswordGeneratedFromGoogle";
            googleUser.add(password);

        return googleUser;
    }
}
