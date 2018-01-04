package com.uttara.spring.beans;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Proxy(lazy = false)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String guest;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Lob
    @Column(length = 1000)
    private String comment;
    @ManyToOne
    private WatchList watchList;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", guest='" + guest + '\'' +
                ", date=" + date +
                ", comment='" + comment + '\'' +
                ", watchList=" + watchList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment1 = (Comment) o;

        if (id != null ? !id.equals(comment1.id) : comment1.id != null) return false;
        if (guest != null ? !guest.equals(comment1.guest) : comment1.guest != null) return false;
        if (date != null ? !date.equals(comment1.date) : comment1.date != null) return false;
        if (comment != null ? !comment.equals(comment1.comment) : comment1.comment != null) return false;
        return watchList != null ? watchList.equals(comment1.watchList) : comment1.watchList == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (guest != null ? guest.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (watchList != null ? watchList.hashCode() : 0);
        return result;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public WatchList getWatchList() {
        return watchList;
    }

    public void setWatchList(WatchList watchList) {
        this.watchList = watchList;
    }

    public Comment() {

    }
}
