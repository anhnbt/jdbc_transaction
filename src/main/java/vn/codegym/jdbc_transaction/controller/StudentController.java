package vn.codegym.jdbc_transaction.controller;

import vn.codegym.jdbc_transaction.dao.StudentDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentController", urlPatterns = "/")
public class StudentController extends HttpServlet {
    private StudentDAO studentDAO;

    /**
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        studentDAO = new StudentDAO();
    }

    /**
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        String action = req.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "detail":
                int id = Integer.parseInt(req.getParameter("id"));
                dispatcher = req.getRequestDispatcher("students/detail.jsp");
                req.setAttribute("student", studentDAO.getStudentById(id));
                break;
            default:
                dispatcher = req.getRequestDispatcher("students/list.jsp");
                req.setAttribute("students", studentDAO.getStudents());

        }
        dispatcher.forward(req, resp);
    }
}
