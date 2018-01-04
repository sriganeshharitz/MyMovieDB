package com.uttara.spring.beans;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Proxy(lazy = false)
public class Movie implements Comparable<Movie>{
    @Id
    private Long id;
    private String title;
    private String poster_path;
    private double vote_average;
    private double popularity;
    @Lob
    @Column(length = 1000)
    private String overview;
    private String release_date;
    private String user_review;
    @ManyToOne
    private WatchList watchList;

    public Movie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public WatchList getWatchList() {
        return watchList;
    }

    public void setWatchList(WatchList watchList) {
        this.watchList = watchList;
    }


    public int compareTo(Movie o) {
        return (int)(this.popularity-o.popularity);
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getUser_review() {
        return user_review;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (Double.compare(movie.vote_average, vote_average) != 0) return false;
        if (Double.compare(movie.popularity, popularity) != 0) return false;
        if (id != null ? !id.equals(movie.id) : movie.id != null) return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        if (poster_path != null ? !poster_path.equals(movie.poster_path) : movie.poster_path != null) return false;
        if (overview != null ? !overview.equals(movie.overview) : movie.overview != null) return false;
        if (release_date != null ? !release_date.equals(movie.release_date) : movie.release_date != null) return false;
        if (user_review != null ? !user_review.equals(movie.user_review) : movie.user_review != null) return false;
        return watchList != null ? watchList.equals(movie.watchList) : movie.watchList == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (poster_path != null ? poster_path.hashCode() : 0);
        temp = Double.doubleToLongBits(vote_average);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(popularity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (overview != null ? overview.hashCode() : 0);
        result = 31 * result + (release_date != null ? release_date.hashCode() : 0);
        result = 31 * result + (user_review != null ? user_review.hashCode() : 0);
        result = 31 * result + (watchList != null ? watchList.hashCode() : 0);
        return result;
    }

    public void setUser_review(String user_review) {
        this.user_review = user_review;

    }
}
