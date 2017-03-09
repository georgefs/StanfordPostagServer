package service.endp;
import service.impl.NerServiceImpl;

import javax.xml.ws.Endpoint;

//Endpoint publisher
public class NerServicePublisher{

	public static void main(String[] args) {
		Endpoint.publish("http://0.0.0.0:9996/ner", new NerServiceImpl());
    }

}
