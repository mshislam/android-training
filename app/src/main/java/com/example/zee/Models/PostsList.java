package com.example.zee.Models;

public class PostsList
{
    private Post post;

    private User user;

    public Post getPost ()
    {
        return post;
    }

    public void setPost (Post post)
    {
        this.post = post;
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
        return "ClassPojo [post = "+post+", user = "+user+"]";
    }
}