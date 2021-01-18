package com.example.gRPCServerExample.service;

import gRPC.proto.hello.HelloRequestProto;
import gRPC.proto.hello.HelloResponseProto;
import gRPC.proto.hello.HelloServiceProtoGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcHelloService extends HelloServiceProtoGrpc.HelloServiceProtoImplBase {


    @Override
    public void hello(HelloRequestProto request, StreamObserver<HelloResponseProto> responseObserver) {
        String keyword = request.getKeyword();
        // business logic
        if ("username".equals(keyword)) {
            System.out.println("SUCCESS MESSAGE");
        } else {
            System.out.println("FAILURE MESSAGE");
        }
        HelloResponseProto.Builder builder = HelloResponseProto.newBuilder();
        builder.setKeyword(keyword + "IN SERVICE");
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();

//        super.hello(request, responseObserver);
    }
}
