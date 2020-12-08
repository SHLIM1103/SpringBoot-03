package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.Services.ArticleService;
import com.example.demo.domains.ArticleDTO;
import com.example.demo.utils.Printer;
import com.example.demo.utils.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
        @Autowired Printer printer;
        @Autowired Proxy px;
        @Autowired ArticleService articleService;
        @PostMapping("/ariticles")
        public Map<?, ?> write(@RequestBody ArticleDTO article){
            var map = px.hashmap();
            int result = articleService.write(article);
            map.put("message", px.message(result));
            return map;
        }

        @GetMapping("/articles")
        public Map<?, ?> list(){
            var map = px.hashmap();
            List<ArticleDTO> list = articleService.list();
            map.put("list", list);
            return map;
        }

        @GetMapping("/articles/crawling/{site}")
        public Map<?,?> crawling(@PathVariable String site){
            var map = px.hashmap();
            if(px.equals(site, "bugs")){
                int count = articleService.crawling("https://music.bugs.co.kr/recomreview?&order=listorder&page=2");
                map.put("count", count);
            }
            return map;
        }
}
