package com.lgt.jdbc;

import java.sql.*;

public class JdbcCase {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //注册驱动
            DriverManager.registerDriver(new Driver());
            //Class.forName("com.mysql.jdbc.Driver");

            //建立连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "cloud");
            //connection = JDBCUtil.getConnection();
            //创建statement
            statement = connection.createStatement();

            String sql = "SELECT * from vendors";

            //执行查询，返回结果
            resultSet = statement.executeQuery(sql);

            //statement.executeUpdate()

            //进行操作
            while (resultSet.next()) {
                String vend_city = resultSet.getString("vend_city");
                System.out.println(vend_city);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            JDBCUtil.release(resultSet, statement, connection);
        }
    }
}
