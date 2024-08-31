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
@WebServlet(name = "SaveUser", urlPatterns = {"/SaveUser"})
public class SaveUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        User user = new User();

//        INSERT
        user.setName("Upek");
        user.setMobile("0781048585");

        session.save(user);

//        UPDATE
//        user.setId(1);
//        user.setName("Chanthuli");
//        user.setMobile("0771234567");

//        session.update(user);
        
        
        session.beginTransaction().commit();

        session.close();

    }

}
