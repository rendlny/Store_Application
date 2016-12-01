/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.user;
import Interfaces.userDaoInterface;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author d00167267
 */
public class userDao extends Dao implements userDaoInterface {

    public userDao(String databaseName) {
        super(databaseName);
    }

    public ArrayList<user> getAllUsers() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<user> users = new ArrayList();

        try {
            con = getConnection();

            String query = "Select * from users";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                user u = new user(
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("pass"),
                        rs.getString("salt"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("last_password_change"),
                        rs.getInt("is_admin"));
                users.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getAllMembers() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getAllMembers() method: " + e.getMessage());
            }
        }

        return users;
    }

    public user checkLogin(String username, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        user u = null;

        try {
            con = getConnection();

            String query = "Select * from users WHERE username = ? AND password = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();

            while (rs.next()) {
                u = new user(
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("pass"),
                        rs.getString("salt"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("last_password_change"),
                        rs.getInt("is_admin"));
            }
        } catch (SQLException e) {
            System.out.println("Exception occured in the getAllMembers() method: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getAllMembers() method: " + e.getMessage());
            }
        }
        return u;
    }

    public int addUser(user u) {
        Connection con = null;
        PreparedStatement ps = null;
        int rs = 0;
        try {
            con = getConnection();
            ps = con.prepareStatement("INSERT INTO users(username, email, pass, salt, first_name, last_name, last_password_change, is_admin) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            ps.setString(1, u.getUsername());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getSalt());
            ps.setString(5, u.getFirstName());
            ps.setString(6, u.getLast_name());
            ps.setString(7, u.getPassword_change_date());
            ps.setInt(8, u.getIs_admin());

            rs = ps.executeUpdate();

        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("Constraint Exception occurred: " + e.getMessage());
            rs = -1;
        } catch (SQLException se) {
            System.out.println("SQL Exception occurred");
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getAllProducts() method: " + e.getMessage());
            }
        }
        return rs;
    }

    public user getUserByUsername(String username) {
        ArrayList<user> u = this.getAllUsers();
        user u2 = null;
        for (int i = 0; i < u.size(); i++) {
            if (u.get(i).getUsername().equalsIgnoreCase(username)) {
                u2 = new user(
                        u.get(i).getUsername(),
                        u.get(i).getEmail(),
                        u.get(i).getPassword(),
                        u.get(i).getSalt(),
                        u.get(i).getFirstName(),
                        u.get(i).getLast_name(),
                        u.get(i).getPassword_change_date(),
                        u.get(i).getIs_admin());
            }

        }
        return u2;
    }
    
     public int deleteUser(String username)
    {
        user u = getUserByUsername(username);
        int rs = 0;
        
        if(u != null)
        {
            Connection con = null;
            PreparedStatement ps = null;

            try
            {
                con = getConnection();
                ps = con.prepareStatement("DELETE FROM users WHERE username = ? ");
                ps.setString(1, username);
            
                rs = ps.executeUpdate() ;
            
            }
            catch(SQLException se )
            {
                System.out.println( "SQL Exception occurred" );
                se.printStackTrace();
            }
            catch( Exception e )
            {
                e.printStackTrace();
            }
            finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the getAllProducts() method: " + e.getMessage());
            }
            }
        }
        return rs;
    }

}
