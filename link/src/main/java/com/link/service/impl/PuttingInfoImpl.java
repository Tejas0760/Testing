package com.link.service.impl;

import com.link.service.Puttinginfo;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Map;

@Service
public class PuttingInfoImpl implements Puttinginfo {

    @Autowired
    private RestTemplate restTemplate;

    String BaseUrl = "https://jsonplaceholder.typicode.com/";
    StringBuilder stringBuilder = new StringBuilder(BaseUrl);
    String Insert = "posts";

    @Override
    public Map<String, Object> insert(Map<String, Object> payload){
        HttpEntity<Map> httpEntity = new HttpEntity<>(payload, gethttpHeader());
        String url = stringBuilder.append(Insert).toString();
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
