// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: hello_stream.proto

package org.demo.stream;

public final class HelloStream {
  private HelloStream() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_demo_stream_HelloRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_demo_stream_HelloRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_demo_stream_HelloReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_demo_stream_HelloReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022hello_stream.proto\022\017org.demo.stream\"\034\n" +
      "\014HelloRequest\022\014\n\004name\030\001 \001(\t\"\035\n\nHelloRepl" +
      "y\022\017\n\007message\030\001 \001(\t2p\n\027ManualFlowControlS" +
      "erver\022U\n\021SayHelloStreaming\022\035.org.demo.st" +
      "ream.HelloRequest\032\033.org.demo.stream.Hell" +
      "oReply\"\000(\0010\001B\002P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_org_demo_stream_HelloRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_org_demo_stream_HelloRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_demo_stream_HelloRequest_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_org_demo_stream_HelloReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_org_demo_stream_HelloReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_demo_stream_HelloReply_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}