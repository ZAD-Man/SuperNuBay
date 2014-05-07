package edu.neumont.csc380.profile.handler;

import java.util.ArrayList;
import java.util.TreeMap;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.cxf.jaxrs.ext.RequestHandler;
import org.apache.cxf.jaxrs.model.ClassResourceInfo;
import org.apache.cxf.message.Message;

import edu.neumont.csc380.AuthClient.AuthClient;
import edu.neumont.csc380.AuthClient.AuthResponse;

@Provider
public class ProfileRequestHandler implements RequestHandler {

	public Response handleRequest(Message message, ClassResourceInfo cri) {
		String requestMethod = (String) message.get(message.HTTP_REQUEST_METHOD);
		String requestURI = (String) message.get(message.REQUEST_URI);
		AuthClient authClient = new AuthClient();
		
		TreeMap<String,Object> protocolHeaders =  (TreeMap<String, Object>) message.get(message.PROTOCOL_HEADERS);
		
		ArrayList al = (ArrayList) protocolHeaders.get("Authorization");
		String authToken = (String) al.get(0);
		
		if (requestMethod.equals("PUT") || requestMethod.equals("DELETE")) {
			if (authToken == null) {
				return Response.status(401).build();
			}
			String userId = requestURI.split("/")[3];
			AuthResponse actionOK = authClient.checkAuth(userId, authToken);
			if (actionOK.isSuccess()) {
				return null;
			} else {
				return Response.status(401).build();
			}
		} else {
			return null;
		}
	}
}
