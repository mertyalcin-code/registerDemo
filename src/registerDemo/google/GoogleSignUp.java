package registerDemo.google;

import java.util.ArrayList;
import java.util.List;

public class GoogleSignUp {




    public List<String> signUp(String email){
        List<String> googleUserInfo =new ArrayList<String>() {    };
        String firstName;
        String lastName;
        String password;
        String emailToGo;

            emailToGo=email;
            firstName="FirstNameFromGoogle";
            lastName="LastNameFromGoogle";
            password="PasswordGeneratedFromGoogle";

            googleUserInfo.add(emailToGo);
             googleUserInfo.add(password);
            googleUserInfo.add(firstName);
             googleUserInfo.add(lastName);
                 return googleUserInfo;
    }

}
