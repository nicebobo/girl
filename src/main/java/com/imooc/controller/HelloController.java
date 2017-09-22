package com.imooc.controller;

import com.imooc.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

   @Autowired
   private GirlProperties girlProperties;

//    @RequestMapping(value = "/say", method = RequestMethod.GET)
    @GetMapping(value = "/say/{id}")
//    @PostMapping(value = "/say")
//    public String say(@RequestParam(value = "id", defaultValue = "0") Integer myid) {
    public String say(@PathVariable(value = "id",required = false) Integer myid) {
        return "Hello SpringBoot!<br/>girl's cupsize is " + girlProperties.getCupSize()
                + "<br/>girl's age is " + girlProperties.getAge()
                + "<br/>id:" + myid;

    }
}
