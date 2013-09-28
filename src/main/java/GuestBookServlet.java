import my.guestbook.GuestBookControllerImpl;
import my.guestbook.Record;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "GuestBook", urlPatterns = {"/guestbook", "/post"})

public class GuestBookServlet extends HttpServlet {
    GuestBookControllerImpl guestBookController;
    @Resource(name = "jdbc/guestbookDS")
    private DataSource ds;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        guestBookController = new GuestBookControllerImpl(ds);
        try {
            List<Record> mList = guestBookController.getRecords();
            req.setAttribute("records", mList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/WEB-INF/records.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        guestBookController = new GuestBookControllerImpl(ds);
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String message = req.getParameter("message");
        if (message != null) {
            guestBookController.addRecord(message);
            resp.sendRedirect("/guestbook");
        }
        //  try {
        //    req.getRequestDispatcher("/guestbook").forward(req, resp);
        //} catch (ServletException e) {
        //   e.printStackTrace();
        //} catch (IOException e) {
        //  e.printStackTrace();
        //}
    }
}