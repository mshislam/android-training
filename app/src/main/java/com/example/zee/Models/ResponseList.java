package com.example.zee.Models;


public class ResponseList
{
    private Comment comment;

    private User user;

    public Comment getComment ()
    {
        return comment;
    }

    public void setComment (Comment comment)
    {
        this.comment = comment;
    }

    public User getUser ()
    {
        return user;
    }

    public void setUser (User user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [comment = "+comment+", user = "+user+"]";
    }
}