package org.itstep.myWebApp.repository.datajpa;

import org.itstep.myWebApp.model.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by student on 30.03.2017.
 */
public interface ProxyRepoMail extends JpaRepository<Mail, Integer> {
}
