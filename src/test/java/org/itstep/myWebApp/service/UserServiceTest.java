package org.itstep.myWebApp.service;

import org.itstep.myWebApp.UserTestData;
import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.util.NotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/spr-db.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/initDB.sql")
public abstract class UserServiceTest {

    @Autowired
    private UserService service;

    @Before
    public void method(){
        service.evictCache();
    }

    @Test
    public void getAll() throws Exception {
        List<User> users = service.getAll();
        Assert.assertEquals(3, users.size());
        Assert.assertArrayEquals(new User[]{UserTestData.USER_1, UserTestData.USER_2, UserTestData.USER_3}, users.toArray());
    }

    @Test
    public void delete() throws Exception {
        service.delete(1);
        Assert.assertEquals(2, service.getAll().size());
    }

    @Test(expected = NotFoundException.class)
    public void deleteNotFound() throws Exception {
        service.delete(0);
    }

    @Test
    public void save() throws Exception {
        User save = service.save(UserTestData.USER_5);
        UserTestData.USER_5.setId(4);
        Assert.assertEquals(UserTestData.USER_5, save);
        Assert.assertEquals(4, service.getAll().size());
    }

    @Test(expected = NotFoundException.class)
    public void updateNotFound() throws Exception {
        service.update(UserTestData.USER_4);
    }

    @Test
    public void getById() throws Exception {
        User user = service.getById(1);
        Assert.assertEquals(UserTestData.USER_1, user);
    }

}
