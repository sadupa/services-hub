package hms.service.hub.core;

import hms.service.hub.orm.model.User;

import java.util.List;

/**
 * Created by yasitha on 7/26/16.
 */
public interface UserService {

    User getUserById(long id);

    List<User> getAllUsers();

    List<User> getAllActiveUsers();
}
