package com.zzqfsy.thrift.hello.idl.impl;

import com.zzqfsy.thrift.hello.idl.HelloService;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloServiceImpl implements HelloService.Iface{
    private Logger logger = LoggerFactory.getLogger(HelloService.class);

    @Override
    public String HelloString(String para) throws TException {
        logger.info("HelloString:" + para);
        return "success";
    }

    @Override
    public int HelloInt(int para) throws TException {
        logger.info("HelloInt:" + para);
        return 1;
    }

    @Override
    public boolean HelloBoolean(boolean para) throws TException {
        logger.info("HelloBoolean:" + para);
        return true;
    }

    @Override
    public void HelloVoid() throws TException {
        logger.info("HelloVoid:");
    }

    @Override
    public String HelloNull() throws TException {
        logger.info("HelloNull:");
        return "sucess";
    }
}
