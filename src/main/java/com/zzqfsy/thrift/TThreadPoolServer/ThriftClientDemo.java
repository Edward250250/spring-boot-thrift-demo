package com.zzqfsy.thrift.TThreadPoolServer;

import com.zzqfsy.thrift.hello.idl.HelloService.Client;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class ThriftClientDemo {

    public static void main(String[] args) {
        try {
            TTransport transport = new TFramedTransport(new TSocket("127.0.0.1", 8191, 3000));
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);

            Client client = new Client(protocol);

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
