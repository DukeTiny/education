package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016100900648910";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCC5ftfmJHGOXezcVBWZS+vZ1/+Id/Dv1pP8rNtyXWQN2qnAQRy1+3QXxWfrFfEABOfLG3UhiaZs/BJzKs7c+Hy4juE1yMTu/vgwtpFU5yF5LAfGB/h6Mhzo3xna8UauvM/LNFNG+rRpHHV6xp9kuFAaF3gr+KwOUXu54SKvYR6tRoQPVbWEjuPlj911ObKOc7YDe3GUBBmCyGJ3LqhT46Wp3dl2wI6fkwH3PJZY+A8/tug6yeuKyhpvl/98XO15uQWg9uv1w1wA1yI0HZKTjHYM9rWmoQKgMZH2Wf1YwI9QwENTT9NWVI/Xo7slxph2E6GJWJxv6Dr+3tcp4mUSyqVAgMBAAECggEAFL8El0MkH4muKheUhwzkgOVednXB9FFYrAEoZQcgBepykeN8ZANLItJfJ/51ro/gjELLaXqVlZjKRbgVj4evUQKAMm6ylYcexaG8XG6DCUmUjGkTbIerdYB80BtpkvH8aY/d4F3DWtS4YhIwEaT85GtmLZ1SzWFWbyXsgNzGqXfeNq4QGoHj+zHHpU+MSfhQQ/8mG5P76DB7xZ5M4a/f3aQQL1eTHBSk4q7vh8gCKfP7TvBeytewC9iEH7Ipdle/Mv4VffHVK3gP+scRf5tMUNEX+zJqH6YopJOwNTKgeLm3Nv6JPlbC2cu+cJDmmfUkFiIshnRoLVceIMEH5djUJQKBgQDMfUyvW7zMzI6GJTRg0JDoNL8+45twSXMqpST0pqwnPWJj9W1cISfuZbABl7ZF2oaOO+eN1i1pc5QmfsYdoeIotFL6bRg8amlfUwKiHFO/oqMEVKD5G6PNIV2t3HtDT8MPzZkZqLjE8186VjCAgl44rh+Klt9BvMErWkpodQV2dwKBgQCj3xcInn1lkRQGufXIzY2JsIHrhZ1Y9DBaUEv1Zg1rAh9lbVQtnLt3HA4tPssnu0Q+PTfoI7FFhELSfr5F34qlYYS9LZD4xM0LgkesPHNcvVTg81Zm0ydlxcnDGJB1B57AaEC5GrT6nRflmRp9T78kk1PVB6K3U1PCsO3JVd7OUwKBgAS5WE4sxl3M0/YRYfZimxZiMZDYXTzo1XpEumfUeeGmL2Gzx8T7FxsQylIfGRzgAX/DroO+UOpAu0lwYE9K8BiUod4bKxYqNyj2l/b6xIyGy1FMSzO2CcCxZqKfl1FkxFLXIxROq4YRQT/twc0WNesFSsE+3wV7wNKpkVJ8cZXdAoGBAIcr30kZyt/7wuQlgqtHeufHs/M9vOQCUNw+fdmHe6v4DUPR4ezZ6vy+JKeHs3Yrj4gzYSlYP8LS7XfKWlMyqJ/wh9iwfHPniidjKJHXL2WhOyFvN6cLp+TYOKx4V7hhN78If9LwR7at3GdkWihhno6iBDWl3b+QuXfQD+TSsz3HAoGAY+TjqBGjU+KYfnISVyRbRit4xQgCT5Qj6UA/Xuh44a2JkjJqsKjpM5kC4gxwrgb7OsoTv9y2RpAjMhSs8+ydtwDb8DVqE4J6CqFocPaFG0yiMeQKVX0EtxFvG6y1ZfH7wxAJQyEbR91oY98Wk13DcNrOQEKCGmfXuk9coHE3sf4=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxFOgtXvoLci5UlAQvdEOTadCzM49UqmVoSB7sTR+CE84+93XoJwAXWO2mckQr8O2O7AoGGkVGJxCDNSB/u64zYYouzyO4wvcv2fZ/WvB4CueW0Gm96hGFFcGrK8nr58yOtS0t1/DDG/HIcpBNaQU5Qf545ay3Do4gVVHxAbV2tg8pkLIf9uX5dsjANcdLw9/MQNfJO6uSn7TKE2lp22cFCZWPuIFJHpyz6trlS2xAGN7z1VzVfY2WpOL19lcXzW22RxHBKrcgch49kWv410kaoGkOUlvIDZV6CPqv7uzlydfsz1rhJRZJobPSVwsOgokJHZQJ4tVQzGxE7M3OUKYTwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";
//	public static String log_path = "";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

