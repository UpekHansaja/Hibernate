package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HibernateUtil;
import model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author upekhansaja
 */
@WebServlet(name = "SearchUser2", urlPatterns = {"/SearchUser2"})
public class SearchUser2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

//        SELECT * FROM `user`;
        Criteria criteria = session.createCriteria(User.class);
//        WHERE `name` = "Upek";
//        Criterion criterion1 = Restrictions.eq("name", "Upek");
//        criteria.add(criterion1);
//        AND `mobile` = "0781048585";
//        Criterion criterion2 = Restrictions.eq("mobile", "0781048585");
//        criteria.add(criterion2);

        Criterion criterionLike = Restrictions.like("mobile", "075", MatchMode.START);
        criteria.add(criterionLike);

        ArrayList<User> userList = (ArrayList<User>) criteria.list();

        for (User user : userList) {
            resp.getWriter().write(user.getName() + '\n');
        }

        session.close();

    }

}
