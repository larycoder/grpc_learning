package org.demo;

import io.grpc.Channel;
import io.grpc.StatusRuntimeException;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.concurrent.TimeUnit;

public class HelloClient{
    private static final Logger logger = Logger.getLogger(HelloClient.class.getName());

    private final GreeterGrpc.GreeterBlockingStub blockingStub;

    public HelloClient(Channel channel){
        blockingStub = GreeterGrpc.newBlockingStub(channel);
    }

    public void greet(String name){
        logger.info("Will try to greet " + name + "...");
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloReply response;
        try{
            response = blockingStub.sayHello(request);
        } catch(StatusRuntimeException e){
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
        logger.info("Greeting: " + response.getMessage());
    }

    public static void main(String[] args) throws Exception{
        String user = "world";

        String target = "localhost:50051";

        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                                    .usePlaintext()
                                    .build();
        try{
            HelloClient client = new HelloClient(channel);
            client.greet(user);
        } finally{
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}