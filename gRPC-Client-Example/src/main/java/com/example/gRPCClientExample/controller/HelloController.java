package com.example.gRPCClientExample.controller;

import com.example.gRPCClientExample.service.GrpcHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private GrpcHelloService grpcHelloService;

    @GetMapping()
    public String getHelloWorldMessage() {
        return "hello client";
    }

    @GetMapping("/grpc")
    public String getSayHelloWorld() {
        return grpcHelloService.sayHelloWithGrpc("username");
    }
}
