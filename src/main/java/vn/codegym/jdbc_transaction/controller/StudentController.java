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
        RequestDispatcher dispatcher = req.getRequestDispatcher("students/list.jsp");
        req.setAttribute("students", studentDAO.getStudents());
        dispatcher.forward(req, resp);
    }
}
