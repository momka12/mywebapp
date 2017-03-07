package org.itstep.myWebApp.web;

import org.itstep.myWebApp.model.User;
import org.itstep.myWebApp.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {

    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action == null) {
            List<User> users = service.getAll();
            req.setAttribute("userList", users);
            req.getRequestDispatcher("userList.jsp").forward(req, resp);
        } else if (action.equals("delete")) {
            Integer id = Integer.valueOf(req.getParameter("id"));
            service.delete(id);
            resp.sendRedirect("users");
        } else if (action.equals("create")) {
            req.setAttribute("user", new User("name", "lastname", "city", "email"));
            req.getRequestDispatcher("editUser.jsp").forward(req, resp);
        } else if (action.equals("update")) {
            Integer id = Integer.valueOf(req.getParameter("id"));
            User user = service.getUser(id);
            req.setAttribute("user", user);
            req.getRequestDispatcher("editUser.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");
        String city = req.getParameter("city");
        String email = req.getParameter("email");
        User user = new User(name, lastname, city, email);
        if (id.isEmpty() || id == null) {
            service.add(user);
        } else {
            Integer idd = Integer.valueOf(id);
            service.updateUser(idd, user);
        }
        resp.sendRedirect("users");
    }
}
