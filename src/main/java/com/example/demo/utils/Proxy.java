package com.example.demo.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.stereotype.Component;

@Component("px")
public class Proxy {
    public int integer(String t){
        Function<String, Integer> f = Integer::parseInt;
        return f.apply(t);
    }
    public String string(Object t){
        Function<Object, String> f = String::valueOf;
        return f.apply(t);
    }
    public boolean equals(String t1, String t2){
        BiPredicate<String, String> p = String::equals;
        return p.test(t1, t2);
    }
    public int random(int begin, int end){
       BiFunction<Integer, Integer, Integer> f = (t, u) -> (int)(Math.random() * (u - t)) + t;
        return f.apply(begin, end);
    }
    public int[] array(int size){
        Function<Integer, int[]> f = int[]::new ;
        return f.apply(size);
    }
    public List<String> list(){
        Supplier<List<String>> s = ArrayList::new;
        return s.get();
    }
    public Map<String, Object> hashmap(){
        Supplier<Map<String, Object>> s = HashMap::new;;
        return s.get();
    }
    public String message(int i){
        return (i == 1) ? "SUCCESS" : "FAILURE";
    }
    public String time(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
    public File mkdir(String t, String u){
        BiFunction<String, String, File> f = File::new;
        return f.apply(t, u);
    }
    public File mkfile(File t, String u){
        BiFunction<File, String, File> f = File::new;
        return f.apply(t, u);
    }
}
