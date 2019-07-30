package com.example.zee.Models;


public class User {
    private String image;

    private String role;

    private String name;

    private String company;

    private String title;

    private String userId;

    private String email;

    public String getImage()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public String getRole ()
    {
        return role;
    }

    public void setRole (String role)
    {
        this.role = role;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getCompany ()
    {
        return company;
    }

    public void setCompany (String company)
    {
        this.company = company;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getUserId ()
    {
        return userId;
    }

    public void setUserId (String userId)
    {
        this.userId = userId;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [image = "+image+", role = "+role+", name = "+name+", company = "+company+", title = "+title+", userId = "+userId+", email = "+email+"]";
    }
}