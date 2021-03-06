package org.demo;

import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;
import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import org.demo.*;

public class HelloServer{
    private static final Logger logger = Logger.getLogger(HelloServer.class.getName());

    private Server server;

    private void start() throws IOException{
        int port = 50051;
        server = ServerBuilder.forPort(port)
                    .addService(new GreeterImp())
                    .build()
                    .start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                try{
                    HelloServer.this.stop();
                } catch(InterruptedException e){
                    e.printStackTrace(System.err);
                }
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() throws InterruptedException{
        if(server != null){
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    private void blockUntilShutdown() throws InterruptedException{
        if(server != null){
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException{
        final HelloServer server = new HelloServer();
        server.start();
        server.blockUntilShutdown();
    }

    static class GreeterImp extends GreeterGrpc.GreeterImplBase{
        @Override
        public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver){
            HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + req.getName()).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
}