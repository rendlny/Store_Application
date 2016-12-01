/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.User;
import java.util.ArrayList;

/**
 *
 * @author d00167267
 */
public interface UserDaoInterface {

    public ArrayList<User> getAllUsers();
    public User checkLogin(String username, String password);
    public int addUser(User u);
    public User getUserByUsername(String username);
    public int deleteUser(String username);
}
