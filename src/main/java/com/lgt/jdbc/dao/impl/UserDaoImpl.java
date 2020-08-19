package com.lgt.jdbc.dao.impl;

import com.lgt.jdbc.JDBCUtil;
import com.lgt.jdbc.dao.UserDao;

import java.sql.*;

public class UserDaoImpl implements UserDao {

    @Override
    public void login(String name, String password) {
        Connection connection;
        Statement st = null;
        ResultSet rs =  null;

        connection = JDBCUtil.getConnection();
        String sql = " SELECT * from customers where cust_zip=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);

            rs = preparedStatement.executeQuery();
            if(rs.next()) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.login("42222","1");
    }
}
