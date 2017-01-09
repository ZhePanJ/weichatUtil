package org.xc.weichat.core;

public final class CoreConstant {
	public static final String OPEN_ID_KEY = "openId";//存在客户端cookie的openid的key
	
	//下面是微信的一些接口
	public static final String WX_CODE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=$APPID$&redirect_uri=$REDIRECT_URI$&response_type=code&scope=$SCOPE$&state=$STATE$#wechat_redirect";
	public static final String WX_OPEN_ID_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=$APPID$&secret=$SECRET$&code=$CODE$&grant_type=authorization_code";
	public static final String WX_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=$APPID$&secret=$SECRET$";
	//微信统一下单接口
	public static final String WX_PRE_PAY_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	//微信查询订单
	public static final String WX_QUERY_ORDER_URL = "https://api.mch.weixin.qq.com/pay/orderquery";
	//微信关闭订单
	public static final String WX_CLOSE_ORDER_URL = "https://api.mch.weixin.qq.com/pay/closeorder";
	//微信申请退款
	public static final String WX_REFUND_URL = "https://api.mch.weixin.qq.com/secapi/pay/refund";
	//查询退款
	public static final String WX_REFUND_QUERY_URL = "https://api.mch.weixin.qq.com/pay/refundquery";
	//下载对账单
	public static final String WX_DOWNLOAD_BILL_URL = "https://api.mch.weixin.qq.com/pay/downloadbill";
			

}
