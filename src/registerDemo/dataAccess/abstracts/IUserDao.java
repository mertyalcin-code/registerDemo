package registerDemo.dataAccess.abstracts;

import registerDemo.entitiy.concrete.User;

import java.util.ArrayList;

public interface IUserDao {
    void add(User user);

    boolean read(User user);

    ArrayList<User> getAll();
}
