package org.itstep.myWebApp.service;


import org.itstep.myWebApp.model.Mail;
import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService {

    @Autowired
    private MailRepository repository;

    public List<Mail> getAll(Integer userId) {
        return repository.getAll(userId);
    }

    public Mail getById(Integer userId, Integer id){
        return repository.getById(userId, id);
    }

    public void delete(Integer userId, Integer mailId) {
        repository.delete(userId, mailId);
    }

    public Mail save(Mail mail) {
        return repository.save(mail);
    }

}
