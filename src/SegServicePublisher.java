package service.endp;
import service.impl.SegServiceImpl;

import javax.xml.ws.Endpoint;

//Endpoint publisher
public class SegServicePublisher{

	public static void main(String[] args) {
		Endpoint.publish("http://0.0.0.0:9999/seg", new SegServiceImpl());
    }

}
