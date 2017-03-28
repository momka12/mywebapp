package org.itstep.myWebApp.repository.mock;

import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MockUserRepository implements UserRepository {

    private Map<Integer, User> users = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(1);

    {
        save(new User("petrik", "ivanov", "dnepr", "petr@mail.com"));
        save(new User("maria", "forma", "odessa", "maria@mail.com"));
        save(new User("romka", "fich", "dnepr", "romka@mail.com"));
    }

    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    public boolean delete(Integer id) {
        return users.remove(id) != null;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(counter.getAndIncrement());
        }

        users.put(user.getId(), user);

        return user;
    }

    public User getById(Integer id) {
        return users.get(id);
    }
}
