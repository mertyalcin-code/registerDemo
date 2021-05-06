package registerDemo.business.concrete;

import registerDemo.business.abstracts.UserCheckService;
import registerDemo.dataAccess.abstracts.IUserDao;
import registerDemo.entitiy.concrete.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserCheck implements UserCheckService {

    IUserDao iUserDao;

    public UserCheck(IUserDao iUserDao) {
        this.iUserDao = iUserDao;
    }

    @Override
    public boolean checkMail(String email) {
        Pattern mailPatern = Pattern.compile("[a-z A-Z 0-9]+@[a-z A-Z 0-9]+\\.[a-z A-Z 0-9]+$");
        Matcher mailmatcher = mailPatern.matcher(email);
        return mailmatcher.matches();
    }

    @Override
    public boolean checkFirstName(String firstName) {
        Pattern namePatern = Pattern.compile(".{2,}");
        Matcher nameMatcher = namePatern.matcher(firstName);

        return nameMatcher.matches();

    }

    @Override
    public boolean checkLastName(String LastName) {
        Pattern lastNamePatern = Pattern.compile(".{2,}");
        Matcher lastNameMatcher = lastNamePatern.matcher(LastName);
        return  lastNameMatcher.matches();

    }

    @Override
    public boolean checkPassword(String password) {
        Pattern passwordPatern = Pattern.compile(".{6,}");
        Matcher paswordMatcher = passwordPatern.matcher(password);
        return paswordMatcher.matches();

    }

    @Override
    public boolean checkAlreadyRegistered(User user) {
        return !iUserDao.read(user);
    }
}
