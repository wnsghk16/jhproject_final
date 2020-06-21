package com.jhproject.web.proxy;

import com.jhproject.web.owleague.*;
import com.jhproject.web.serviceImpls.OWTeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RestController
@RequestMapping
public class ProxyController{
    @Autowired
    Box<Object> box;
    @Autowired
    Crawler crawler;
    @Autowired
    Proxy pxy;
    @Autowired
    OWPlayerRepository owPlayerRepository;
    @Autowired
    OWTeamServiceImpl owTeamService;
    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/owplayer")
    public HashMap<String,Object> owplayers(){
        box.clear();
        if(owPlayerRepository.count() == 0){
            crawler.owPlayer();
        }
        List<OWPlayer> list = owPlayerRepository.findAll();
        pxy.print(owPlayerRepository.findAll().toString());
        box.put("list", list);
        box.put("count", list.size());
        return box.get();
    }
    @GetMapping("/owplayer/{team}")
    public OWPlayer owTeamplayer(@PathVariable String team){
        OWPlayer owPlayer = owPlayerRepository.findByTeam(team);
        System.out.println(owPlayer.toString());
        return owPlayer;
    }

    @GetMapping("/owteam")
    public HashMap<String,Object> owteams(){
        box.clear();
        List<OWTeamDTO> list = owTeamService.retriveAll();
        box.put("list", list);
        box.put("count", list.size());
        return box.get();
    }

    @GetMapping("/article")
    public HashMap<String,Object> articles(){
        box.clear();
        if(articleRepository.count() == 0){
            crawler.article();
        }
        List<Article> list = articleRepository.findAll();
        pxy.print(articleRepository.findAll().toString());
        box.put("list", list);
        box.put("count", list.size());
        return box.get();
    }

}
