package com.example.demo.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Crawler extends Proxy {
    @Autowired Printer printer;
    public List<?> crawling(String url){
        printer.accept("크롤링 대상 URL: " + url);
        var map = hashmap();
        return null;
    }
}
