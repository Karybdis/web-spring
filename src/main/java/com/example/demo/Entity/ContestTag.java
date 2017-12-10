package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name="contest_tag", schema="WebDB")
public class ContestTag
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="contest_id")
    private Long contestId;
    @Column(name="tag_id")
    private Long tagId;

    public Long getId()
    {
        return id;
    }

    public Long getTagId()
    {
        return tagId;
    }

    public void setTagId(Long tagId)
    {
        this.tagId = tagId;
    }

    public Long getContestId()
    {
        return contestId;
    }

    public void setContestId(Long contestId)
    {
        this.contestId = contestId;
    }
}
