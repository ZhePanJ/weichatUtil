package org.xc.weichat.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.xc.weichat.core.CoreConstant;
import org.xc.weichat.core.DefaultOpenIdStore;
import org.xc.weichat.core.HttpClientUtil;
import org.xc.weichat.core.HttpRequestUtil;
import org.xc.weichat.core.WeixinUtil;

import com.alibaba.fastjson.JSONObject;

public class WeixinFilter implements Filter{
	protected Logger log = Logger.getLogger(super.getClass());

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest)request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		String appId = WeixinUtil.getAppId();
		String appsecret = WeixinUtil.getAppsecret();
		if(HttpRequestUtil.isWeixinBrowser(httpReq)){
			String openId = DefaultOpenIdStore.getOpenId(httpReq, CoreConstant.OPEN_ID_KEY);
			if(StringUtils.isBlank(openId)){
				//去微信取openid
				String url = HttpRequestUtil.getRequestUrl(httpReq);
				String code = httpReq.getParameter("code");
				if(StringUtils.isBlank(code)){
					httpResp.sendRedirect(WeixinUtil.getCodeURL(appId, url, "snsapi_base", "123"));
					return;
				}else{
					String wxOpenIdResultJSONStr = HttpClientUtil.sendGET(WeixinUtil.getOpenIdURL(appId, appsecret, code));
					log.info("wxOpenIdResultJSONStr:"+wxOpenIdResultJSONStr);
					JSONObject json = JSONObject.parseObject(wxOpenIdResultJSONStr);
					openId = json.getString("openid");
					DefaultOpenIdStore.openIdStore(httpReq, httpResp, CoreConstant.OPEN_ID_KEY, openId, 30*24*60*60);
				}
				
			}
			
		}
		chain.doFilter(request, response);
		
		
	}

	@Override
	public void init(FilterConfig chain) throws ServletException {
		
	}

}
