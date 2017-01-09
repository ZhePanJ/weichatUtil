package org.xc.weichat.core;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class WeixinUtil {
	public static final String getCodeURL(String appId,String redirectUri,String scope,String state){
	    String url = CoreConstant.WX_CODE_URL;
	    try {
			redirectUri = URLEncoder.encode(redirectUri,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    url = url.replace("$APPID$", appId).
	    		replace("$REDIRECT_URI$", redirectUri).
	    		replace("$SCOPE$", scope).
	    		replace("$STATE$", state);
	    return url;
		
	}
	public static final String getOpenIdURL(String appId,String appsecret,String code){
		String url = CoreConstant.WX_OPEN_ID_URL;
		url = url.replace("$APPID$", appId).replace("$SECRET$", appsecret).replace("$CODE$", code);
		return url;
	}
	public static final String getAccessTokenURL(String appId,String appsecret){
		String url = CoreConstant.WX_ACCESS_TOKEN_URL;
		url = url.replace("$APPID$", appId).replace("$SECRET$", appsecret);
		return url;
	}
	
	public static final String getAppId(){
		String appId = "";
		return appId;
	}
	public static final String getAppsecret(){
		String appsecret = "";
		return appsecret;
	}

}
