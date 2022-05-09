package StudentDAO.Connect;
import java.sql.*;
public class databaseConnect{

    private final String DBDriver ="com.mysql.cj.jdbc.Driver";
    private final String DBURL ="jdbc:mysql://localhost:3306/school? useSSL=false&serverTimezone=UTC";
    private final String DBUSER ="root";
    private final String DBPASSWORD ="123456";
    private Connection conn = null;
    //构造器
    public databaseConnect(){

        try{
            Class.forName(DBDriver);
            conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
            System.out.println("连接My数据库成功！");
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("连接数据库失败");
        }
    }

    //获得连接
    public Connection getConnection(){
        return this.conn; }

    //关闭连接
    public void close() throws SQLException{
        this.conn.close(); }
}

