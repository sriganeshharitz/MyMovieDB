package com.uttara.spring.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieResults {
    private long page;
    private long total_results;
    private long total_pages;
    private List<Movie> results = new ArrayList<Movie>();

    @Override
    public String toString() {
        return "MovieResults{" +
                "page=" + page +
                ", total_results=" + total_results +
                ", total_pages=" + total_pages +
                ", results=" + results +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieResults that = (MovieResults) o;

        if (page != that.page) return false;
        if (total_results != that.total_results) return false;
        if (total_pages != that.total_pages) return false;
        return results != null ? results.equals(that.results) : that.results == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (page ^ (page >>> 32));
        result = 31 * result + (int) (total_results ^ (total_results >>> 32));
        result = 31 * result + (int) (total_pages ^ (total_pages >>> 32));
        result = 31 * result + (results != null ? results.hashCode() : 0);
        return result;
    }

    public long getPage() {

        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public long getTotal_results() {
        return total_results;
    }

    public void setTotal_results(long total_results) {
        this.total_results = total_results;
    }

    public long getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(long total_pages) {
        this.total_pages = total_pages;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public MovieResults() {

    }
}
