package vn.codegym.jdbc_transaction.dao;

import vn.codegym.jdbc_transaction.model.Student;
import vn.codegym.jdbc_transaction.utils.DBConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        // try-with-resources to manage connection and statement
        try (Connection conn = DBConnection.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call getStudent()}")) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println("Co loi xay ra khi lay danh sach sinh vien");
            e.printStackTrace();
        }
        // logic call store procedure to get students
        return students;
    }

    public Student getStudentById(int id) {
        Student student = new Student();
        // try-with-resources to manage connection and statement
        try (Connection conn = DBConnection.getConnection();
             CallableStatement cstmt = conn.prepareCall("{call getStudentById(?)}")) {
            cstmt.setInt(1, id);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println("Co loi xay ra khi lay danh sach sinh vien");
            e.printStackTrace();
        }
        // logic call store procedure to get students
        return student;
    }

    // delete student by id
    // update student by id
}
