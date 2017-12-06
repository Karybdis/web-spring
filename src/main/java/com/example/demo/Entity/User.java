package com.example.demo.Entity;



import javax.persistence.*;


@Entity
@Table(name="userlogin", schema="WebDB")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String role;
    private int admin;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public int getAdmin()
    {
        return admin;
    }

    public void setAdmin(int admin)
    {
        this.admin = admin;
    }
}

