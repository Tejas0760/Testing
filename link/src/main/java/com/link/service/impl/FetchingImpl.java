package com.link.service.impl;

import com.link.service.fetching;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class FetchingImpl implements fetching{

    String BaseUrl = "https://jsonplaceholder.typicode.com/";

    StringBuilder stringBuilder = new StringBuilder(BaseUrl);

    String post = "posts";

    String idofuser = "posts/";
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Map<String, Object>> list(){
        HttpEntity<Void> httpEntity = new HttpEntity<>(gethttpHeader());
        String url = stringBuilder.append(post).toString();
        val response =  restTemplate.exchange(url, HttpMethod.GET, httpEntity, List.class);
        return response.getBody();
    }

    @Override
    public Map<String, Object> ById(int id) {
        HttpEntity<Void> httpEntity = new HttpEntity<>(gethttpHeader());
        String url = stringBuilder.append(idofuser).append(id).toString();
        val response =  restTemplate.exchange(url, HttpMethod.GET, httpEntity, Map.class);
        return response.getBody();
    }


    private HttpHeaders gethttpHeader(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }

}
