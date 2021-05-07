package registerDemo.core.concrete;

import registerDemo.core.abstracts.SignInService;

import registerDemo.google.GoogleSignIn;


import java.util.List;

public class GoogleSignInAdapter implements SignInService {


    @Override
    public List<String> signInWithOthers(String email) {
        GoogleSignIn googleSignIn = new GoogleSignIn();
        return googleSignIn.signIn(email);
    }
}
