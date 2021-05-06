package registerDemo.dataAccess.abstracts;

import registerDemo.entitiy.concrete.User;

import java.util.ArrayList;

public interface IUserDao {
    void add(User user);

    boolean read(User user);

    void update(User user);

    void delete(User user);

    ArrayList<User> getAll();
}
