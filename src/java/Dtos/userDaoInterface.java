/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Dtos.user;
import java.util.ArrayList;

/**
 *
 * @author d00167267
 */
public interface userDaoInterface {
    
    
    public ArrayList<user> getAllUsers();
    public user checkLogin(String username, String password);
    public int addUser(user u);
     public user getUserByUsername(String username);
     public int deleteUser(String username);
}
