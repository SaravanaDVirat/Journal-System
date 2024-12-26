package com.example.journal.system.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="journey")
public class journey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Long id;
    @Column(name="username")
    public String  username;
    @Column(name="email")
    public String  email;
    @Column(name="source")
    public String  source;
    @Column(name="destination")
    public String destination;

    public Long getId() {
        return id;
    }

    public void setId(Long id)
    {
        this.id=id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username)
    {
        this.username=username;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email)
    {
        this.email=email;
    }
    public String getSource() {
        return source;
    }

    public void setSource(String source)
    {
        this.source=source;
    }
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination)
    {
        this.destination=destination;
    }
}
