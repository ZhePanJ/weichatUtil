package org.xc.weichat.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefaultOpenIdStore {
	public static void openIdStore(HttpServletRequest req,HttpServletResponse resp,String key,String value,int maxAge){
		CookieUtil.setCookie(req, resp, key, value,maxAge);
		req.setAttribute(key, value);
	}
	
	public static String getOpenId(HttpServletRequest req,String key){
		Object obj = req.getAttribute(key);
		if(obj!=null){
			return (String)obj;
		}else{
			return CookieUtil.getCookieValue(req, key);
		}
		
	}

}
