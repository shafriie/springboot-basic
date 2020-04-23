package com.safri.latihanSpringBoot.Controllers;

import com.safri.latihanSpringBoot.Entity.UserName;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class HelloWorldController {

    @GetMapping("HelloWorld")
    public String HelloWorld(){
        return "Hello World";
    }

    @GetMapping("HelloWorld/{name}")
    public String HelloWorldName(@PathVariable(value="name") String name){
        return "Hello " + name;
    }

    @PostMapping("HelloWorld")
    public String postHelloWorld(@RequestParam(name="username") String username){
        return "Hello " + username;
    }

    /* menggunakan entity untuk mengolah data nya */
    @PostMapping("HelloWorldUser")
    public UserName postHelloWorldUser(@Valid @RequestBody UserName userName){
        return userName;
    }

}
