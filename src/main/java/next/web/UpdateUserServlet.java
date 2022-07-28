package next.web;

import core.db.DataBase;
import next.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/update-act")
public class UpdateUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(UpdateUserServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User updateUser = DataBase.findUserById(req.getParameter("originalUserId"));
        updateUser.setUserId(req.getParameter("userId"));
        updateUser.setName(req.getParameter("name"));
        updateUser.setEmail(req.getParameter("email"));
        updateUser.setPassword(req.getParameter("password"));
        log.debug("updateUser : {}", updateUser);
        resp.sendRedirect("/user/list");
    }
}
