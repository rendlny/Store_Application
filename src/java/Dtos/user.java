/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

import java.util.Objects;

/**
 *
 * @author d00167267
 */
public class user {
    
    private int userId;
    private String username;
    private String email;
    private String password;
    private String salt;
    private String firstName;
    private String last_name;
    private String password_change_date;
    private int is_admin;

    public user() {
        username ="";
        email="";
        password="";
        salt ="";
        firstName="";
        last_name="";
        password_change_date="";
        is_admin=0;
        
    }

    public user(String username, String email, String password, String salt, String firstName, String last_name, String password_change_date, int is_admin) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.firstName = firstName;
        this.last_name = last_name;
        this.password_change_date = password_change_date;
        this.is_admin = is_admin;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPassword_change_date() {
        return password_change_date;
    }

    public int getIs_admin() {
        return is_admin;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPassword_change_date(String password_change_date) {
        this.password_change_date = password_change_date;
    }

    public void setIs_admin(int is_admin) {
        this.is_admin = is_admin;
    }

    @Override
    public String toString() {
        return "userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password + ", salt=" + salt + ", firstName=" + firstName + ", last_name=" + last_name + ", password_change_date=" + password_change_date + ", is_admin=" + is_admin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.username);
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final user other = (user) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
