package org.itstep.myWebApp.repository;

import org.itstep.myWebApp.model.Mail;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by student on 21.03.2017.
 */
public interface MailRepository {

    List<Mail> getAll(Integer userId);

    List<Mail> getAll();

    void delete(Integer userId, Integer mailId);

    void save(Mail mail);

    Mail getOne(Integer userId, Integer id);
}
