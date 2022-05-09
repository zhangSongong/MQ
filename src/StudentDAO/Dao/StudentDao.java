package StudentDAO.Dao;

import StudentDAO.Bean.Student;

import java.util.List;

public interface StudentDao {
    public void insert(Student s);
    public void update(Student s);
    public void delete(String iD);
    public Student findByID(long iD);
    public List<Student> findAll();
}
