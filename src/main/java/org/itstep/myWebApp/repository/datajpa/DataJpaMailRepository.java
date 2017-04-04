package org.itstep.myWebApp.repository.datajpa;

import org.itstep.myWebApp.model.Mail;
import org.itstep.myWebApp.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaMailRepository implements MailRepository {

    @Autowired
    private ProxyRepoMail data;

    @Override
    public List getAll(Integer userId) {
        return data.findAll();
    }

    @Override
    public Mail getById(Integer userId, Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer userId, Integer id) {
        return false;
    }

    @Override
    public Mail save(Mail mail) {
        return null;
    }
}
