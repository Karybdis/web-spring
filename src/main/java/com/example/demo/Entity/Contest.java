package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name="contest", schema="WebDB")
public class Contest
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="contest_name")
    private String contestName;
    private String information;

    public String getInformation()
    {
        return information;
    }

    public void setInformation(String information)
    {
        this.information = information;
    }

    public String getContestName()
    {
        return contestName;
    }

    public void setContestName(String contestName)
    {
        this.contestName = contestName;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
}
