package StudentDAO.test;
import StudentDAO.Bean.Student;
import StudentDAO.Dao.StudentDao;
import StudentDAO.daoIMP.StudentDaoIMP;
import java.util.*;

public class main {
    public static void main(String[] args) {
        StudentDao dao = new StudentDaoIMP();

        //1.查找所有
        System.out.println("查找所有:");
        List<Student> student1 = dao.findAll();
        for(Student s : student1){
            System.out.println(s);
        }

        //2.插入信息
        System.out.println("插入信息");
        Student stu1 = new Student();
        stu1.setID(10004);
        stu1.setName("小茗");
        dao.insert(stu1);
        ArrayList<Student> student3 = (ArrayList<Student>) dao.findAll();
        for(Student s : student3){
            System.out.println(s);
        }

        //3.按照id查找
        System.out.println("按照id查找:");
        System.out.println(dao.findByID(1910300118));

        //4.删除信息
        System.out.println("按照学号删除:");
        dao.delete("1910300119");
        ArrayList<Student> student2 = (ArrayList<Student>) dao.findAll();
        for(Student s : student2){
            System.out.println(s);
        }

        //5.修改信息
        System.out.println("修改信息");
        Student stu2 = new Student();
        stu2.setID(10002);
        stu2.setName("小亮");
        dao.update(stu2);
        ArrayList<Student> student4 = (ArrayList<Student>) dao.findAll();
        for(Student s : student4){
            System.out.println(s);
        }
    }
}
