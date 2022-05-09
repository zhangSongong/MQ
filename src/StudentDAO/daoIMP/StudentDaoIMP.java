package StudentDAO.daoIMP;

import StudentDAO.Bean.Student;
import StudentDAO.Connect.databaseConnect;
import StudentDAO.Dao.StudentDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class StudentDaoIMP  implements StudentDao{
    private databaseConnect JDBCUtils;

    // 添加操作
    public void insert(Student s){
        String sql = "INSERT INTO student (id, name) values (?,?)";
        PreparedStatement pstmt = null;
        databaseConnect conn = null;
        //针对数据库的具体操作
        try{
            conn = new databaseConnect();

            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setLong(1,s.getID());
            //pstmt.setString(1,s.getID());
            pstmt.setString(2,s.getName());

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        }
        catch(Exception e){  }
    }

    public void update(Student s){
        String sql = "UPDATE student set name = ? where id = ?";
        PreparedStatement pstmt = null;
        databaseConnect conn = null;
        try{
            conn = new databaseConnect();
            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setString(1,s.getName());
            pstmt.setLong(2,s.getID());
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        }
        catch(Exception e){  }
    }

    public void delete(String id){
        PreparedStatement pstmt = null;
        databaseConnect conn = null;
        String sql = "DELETE FROM student where id = ?";
        try{
            conn = new databaseConnect();
            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(id));
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> findAll(){
        List<Student> students = new ArrayList();
        String sql = "select * from student";
        PreparedStatement pstmt = null;
        databaseConnect conn = null;
        ResultSet rs = null;
        try {
            conn = new databaseConnect();
            pstmt = conn.getConnection().prepareStatement(sql);

            //执行sql，返回结果集
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setID(rs.getInt(1));
                student.setName(rs.getString("name"));
                students.add(student);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
       return students;
    }

    public Student findByID(long id){
        Student student = null;
        String sql = "SELECT * from student where id = ?";
        PreparedStatement pstmt = null;
        databaseConnect conn = null;
        try{
            conn = new databaseConnect();
            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setInt(1, (int) id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
                student = new Student();
                student.setID(rs.getInt(1));
                student.setName(rs.getString("name"));
            }
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

}
