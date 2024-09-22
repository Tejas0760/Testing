package com.link.service.impl;

import com.link.service.Deletepost;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Map;

public class DeletePostImpl implements Deletepost {

    @Autowired
    public RestTemplate restTemplate;

    String BaseUrl = "https://jsonplaceholder.typicode.com/";
    StringBuilder stringBuilder = new StringBuilder(BaseUrl);
    String delete = "posts/";

    @Override
    public Map<String, Object> delete(int id) {
        HttpEntity<Void> httpEntity = new HttpEntity<>(gethttpHeader());
        String url = stringBuilder.append(delete).append(id).toString();
        val response = restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, Map.class);
        return response.getBody();
    }

    private HttpHeaders gethttpHeader(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
}
