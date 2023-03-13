# JDBC

java database connecti



固定套路

1.引入相关库，注册驱动

Class.forName("com.mysql.cj.jdbc.Driver");



2.获取数据库连接

String url = "";

String user = "";

String name = "";

Connection conn =DriverManager.getConnection(url,user,name);



3.创建statement

Statement stmt =  conn.createStatement();



4.发送sql进行数据库查询，返回结果集

String sql = "select name from t_employee";

ResultSet rs = stmt.executeQuery(sql);



5.对结果集进行遍历操作，获取数据

while(rs.next()){

​	String name = rs.getString("name");

​	System.out.println(name);

}

6.关闭数据库

conn.close();