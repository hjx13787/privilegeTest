package privilegeTest;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {
    static final String fileName="c://privilegeTest.temp";
    String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String dbURL = "jdbc:sqlserver://192.168.1.45:1433; DatabaseName=privilegetest"; // 连接服务器和数据库sample

    String userName = "sa"; // 默认用户名

    String userPwd = "a123456"; // 密码

    Connection dbConn;
    Statement sql;

    ResultSet rs;

    public BaseDao() {
	try {
	    Class.forName(driverName);
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
    }

    public void test() {
	try {
	    open();
	    rs = sql.executeQuery("SELECT TOP 1000 * FROM [privilegetest].[dbo].[task] p left join card c on p.cid=c.cid");
	    while (rs.next()) {
		System.out.println(rs.getInt("upload"));
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    close(dbConn, sql, rs);
	}
    }

    public boolean init() {
	try {
	    File file=new File(fileName);
	    if(file.exists()){
		return true;
	    }
	    file.createNewFile();
	    String dbURL = "jdbc:sqlserver://192.168.1.45:1433; DatabaseName=master";
	    dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
	    sql = dbConn.createStatement();
	   sql.execute("create database privilegetest");
	   sql.execute("use privilegetest create table card(cid bigint PRIMARY KEY identity(1,1),identifire varchar(16),uploadno varchar(160),[deleteno] varchar(160),searchno varchar(160))");
	   sql.execute("use privilegetest create table [task](id bigint PRIMARY KEY identity(1,1),cid bigint,ip varchar(160),[statustype] varchar(160))");
	   sql.execute("ALTER TABLE [task] ADD CONSTRAINT main_id_cons FOREIGN KEY (cid) REFERENCES card ON DELETE CASCADE");
	   
	   return true;
	} catch (Exception e) {
	    e.printStackTrace();
	    return false;
	}
    }
     void save(String sql){
	try {
	    open();
	    this.sql.execute(sql);
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    close(dbConn, this.sql, rs);
	}
    }
    ResultSet find(String sql){
	try {
	    open();
	    rs=this.sql.executeQuery(sql);
	    return rs;
	} catch (Exception e) {
	    e.printStackTrace();
	    return null;
	} finally {
	    close(dbConn, this.sql, rs);
	}
    }
    
    void delete(String sql){
	try {
	    open();
	    this.sql.execute(sql);
	    
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    close(dbConn, this.sql, rs);
	}
    }
    void open() throws Exception{
	dbConn = DriverManager.getConnection(dbURL, userName, userPwd);

	    sql = dbConn.createStatement();
    }
    void close(Connection dbConn, Statement sql, ResultSet rs) {
	try {
	    if (dbConn != null) {
		dbConn.close();
	    }
	    if (sql != null) {
		sql.close();
	    }
	    if (rs != null) {
		rs.close();
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

    }

    public static void main(String[] args) {
	BaseDao dao=new BaseDao();
	dao.test();
    }
}
