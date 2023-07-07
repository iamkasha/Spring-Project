package com.kasha.springproject.controller;

import com.kasha.springproject.NameRequest;
import com.kasha.springproject.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private DemoService name;

    public DemoController(DemoService name) {
        this.name = name;
    }

    @GetMapping("/names")
    public String getNames(){
        return name.getNames().toString();
    }

    @PostMapping("/names")
    public void postNames(@RequestBody NameRequest request){
        name.postNames(request);
    }

    @PutMapping("/names/{id}")
    public void updateNames(@PathVariable int id, @RequestBody NameRequest request){
        name.updateNames(id, request);
    }

    @DeleteMapping
    public void deleteNames(@RequestBody NameRequest request){

        name.deleteNames(request);
    }

}
