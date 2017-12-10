package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name="tag", schema="WebDB")
public class Tag
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="tag_name")
    private String tagName;

    public Long getId()
    {
        return id;
    }

    public String getTagName()
    {
        return tagName;
    }

    public void setTagName(String tagName)
    {
        this.tagName = tagName;
    }
}
