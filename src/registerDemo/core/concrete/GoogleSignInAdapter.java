package registerDemo.core.concrete;

import registerDemo.core.abstracts.SignInService;
import registerDemo.google.GoogleSignUp;

public class GoogleSignInAdapter implements SignInService {


    GoogleSignUp googleSignIn = new GoogleSignUp();
    @Override
    public boolean signInWithOthers(String email) {
       return googleSignIn.signUp(email);

    }
}
