package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HibernateUtil;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author upekhansaja
 */
@WebServlet(name = "UpdateUser1", urlPatterns = {"/UpdateUser1"})
public class UpdateUser1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        User user = (User) session.load(User.class, 3);

        user.setName("Mudith");
        user.setMobile("0712345678");

        session.update(user);

        session.beginTransaction().commit();

        session.close();

    }

}
