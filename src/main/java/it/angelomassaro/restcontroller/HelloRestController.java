/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.angelomassaro.restcontroller;

import it.angelomassaro.cdi.SessionData;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author admwks
 */

//@CrossOrigin(origins = {"*"}, value = {"*"}, allowCredentials = "")
//@CrossOrigin(origins = {"http://localhost:3000/"})
@RestController
public class HelloRestController {
   
    
    @Autowired
    SessionData sessionData;
    
    @RequestMapping(value="/", method = RequestMethod.OPTIONS)
    ResponseEntity<?> collectionOptions(HttpServletRequest request, HttpServletResponse response) 
    {
    	
     
        MultiValueMap<String, String> headers= new LinkedMultiValueMap<String,String>();
      //response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
    	headers.add("Access-Control-Allow-Credentials", "true");
    	headers.add("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
    	headers.add("Access-Control-Max-Age", "3600");
    	headers.add("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
        
         return ResponseEntity
                 .ok()
                 .allow(HttpMethod.GET, HttpMethod.POST, HttpMethod.OPTIONS)
                 .headers(new HttpHeaders(headers))
                 .build();
    }
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> index(HttpServletRequest request, @RequestHeader MultiValueMap<String, String> headers, HttpServletResponse response) {
        
        HttpSession session = request.getSession(true);//true will create if necessary
        
        headers.forEach((key, value) -> {
            System.out.println(String.format("Header '%s' = %s", key, value.stream().collect(Collectors.joining("|"))));
        });
        
        
        //response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");

        
        
        sessionData.setContatore(sessionData.getContatore()+1);
        
        Map<String, Object> data = new HashMap<String, Object>();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        Map<String, String> reqValue = new HashMap<String, String>();
        Map<String, String> pcValue = new HashMap<String, String>();
        
        reqValue.put("LocalAddr",request.getLocalAddr());
        reqValue.put("RemoteAddr",request.getRemoteAddr());
        reqValue.put("RequestedSessionId",request.getRequestedSessionId() );
        reqValue.put("RemoteHost",request.getRemoteHost() );
        reqValue.put("ContextPath",request.getContextPath() );
        reqValue.put("QueryString",request.getQueryString() );
        reqValue.put("sessionId", session.getId() );
        
        pcValue.put("cores", Integer.toString(Runtime.getRuntime().availableProcessors()) );
        pcValue.put("totalMemory", Long.toString(Runtime.getRuntime().totalMemory()/1024/1024) );
        pcValue.put("maxMemory", Long.toString(Runtime.getRuntime().maxMemory()/1024/1024) );
        pcValue.put("freeMemory", Long.toString(Runtime.getRuntime().freeMemory()/1024/1024) );
        
        dataMap.put("req", reqValue);
        dataMap.put("pc",pcValue);
        dataMap.put("contatore", sessionData.getContatore());
        data.put("data", dataMap);
        return data;
    }
    
    @RequestMapping("/primo")
    @ResponseBody
    public Map<String, Object> primo(HttpServletRequest request, @RequestHeader MultiValueMap<String, String> headers) {
        Map<String, Object> data = new HashMap<String, Object>();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        
        dataMap.put("primo","PRIMO REST");
        
        data.put("data", dataMap);
        return data;
    }
    
    @RequestMapping("/secondo")
    @ResponseBody
    public Map<String, Object> secondo(HttpServletRequest request, @RequestHeader MultiValueMap<String, String> headers) {
        Map<String, Object> data = new HashMap<String, Object>();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        
        dataMap.put("secondo","SECONDO REST");
        
        data.put("data", dataMap);
        return data;
    }
    
    @RequestMapping("/1")
    @ResponseBody
    public Map<String, Object> uno(HttpServletRequest request, @RequestHeader MultiValueMap<String, String> headers) {
        Map<String, Object> data = new HashMap<String, Object>();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        
        dataMap.put("uno","REST numero 1 (uno)");
        
        data.put("data", dataMap);
        return data;
    }
    
    @RequestMapping("/2")
    @ResponseBody
    public Map<String, Object> due(HttpServletRequest request, @RequestHeader MultiValueMap<String, String> headers) {
        Map<String, Object> data = new HashMap<String, Object>();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        
        dataMap.put("due","REST numero 2 (uno)");
        
        data.put("data", dataMap);
        return data;
    }
    
}
