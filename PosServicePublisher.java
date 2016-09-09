package service.endp;
import service.impl.PosServiceImpl;

import javax.xml.ws.Endpoint;

//Endpoint publisher
public class PosServicePublisher{

	public static void main(String[] args) {
		Endpoint.publish("http://0.0.0.0:9998/pos", new PosServiceImpl());
    }

}
