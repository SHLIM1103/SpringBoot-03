package com.example.demo.controllers;

import java.util.List;
import java.util.Map;

import com.example.demo.Services.ArticleService;
import com.example.demo.domains.ArticleDTO;
import com.example.demo.utils.Printer;
import com.example.demo.utils.Proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        map.put("message", px.message(articleService.write(article)));
        return map;
    }

    @GetMapping("/articles")
    public Map<?, ?> list(){
        var map = px.hashmap();
        List<ArticleDTO> l = articleService.list();
        System.out.println("목록 수: "+l.size());
        map.put("list", l);
        map.put("count", articleService.count());
        return map;
    }

    @GetMapping("/articles/{artNum}")
    public ArticleDTO detail(@PathVariable String artNum){
        return articleService.getArticleById(artNum);
    }

    @GetMapping("/articles/crawling/{site}")
    public Map<?,?> crawling(@PathVariable String site){
        var map = px.hashmap();
        var count = articleService.count();
        if(count == 0){
            switch(site){
                case "bugs":
                map.put("count", articleService.crawling("https://music.bugs.co.kr/recomreview?&order=listorder&page=2"));
                break;
            }
        }else{
            map.put("count", count);
        }
        return map;
    }

    @GetMapping("/articles/{artNum}/count")
    public Map<?, ?> increaseCount(@PathVariable String artNum){
        var map = px.hashmap();
        map.put("message", px.message(articleService.increaseCount(artNum)));
        return map;
    }

    @PutMapping("/articles")
    public Map<?, ?> update(@RequestBody ArticleDTO article){
        var map = px.hashmap();
        printer.accept("수정할 데이터: " + article.toString());
        map.put("message", px.message(articleService.update(article)));
        return map;
    }

    @DeleteMapping("/articles")
    public Map<?, ?> delete(@RequestBody ArticleDTO article){
        var map = px.hashmap();
        printer.accept("삭제할 데이터 ID: " + article.getArtNum());
        map.put("message", px.message(articleService.delete(article)));
        return map;
    }
}