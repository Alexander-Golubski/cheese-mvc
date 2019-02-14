package org.launchcode.cheesemvc.models;

import org.hibernate.validator.constraints.Range;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.constraints.*;
import java.util.Date;

public class User {

    @NotNull
    @Size(min=5, max=15)
    private String username;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Min(6)
    private String password;

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String aName){this.username=aName;}

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

    public User(){}

    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
        this.date = new Date();
    }
}
