package registerDemo.business.abstracts;

import registerDemo.entitiy.concrete.User;

public interface UserCheckService {
    boolean checkMail(String email);
    boolean checkFirstName(String firstName);
    boolean checkLastName(String LastName);
    boolean checkPassword(String password);
    boolean checkAlreadyRegistered(User user);
}
