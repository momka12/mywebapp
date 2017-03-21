package org.itstep.myWebApp.repository.Mock;

import org.itstep.myWebApp.model.Mail;
import org.itstep.myWebApp.repository.MailRepository;
import org.itstep.myWebApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MockMailRepository implements MailRepository {

    //    private Map<Integer, Mail> mails = new ConcurrentHashMap<>();
    private Map<Integer, Map<Integer, Mail>> mails = new ConcurrentHashMap<>();

    private AtomicInteger counter = new AtomicInteger(1);

    @Autowired
    private UserRepository users;

    {
        save(new Mail("first", "text first message", "user2", LocalDateTime.now(), 1));
        save(new Mail("second", "text second message", "user1", LocalDateTime.now(), 2));
        save(new Mail("third ", "text secondfsd f sd fds  message", "user1", LocalDateTime.now(), 2));
        save(new Mail("four", "text fsdfsdfsd second message", "user2", LocalDateTime.now(), 1));
        save(new Mail("five", "textdfsf second message", "user2", LocalDateTime.now(), 1));
    }

    public List<Mail> getAll(Integer userId) {
//        return mails.values().stream().filter(m -> m.getUserId().equals(userId)).collect(Collectors.toCollection(ArrayList::new));

        return new ArrayList<>(getMailUser(userId).values());
    }
    //
    public List<Mail> getAll(){
        List<Mail> allMails = new ArrayList<>();

        for(Map<Integer, Mail> m: mails.values()){
            allMails.addAll(m.values());
        }
        return allMails;
    }

    public void delete(Integer userId, Integer mailId) {
        getMailUser(userId).remove(mailId);
    }

    public void save(Mail mail) {
        if (mail.getId() == null) {
            mail.setId(counter.getAndIncrement());
        }

        Map<Integer, Mail> mails = getMailUser(mail.getUserId());
        mails.put(mail.getId(), mail);
    }

    private Map<Integer, Mail> getMailUser(Integer userId) {
        if(!mails.containsKey(userId))
            mails.put(userId, new ConcurrentHashMap<>());
        return mails.get(userId);
    }

    public Mail getOne(Integer userId, Integer id) {
        return getMailUser(userId).get(id);
    }
}