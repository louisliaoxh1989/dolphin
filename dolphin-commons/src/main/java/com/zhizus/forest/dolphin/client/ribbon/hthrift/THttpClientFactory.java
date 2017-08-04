package com.zhizus.forest.dolphin.client.ribbon.hthrift;

import com.netflix.loadbalancer.Server;
import com.zhizus.forest.dolphin.client.ribbon.AbstractTClientFactory;
import org.apache.thrift.TServiceClient;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;

/**
 * Created by dempezheng on 2017/8/3.
 */
public class THttpClientFactory<T extends TServiceClient> extends AbstractTClientFactory<T> {


    public THttpClientFactory(SpringClientFactory clientFactory) {
        super(clientFactory);
    }

    @Override
    public TTransport makeTransport(Server server) throws TTransportException {
        return new THttpClient("http://" + server.getHost() + ":" + server.getPort() + "/sample");
    }
}