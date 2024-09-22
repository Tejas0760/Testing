package com.link.controller;

import com.link.service.Deletepost;
import com.link.service.Puttinginfo;
import com.link.service.Upadatepost;
import com.link.service.fetching;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    private Deletepost deletepost;

    @Autowired
    private Upadatepost upadatepost;

    @Autowired
    private Puttinginfo puttinginfo;

    @Autowired
    private fetching Fetching;

    @GetMapping("/getPost")
    List<Map<String, Object>> getAllPosts(){
        return Fetching.list();
    }

    @GetMapping("/getPostById/{id}")
    Map<String, Object> getbyId(@PathVariable int id){
        return Fetching.ById(id);
    }

    @PostMapping("/posts")
    Map<String, Object> insert(@RequestBody Map<String, Object> payload){
        return puttinginfo.insert(payload);
    }

    @PutMapping("/posts/{id}")
    Map<String, Object> update(@RequestBody Map<String, Object> payload, @PathVariable int id){
        return upadatepost.update(payload, id);
    }

    @DeleteMapping("/delete/{id}")
    Map<String, Object> delete(@PathVariable int id){
        return deletepost.delete(id);
    }
}
