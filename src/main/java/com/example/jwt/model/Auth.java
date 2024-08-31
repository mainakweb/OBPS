package com.example.jwt.model;

import jakarta.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
public class Auth implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userType;
    private int departmentId;
    private int internalRoleId;

    private String username;
    private String password;
    private String name;
    private String vendorCode;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserType() {
        return userType;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getInternalRoleId() {
        return internalRoleId;
    }

    public void setInternalRoleId(int internalRoleId) {
        this.internalRoleId = internalRoleId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null; // Implement as needed, return user's authorities
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return vendorCode; // You can return username or vendorCode based on your requirements
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Implement as needed
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Implement as needed
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Implement as needed
    }

    @Override
    public boolean isEnabled() {
        return true; // Implement as needed
    }

}