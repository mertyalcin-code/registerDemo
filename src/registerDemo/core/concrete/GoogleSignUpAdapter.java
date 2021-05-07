package registerDemo.core.concrete;

import registerDemo.core.abstracts.SignUpService;
import registerDemo.google.GoogleSignUp;

import java.util.*;

public class GoogleSignUpAdapter implements SignUpService {


    GoogleSignUp googleSignUp = new GoogleSignUp();
    @Override
    public List<String> signUpWithOthers(String email) {
       return googleSignUp.signUp(email);
    }
}
