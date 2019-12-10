package uy.org.pmarket.shopping.integration.rest;

import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.GZIPContentEncodingFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import uy.org.pmarket.shopping.exception.IntegrationException;

public class HTTPGet {
	
	private int readTimeout;
	private int connectionTimeout;
	private Client client;
	private String url;
		
	public HTTPGet(String url, int readTimeout, int connectionTimeout) {
		this.url = url;
		this.client = Client.create();
	    client.addFilter(new GZIPContentEncodingFilter(false));
		this.client.setReadTimeout(readTimeout);
	    this.client.setConnectTimeout(connectionTimeout);
	}
	
	public HTTPGet connectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
		return this;
	}

	public HTTPGet readTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
		return this;
	}

	public String get(Map<String, String> queryParams) {
		Client client = Client.create();

		client.setReadTimeout(readTimeout);
	    client.setConnectTimeout(connectionTimeout);

	    WebResource webResource = client.resource(url);
	    MultivaluedMap<String, String> params = new MultivaluedMapImpl();
	    queryParams.keySet().forEach(key -> 
	    	params.add(key, queryParams.get(key))
	    );
	    
	    ClientResponse response = null;
	    try {
		    response = webResource.queryParams(params)
		                            .header("Content-Type", "application/json")
		                            .get(ClientResponse.class);
		    
			if (response.getStatus() == 200) 
				return response.getEntity(String.class);
			else
				throw new IntegrationException("Failed : HTTP error code : " + response.getStatus());
			
	    } finally {
	    	if (response != null)
	    		response.close();
	    }
	}

}
