package registerDemo.dataAccess.concrete;

import registerDemo.dataAccess.abstracts.IUserDao;
import registerDemo.entitiy.concrete.User;

import java.util.ArrayList;

public class UserDao implements IUserDao {

    private static ArrayList<User> userList;

    public UserDao() {
        userList = new ArrayList<>();
    }

    @Override
    public void add(User user) {
        System.out.println(user.getFirstName() + " UserDao ile kayıt oldu");
        userList.add(user);

    }

    @Override
    public boolean read(User user) {
        if (userList != null) {
            for (User users : userList) {
                if (users.getEmail().equals(user.getEmail())) {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public ArrayList<User> getAll() {
        return userList;
    }
}