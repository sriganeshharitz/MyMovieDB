package com.uttara.spring.services;

import com.uttara.spring.beans.MovieResults;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpService {

    public MovieResults searchMovie(String searchName) {
        RestTemplate restTemplate = new RestTemplate();
        MovieResults movieResults = restTemplate.getForObject(
                "https://api.themoviedb.org/3/search/movie?api_key=e6a8160611de425fcb03cb18cc10a4bd&language=en-US&query="+searchName+"&page=1&include_adult=false",
                MovieResults.class);
        return movieResults;
    }
}
