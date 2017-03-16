<<<<<<< 2a038c292baa434bfde90231d0c0d14ed1dc9527:src/main/java/org/itstep/myWebApp/web/MailServlet.java
//package org.itstep.myWebApp.web;
//
//import org.itstep.myWebApp.model.Mail;
//import org.itstep.myWebApp.model.User;
//import org.itstep.myWebApp.service.MailService;
//import org.itstep.myWebApp.service.UserService;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.support.WebApplicationContextUtils;
//
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.net.HttpCookie;
//import java.util.List;
//
//@WebServlet("/mail")
//public class MailServlet extends HttpServlet {
//
//    private MailService service;
//
//    private WebApplicationContext webContext;
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        webContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
//        service = webContext.getBean(MailService.class);
//    }
//
//    //
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Integer userId = Integer.valueOf(req.getParameter("userId"));
//        List<Mail> mails = service.getAll(userId);
//        req.setAttribute("mailList", mails);
//        resp.addCookie(new Cookie("userId", userId.toString()));
//        req.getRequestDispatcher("mailList.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//        if (action == null) action = "getAll";
//
//        switch (action) {
////            case "create":
////                req.setAttribute("user", new User("name", "lastname", "city", "email"));
////                req.getRequestDispatcher("editUser.jsp").forward(req, resp);
////                break;
////            case "delete":
////                Integer id = Integer.valueOf(req.getParameter("id"));
////                service.delete(id);
////                resp.sendRedirect("users");
////                break;
////            case "update":
////                id = Integer.valueOf(req.getParameter("id"));
////                User user = service.getById(id);
////                req.setAttribute("user", user);
////                req.getRequestDispatcher("editUser.jsp").forward(req, resp);
////                break;
////            case "getMails":
////                List<Mail> mails = service.getAll(Integer.valueOf(req.getParameter("userId")));
////                req.setAttribute("mailList", mails);
////                req.getRequestDispatcher("mailList.jsp").forward(req, resp);
////                break;
//            case "getAll":
//                List<Mail> mails = service.getAll();
//
//                req.setAttribute("mailList", mails);
//                req.getRequestDispatcher("mailList.jsp").forward(req, resp);
//                break;
//        }
//
//
//    }
//}
=======
package org.itstep.myWebApp.web.servlet;

import org.itstep.myWebApp.service.MailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mail")
public class MailServlet extends HttpServlet {

    private MailService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/my.html").forward(req,resp);
        resp.sendRedirect("my.html");
    }
}
>>>>>>> 9 patches:src/main/java/org/itstep/myWebApp/web/servlet/MailServlet.java
