package com.example.zee.Models;


public class Comment
{
    private String post_id;

    private String updated_at;

    private String user_id;

    private String created_at;

    private String id;

    private String text;

    private String isApproved;

    private String deleted_at;

    public String getPost_id ()
    {
        return post_id;
    }

    public void setPost_id (String post_id)
    {
        this.post_id = post_id;
    }

    public String getUpdated_at ()
    {
        return updated_at;
    }

    public void setUpdated_at (String updated_at)
    {
        this.updated_at = updated_at;
    }

    public String getUser_id ()
    {
        return user_id;
    }

    public void setUser_id (String user_id)
    {
        this.user_id = user_id;
    }

    public String getCreated_at ()
    {
        return created_at;
    }

    public void setCreated_at (String created_at)
    {
        this.created_at = created_at;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    public String getIsApproved ()
    {
        return isApproved;
    }

    public void setIsApproved (String isApproved)
    {
        this.isApproved = isApproved;
    }

    public String getDeleted_at ()
{
    return deleted_at;
}

    public void setDeleted_at (String deleted_at)
    {
        this.deleted_at = deleted_at;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [post_id = "+post_id+", updated_at = "+updated_at+", user_id = "+user_id+", created_at = "+created_at+", id = "+id+", text = "+text+", isApproved = "+isApproved+", deleted_at = "+deleted_at+"]";
    }
}