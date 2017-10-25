package com.zzqfsy.thrift.TSimpleServer;

import com.zzqfsy.thrift.hello.idl.HelloService;
import com.zzqfsy.thrift.hello.idl.impl.HelloServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.TTransportFactory;

public class TSimpleServerDemo {
    public void startServer() {
        try {
            System.out.println("Starting Thrift Server......");

            TProcessor processor = new HelloService.Processor<HelloService.Iface>(new HelloServiceImpl());

            TServerSocket serverTransport = new TServerSocket(8191);

            TTransportFactory transportFactory = new TFramedTransport.Factory();

            Factory factory = new TBinaryProtocol.Factory();

            TServer.Args tArgs = new TServer.Args(serverTransport);
            tArgs.protocolFactory(factory);
            tArgs.transportFactory(transportFactory);
            tArgs.processor(processor);

            // 简单的单线程服务模型，一般用于测试
            TServer server = new TSimpleServer(tArgs);

            server.serve();

        } catch (TTransportException e) {
            System.out.println("Starting Thrift Server......Error!!!");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        TSimpleServerDemo server = new TSimpleServerDemo();
        server.startServer();
    }
}
