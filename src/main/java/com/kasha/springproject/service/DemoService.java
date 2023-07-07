package com.kasha.springproject.service;

import com.kasha.springproject.NameRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemoService {

    List<String> names = new ArrayList<>();

    public List<String> getNames(){
        return names;
    }

    public void postNames(NameRequest request){

        names.add(request.getName());
    }

    public void updateNames(int id, NameRequest request){

        names.set(id, request.getName());
    }

    public void deleteNames(NameRequest request){

        names.remove(request.getName());
    }

}
