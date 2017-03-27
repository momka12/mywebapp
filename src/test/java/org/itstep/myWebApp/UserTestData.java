package org.itstep.myWebApp;

import org.itstep.myWebApp.model.Mail;
import org.itstep.myWebApp.model.User;

import java.time.LocalDateTime;

public class UserTestData {

    public static final User USER_1 = new User(1, "petrik", "ivanov", "dnepr", "petr@mail.com");
    public static final User USER_2 = new User(2, "maria", "forma", "odessa", "maria@mail.com");
    public static final User USER_3 = new User(3, "romka", "fich", "dnepr", "romka@mail.com");
    public static final User USER_4 = new User(55, "111", "111", "111", "111@asd.com");
    public static final User USER_5 = new User("111", "111", "111", "2111@asd.com");

    public static final Mail MAIL_1 = new Mail(5, "m", "t", "to", LocalDateTime.now(), 16);

}
