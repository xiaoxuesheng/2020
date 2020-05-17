package com.hjj.toy.util.thrift.impl;


import com.hjj.toy.util.thrift.HelloWorld;
import org.apache.thrift.TException;

/**
 *
 */
public class HelloWorldImpl implements HelloWorld.Iface {
    @Override
    public String sayHello(String username) throws TException {
        return "hi,"+username;
    }
}
