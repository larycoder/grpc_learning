package org.demo.stream;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class HelloStreamingServer{
    private static final Logger logger = Logger.getLogger(HelloStreamingServer.class.getName());

    public static void main(String[] args) throws InterruptedException, IOException{
        ManualFlowControlServerGrpc.ManualFlowControlServerImplBase svc = new ManualFlowControlServerGrpc.ManualFlowControlServerImplBase(){
            @Override
            public StreamObserver<HelloRequest> sayHelloStreaming(final StreamObserver<HelloReply> responseObserver){
                final ServerCallStreamObserver<HelloReply> serverCallStreamObserver = (ServerCallStreamObserver<HelloReply>) responseObserver;
                serverCallStreamObserver.disableAutoRequest();

                class OnReadyHandler implements Runnable{
                    private boolean wasReady = false;

                    @Override
                    public void run(){
                        if(serverCallStreamObserver.isReady() && !wasReady){
                            wasReady = true;
                            logger.info("READY");
                            serverCallStreamObserver.request(1);
                        }
                    }
                }
                final OnReadyHandler onReadyHandler = new OnReadyHandler();
                serverCallStreamObserver.setOnReadyHandler(onReadyHandler);

                return new StreamObserver<HelloRequest>(){
                    @Override
                    public void onNext(HelloRequest request){
                        try{
                            String name = request.getName();
                            logger.info("--> " + name);

                            // Thread.sleep(2);

                            String message = "Hello " + name;
                            logger.info("<-- " + message);
                            HelloReply reply = HelloReply.newBuilder().setMessage(message).build();
                            responseObserver.onNext(reply);

                            if(serverCallStreamObserver.isReady()){
                                serverCallStreamObserver.request(1);
                            } else{
                                onReadyHandler.wasReady = false;
                            }
                        } catch(Throwable throwable){
                            throwable.printStackTrace();
                            responseObserver.onError(Status.UNKNOWN.withDescription("Error handling request").withCause(throwable).asException());
                        }
                    }

                    @Override
                    public void onError(Throwable t){
                        t.printStackTrace();
                        responseObserver.onCompleted();
                    }

                    @Override
                    public void onCompleted(){
                        logger.info("COMPLETED");
                        responseObserver.onCompleted();
                    }
                };
            }
        };

        final Server server = ServerBuilder
                                .forPort(50051)
                                .addService(svc)
                                .build()
                                .start();
        
        logger.info("Listening on " + server.getPort());

        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                System.err.println("Shutting down");
                try{
                    server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
                } catch(InterruptedException e){
                    e.printStackTrace(System.err);
                }
            }
        });

        server.awaitTermination();
    }
}