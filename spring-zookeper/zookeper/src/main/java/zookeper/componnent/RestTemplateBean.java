package zookeper.componnent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
*
* 项目名称：InterfaceClient
* 类名称：RestTemplate
* 类描述：
* 创建人：john
* 创建时间：2018年8月10日 下午4:34:43
* 修改人：john
* 修改时间：2018年8月10日 下午4:34:43
* 修改备注：
* @version
*
*/
@Configuration
public class RestTemplateBean {
	@Bean
	public RestTemplate  restTemplate(){
	    SimpleClientHttpRequestFactory requestFactory =
	    		new  SimpleClientHttpRequestFactory();
	    requestFactory.setConnectTimeout(1000);
	    requestFactory.setReadTimeout(1000);

	    RestTemplate restTemplate = new RestTemplate(requestFactory);
	    return restTemplate;
	}

	

}
