package org.itstep.myWebApp.repository;

import org.itstep.myWebApp.model.Mail;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MailRepository {

    List getAll(Integer userId);

    Mail getById(Integer userId, Integer id);

    boolean delete(Integer userId, Integer id);

    Mail save(Mail mail);

}
