package org.itstep.myWebApp.service;

import org.itstep.myWebApp.UserTestData;
import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.util.NotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.util.List;

@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/spr-db.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/initDB.sql")
public class UserServiceTest {

    @Autowired
    private UserService service;

    @Test
    public void getAll() throws Exception {
        List<User> users = service.getAll();
        Assert.assertEquals(3, users.size());
    }

    @Test
    @Transactional
    public void delete() throws Exception {
        service.delete(1);
        Assert.assertEquals(2, service.getAll().size());
    }

    @Test(expected = NotFoundException.class)
    public void deleteNotFound() throws Exception {
        service.delete(0);
    }

    @Test
    @Transactional
    public void save() throws Exception {
        User save = service.save(UserTestData.USER_3);
        assert 3 == save.getId();
    }

    @Test(expected = NotFoundException.class)
    @Transactional
    public void updateNotFound() throws Exception {
        service.update(UserTestData.USER_4);
    }

    @Test
    public void getById() throws Exception {
        User user = service.getById(1);
    }

}