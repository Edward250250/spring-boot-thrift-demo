package com.zzqfsy.thrift.TSimpleServer;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import com.zzqfsy.thrift.hello.idl.HelloService;
import com.zzqfsy.thrift.hello.idl.HelloService.Client;

public class TSimpleClientDemo {

    public static void main(String[] args) {
        try {
            TTransport transport = new TFramedTransport(new TSocket("127.0.0.1", 8191, 5000));
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);

            Client client = new HelloService.Client(protocol);

            transport.open();

            System.out.println(client.HelloString("Neo3"));
            System.out.println(client.HelloBoolean(true));
            System.out.println(client.HelloInt(2));
            System.out.println(client.HelloNull());
            client.HelloVoid();
            transport.close();

        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
