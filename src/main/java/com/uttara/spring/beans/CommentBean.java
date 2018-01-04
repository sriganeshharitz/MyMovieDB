package com.uttara.spring.beans;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class CommentBean {
    @NotNull
    @NotBlank
    private String guest;
    @NotNull
    @NotBlank
    private String comment;
    private Date date;
    private Long watchListId;

    public CommentBean() {
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentBean that = (CommentBean) o;

        if (guest != null ? !guest.equals(that.guest) : that.guest != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        return watchListId != null ? watchListId.equals(that.watchListId) : that.watchListId == null;
    }

    @Override
    public int hashCode() {
        int result = guest != null ? guest.hashCode() : 0;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (watchListId != null ? watchListId.hashCode() : 0);
        return result;
    }

    public String getGuest() {

        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getWatchListId() {
        return watchListId;
    }

    public void setWatchListId(Long watchListId) {
        this.watchListId = watchListId;
    }
}
