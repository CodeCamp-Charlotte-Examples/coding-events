package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Chris Bay
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByUsername(String username);

}
