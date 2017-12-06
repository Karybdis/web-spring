package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name="match_info", schema="WebDB")
public class Match
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String match_name;
    private String information;

    public String getInformation()
    {
        return information;
    }

    public void setInformation(String information)
    {
        this.information = information;
    }

    public String getMatch_name()
    {
        return match_name;
    }

    public void setMatch_name(String match_name)
    {
        this.match_name = match_name;
    }

    public Long getId()
    {
        return id;
    }
}
