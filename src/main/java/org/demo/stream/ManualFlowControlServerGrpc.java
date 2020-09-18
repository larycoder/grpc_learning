package org.demo.stream;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.32.1)",
    comments = "Source: hello_stream.proto")
public final class ManualFlowControlServerGrpc {

  private ManualFlowControlServerGrpc() {}

  public static final String SERVICE_NAME = "org.demo.stream.ManualFlowControlServer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.demo.stream.HelloRequest,
      org.demo.stream.HelloReply> getSayHelloStreamingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHelloStreaming",
      requestType = org.demo.stream.HelloRequest.class,
      responseType = org.demo.stream.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<org.demo.stream.HelloRequest,
      org.demo.stream.HelloReply> getSayHelloStreamingMethod() {
    io.grpc.MethodDescriptor<org.demo.stream.HelloRequest, org.demo.stream.HelloReply> getSayHelloStreamingMethod;
    if ((getSayHelloStreamingMethod = ManualFlowControlServerGrpc.getSayHelloStreamingMethod) == null) {
      synchronized (ManualFlowControlServerGrpc.class) {
        if ((getSayHelloStreamingMethod = ManualFlowControlServerGrpc.getSayHelloStreamingMethod) == null) {
          ManualFlowControlServerGrpc.getSayHelloStreamingMethod = getSayHelloStreamingMethod =
              io.grpc.MethodDescriptor.<org.demo.stream.HelloRequest, org.demo.stream.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayHelloStreaming"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.demo.stream.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.demo.stream.HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new ManualFlowControlServerMethodDescriptorSupplier("SayHelloStreaming"))
              .build();
        }
      }
    }
    return getSayHelloStreamingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ManualFlowControlServerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ManualFlowControlServerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ManualFlowControlServerStub>() {
        @java.lang.Override
        public ManualFlowControlServerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ManualFlowControlServerStub(channel, callOptions);
        }
      };
    return ManualFlowControlServerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ManualFlowControlServerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ManualFlowControlServerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ManualFlowControlServerBlockingStub>() {
        @java.lang.Override
        public ManualFlowControlServerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ManualFlowControlServerBlockingStub(channel, callOptions);
        }
      };
    return ManualFlowControlServerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ManualFlowControlServerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ManualFlowControlServerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ManualFlowControlServerFutureStub>() {
        @java.lang.Override
        public ManualFlowControlServerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ManualFlowControlServerFutureStub(channel, callOptions);
        }
      };
    return ManualFlowControlServerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ManualFlowControlServerImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<org.demo.stream.HelloRequest> sayHelloStreaming(
        io.grpc.stub.StreamObserver<org.demo.stream.HelloReply> responseObserver) {
      return asyncUnimplementedStreamingCall(getSayHelloStreamingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloStreamingMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                org.demo.stream.HelloRequest,
                org.demo.stream.HelloReply>(
                  this, METHODID_SAY_HELLO_STREAMING)))
          .build();
    }
  }

  /**
   */
  public static final class ManualFlowControlServerStub extends io.grpc.stub.AbstractAsyncStub<ManualFlowControlServerStub> {
    private ManualFlowControlServerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManualFlowControlServerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ManualFlowControlServerStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<org.demo.stream.HelloRequest> sayHelloStreaming(
        io.grpc.stub.StreamObserver<org.demo.stream.HelloReply> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getSayHelloStreamingMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class ManualFlowControlServerBlockingStub extends io.grpc.stub.AbstractBlockingStub<ManualFlowControlServerBlockingStub> {
    private ManualFlowControlServerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManualFlowControlServerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ManualFlowControlServerBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class ManualFlowControlServerFutureStub extends io.grpc.stub.AbstractFutureStub<ManualFlowControlServerFutureStub> {
    private ManualFlowControlServerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManualFlowControlServerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ManualFlowControlServerFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SAY_HELLO_STREAMING = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ManualFlowControlServerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ManualFlowControlServerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO_STREAMING:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sayHelloStreaming(
              (io.grpc.stub.StreamObserver<org.demo.stream.HelloReply>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ManualFlowControlServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ManualFlowControlServerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.demo.stream.HelloStream.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ManualFlowControlServer");
    }
  }

  private static final class ManualFlowControlServerFileDescriptorSupplier
      extends ManualFlowControlServerBaseDescriptorSupplier {
    ManualFlowControlServerFileDescriptorSupplier() {}
  }

  private static final class ManualFlowControlServerMethodDescriptorSupplier
      extends ManualFlowControlServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ManualFlowControlServerMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ManualFlowControlServerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ManualFlowControlServerFileDescriptorSupplier())
              .addMethod(getSayHelloStreamingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
