/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dtn.service;

import com.dtn.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Nguyen0210
 */
public interface UserService extends UserDetailsService{
    User getUserByUsername(String username);
    boolean addUser(User user);
}
