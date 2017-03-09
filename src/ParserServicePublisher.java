package service.endp;
import service.impl.ParserServiceImpl;

import javax.xml.ws.Endpoint;

//Endpoint publisher
public class ParserServicePublisher{

	public static void main(String[] args) {
		Endpoint.publish("http://0.0.0.0:9997/parser", new ParserServiceImpl());
    }

}
