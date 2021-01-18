package com.example.gRPCClientExample.service;

import gRPC.proto.hello.HelloRequestProto;
import gRPC.proto.hello.HelloResponseProto;
import gRPC.proto.hello.HelloServiceProtoGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GrpcHelloServiceImpl implements GrpcHelloService {

    @GrpcClient("profile")
    private HelloServiceProtoGrpc.HelloServiceProtoBlockingStub helloStub;

//    @Override
//    public String sayHelloWithGrpc(String keyword) {
//        HelloRequestProto requestProto = HelloRequestProto.newBuilder()
//                .setKeyword(keyword)
//                .build();
//
//        HelloResponseProto grpcResponse = helloStub.hello(requestProto);
//        return grpcResponse.getKeyword();
//    }

    @Override
    public String sayHelloWithGrpc(String keyword) {

//        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9191).usePlaintext().build();
//
//        HelloServiceProtoGrpc.HelloServiceProtoBlockingStub helloStub = HelloServiceProtoGrpc.newBlockingStub(channel);

        HelloRequestProto requestProto = HelloRequestProto.newBuilder()
                .setKeyword(keyword)
                .build();

//        HelloResponseProto response = helloStub.hello(requestProto);

        HelloResponseProto response = helloStub.hello(requestProto);
        return response.getKeyword();
    }
}
