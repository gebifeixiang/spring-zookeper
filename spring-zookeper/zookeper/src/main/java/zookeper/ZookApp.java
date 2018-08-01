package zookeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
*
* 项目名称：zookeper
* 类名称：App
* 类描述：
* 创建人：john
* 创建时间：2018年7月31日 下午3:36:01
* 修改人：john
* 修改时间：2018年7月31日 下午3:36:01
* 修改备注：
* @version
*
*/
@SpringBootApplication
@EnableDiscoveryClient
public class ZookApp {
   public static void main(String[] args){
	   SpringApplication.run(ZookApp.class, args);
	   System.out.println("hello springcloud");
   }
}
