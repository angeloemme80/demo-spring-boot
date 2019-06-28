/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.angelomassaro.restcontroller;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author admwks
 */
@RestController
public class HelloRestController {
    
    @RequestMapping("/")
    @ResponseBody
    public Map<String, Object> index(HttpServletRequest request, @RequestHeader MultiValueMap<String, String> headers) {
        
        HttpSession session = request.getSession(true);//true will create if necessary
        
        headers.forEach((key, value) -> {
            System.out.println(String.format("Header '%s' = %s", key, value.stream().collect(Collectors.joining("|"))));
        });
        
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
        data.put("data", dataMap);
        return data;
    }
}
