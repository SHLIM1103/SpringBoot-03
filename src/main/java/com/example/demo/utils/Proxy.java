package com.example.demo.utils;

import org.springframework.stereotype.Component;

@Component
public class Proxy {
    public int integer(String t){
    }
    public String string(Object t){
    }
    public boolean equals(String t1,String t2){
    }
    public int random(int begin, int end){
        //  int r = (int)(Math.random() * 46) + 1; 1 ~ 45까지 랜덤수 
    }
    public int[] array(int size){
        // int[] arr = new int[size]
    }
    public Map<String, Object> hashmap(){
    }
    public String message(int i){
    }
    public String time(){
    }
    public File mkdir(String t, String u){
    }
    public File mkfile(File t, String u){
    }
    public List<String> list(){
    }
}
