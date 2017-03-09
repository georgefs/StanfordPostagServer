package service.endp;
import service.impl.PosServiceImpl;
import service.impl.SegServiceImpl;

import javax.xml.ws.Endpoint;

//Endpoint publisher
@SpringBootApplication
public class PosServicePublisher{

	public static void main(String[] args) {
		Endpoint.publish("http://0.0.0.0:9998/pos", new PosServiceImpl());
		Endpoint.publish("http://0.0.0.0:9999/seg", new SegServiceImpl());
    }

}
