package registerDemo.business.abstracts;

import registerDemo.entitiy.concrete.User;

public interface UserService {

    void singUp(User user);
    void singIn(String email,String password);







}
