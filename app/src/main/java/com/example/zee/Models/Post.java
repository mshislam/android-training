package com.example.zee.Models;

public class Post
{
    private String likes_count;

    private String conference_id;

    private String updated_at;

    private String user_id;

    private String commentsCount;

    private String isLiked;

    private String photo;

    private String created_at;

    private String id;

    private String text;

    private String isApproved;

    private String deleted_at;

    public String getLikes_count ()
    {
        return likes_count;
    }

    public void setLikes_count (String likes_count)
    {
        this.likes_count = likes_count;
    }

    public String getConference_id ()
    {
        return conference_id;
    }

    public void setConference_id (String conference_id)
    {
        this.conference_id = conference_id;
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

    public String getCommentsCount ()
    {
        return commentsCount;
    }

    public void setCommentsCount (String commentsCount)
    {
        this.commentsCount = commentsCount;
    }

    public String getIsLiked ()
    {
        return isLiked;
    }

    public void setIsLiked (String isLiked)
    {
        this.isLiked = isLiked;
    }

    public String getPhoto ()
    {
        return photo;
    }

    public void setPhoto (String photo)
    {
        this.photo = photo;
    }

    public String getCreated_at ()
    {
        return created_at;
    }

    public void setCreated_at (String created_at)
    {
        this.created_at = created_at;
    }

    public String getId()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getText()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    public String getIsApproved()
    {
        return isApproved;
    }

    public void setIsApproved (String isApproved)
    {
        this.isApproved = isApproved;
    }

    public String getDeleted_at()
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
        return "ClassPojo [likes_count = "+likes_count+", conference_id = "+conference_id+", updated_at = "+updated_at+", user_id = "+user_id+", commentsCount = "+commentsCount+", isLiked = "+isLiked+", photo = "+photo+", created_at = "+created_at+", id = "+id+", text = "+text+", isApproved = "+isApproved+", deleted_at = "+deleted_at+"]";
    }
}
