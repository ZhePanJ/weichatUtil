package org.xc.weichat.core;

import javax.servlet.http.HttpServletRequest;

/**
 * @author panjun
 * 处理http请求的一些工具，比如判断浏览器类型
 *
 */
public final class HttpRequestUtil {
	public static String getUserAgent(HttpServletRequest req){
		return req.getHeader("user-agent");
	}
	
	/**
	 * @param req
	 * 判断是否是微信浏览器
	 */
	public static boolean isWeixinBrowser(HttpServletRequest req){
		boolean result = false;
		String userAgent = getUserAgent(req).toLowerCase();
		if(userAgent.indexOf("micromessenger")>0){
			result = true;
		}
		return result;
	}
	
	/**
	 * @param req
	 * 获取请求完整url(带参数)
	 */
	public static String getRequestUrl(HttpServletRequest req){
		String url = req.getRequestURL().toString()+"?"+req.getQueryString().toString();
		return url;
	}
	
	/**
	 * 获取微信版本号
	 * @return
	 */
	public static String getWeixinBrowserVersion(HttpServletRequest req){
		String userAgent = getUserAgent(req).toLowerCase();
		if(userAgent.contains("micromessenger")){
			String[] temp = userAgent.split("micromessenger");
			String version = temp[1].trim().substring(1);
			return version;
		}
		return null;
	}
	/**
	 * @param req
	 * 判断是否支持微信支付
	 * @return
	 */
	public static boolean isSupportWeixinPay(HttpServletRequest req){
		if(!isWeixinBrowser(req)){
			return false;
		}
		if("5.0".compareTo(getWeixinBrowserVersion(req))>0){
			//微信版本低于5.0，不支持支付
			return false;
		}
		return true;
	}
	

}
