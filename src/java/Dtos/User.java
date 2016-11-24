/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

/**
 *
 * @author D00165309
 */
public class User {

    private int user_id;
    private String username;
    private String email;
    private String password;
    private String salt;
    private String first_name;
    private String last_name;
    private String address_line_1;
    private String address_line_2;
    private String state;
    private String country;
    private String post_code;
    private boolean admin;

    public User() {
        user_id = -1;
        username = null;
        email = null;
        password = null;
        salt = null;
        first_name = null;
        last_name = null;
        address_line_1 = null;
        address_line_2 = null;
        state = null;
        country = null;
        post_code = null;
        admin = false;

    }

    public User(int user_id, String username, String email, String password, 
            String salt, String first_name, String last_name, 
            String address_line_1, String address_line_2, String state, 
            String country, String post_code, boolean admin) 
    {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address_line_1 = address_line_1;
        this.address_line_2 = address_line_2;
        this.state = state;
        this.country = country;
        this.post_code = post_code;
        this.admin = admin;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress_line_1() {
        return address_line_1;
    }

    public void setAddress_line_1(String address_line_1) {
        this.address_line_1 = address_line_1;
    }

    public String getAddress_line_2() {
        return address_line_2;
    }

    public void setAddress_line_2(String address_line_2) {
        this.address_line_2 = address_line_2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    
    
}
