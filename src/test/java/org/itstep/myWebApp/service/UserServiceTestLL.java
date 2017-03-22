package org.itstep.myWebApp.service;

import org.itstep.myWebApp.UserTestData;
import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.util.NotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.itstep.myWebApp.UserTestData.USER_SAVE;

@ContextConfiguration({"classpath:spring.xml", "classpath:spr-db.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/initDB.sql")
public class UserServiceTestLL {

    @Autowired
    private UserService service;

    @Test
    public void getAll() throws Exception {
        List<User> users = service.getAll();
        Assert.assertEquals(3, users.size());
    }

    @Test
    @DirtiesContext
    public void delete() throws Exception {
        service.delete(3);
        Assert.assertEquals(2, service.getAll().size());
    }

    @Test(expected = NotFoundException.class)
    public void deleteNotFound() throws Exception {
        service.delete(999);
    }

    @Test
    public void save() throws Exception {
        service.save(USER_SAVE);
        User user = service.getById(4);
        Assert.assertEquals(USER_SAVE, user);
    }

    @Test(expected = NotFoundException.class)
    public void updateNotFound() throws Exception {
        service.update(UserTestData.USER_3);
    }

    @Test
    public void getById() throws Exception {
        User user = service.getById(2);
    }

}