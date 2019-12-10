package uy.org.pmarket.shopping.integration.rest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.GZIPContentEncodingFilter;

import uy.org.pmarket.shopping.exception.IntegrationException;

public class HTTPPost {
	private int readTimeout;
	private int connectionTimeout;
	private Client client;
	private String url;
		
	public HTTPPost(String url, int readTimeout, int connectionTimeout) {
		super();
		this.client = Client.create();
		this.client.setReadTimeout(readTimeout);
	    this.client.setConnectTimeout(connectionTimeout);
	    client.addFilter(new GZIPContentEncodingFilter(false));
	    this.url = url;
	    
	}
	
	public HTTPPost connectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
		return this;
	}

	public HTTPPost readTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
		return this;
	}
	
	public String write(String text) {
		WebResource webResource = initClient();
		
		ClientResponse response = webResource.type("application/json")
		   .post(ClientResponse.class, text);
		
		return processAndCloseResponse(response);
	}
	
	public String writeWithHeader(String text, String tokenId) {
		WebResource webResource = initClient();

		ClientResponse response = webResource.header("Content-Type", "application/json")
                .header("Authorization", "Basic " + tokenId)
                .post(ClientResponse.class, text);
		
		return processAndCloseResponse(response);
	}

	private String processAndCloseResponse(ClientResponse response) {
		try {
			String result="";
		
			if (response.getStatus() == 200) {
				result=response.getEntity(String.class);
			}else{
				throw new IntegrationException("Failed : HTTP error code : " + response.getStatus());
			}
			return result;
		} finally {
			if (response != null)
				response.close();
		}
	}

	private WebResource initClient() {
		client.setReadTimeout(readTimeout);
	    client.setConnectTimeout(connectionTimeout);
		return client.resource(url);
	}

}
