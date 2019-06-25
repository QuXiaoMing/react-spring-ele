package com.shellming.eleservice.entity;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotEmpty;
//import java.util.ArrayList;
//import java.util.Collection;
import java.util.Date;
import java.util.List;

public class User {
    private String user_id;

    @NotEmpty(message = "用户名不能为空")
    private String user_name;

    @NotEmpty(message = "密码不能为空")
    private String password;

    @NotEmpty(message = "性别不能为空")
    private String sex;

    private String roles;

    private String type;

    private Date create_at;

    private Date update_at;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> auths = new ArrayList<>();
//        List<Role> roles = this.getRoles();
//        for (Role role : roles) {
//            auths.add(new SimpleGrantedAuthority(role.getName()));
//        }
//        return auths;
//    }
//
//    @Override
    public String getPassword() {
        return this.password;
    }
//
//    @Override
//    public String getUsername() {
//        return this.user_name;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id == null ? null : user_id.trim();
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }
}