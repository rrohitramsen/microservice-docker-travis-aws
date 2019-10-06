package com.demo.authorservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AuthorController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/author-details/{authorName}", method = RequestMethod.GET)
    public String authorDetail(@PathVariable String authorName)
    {
        System.out.println("Getting author details for " + authorName);

        String response = restTemplate.exchange("http://book-service/books/{authorName}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, authorName).getBody();

        System.out.println("Response Received as " + response);

        return "Author Name -  " + authorName + " \n Book Details " + response;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
