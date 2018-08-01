package zookeper.controller;

import java.util.List;
import org.springframework.core.env.Environment;
import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 项目名称：zookeper 类名称：ZookController 类描述： 创建人：john 创建时间：2018年7月31日 下午3:51:56
 * 修改人：john 修改时间：2018年7月31日 下午3:51:56 修改备注：
 * 
 * @version
 *
 */
@RestController
@RequestMapping("/zook")
public class ZookController {
	@Autowired
	private DiscoveryClient client;
	@Autowired
	private Environment environment;
	@Autowired
	private CuratorFramework curatorFramework;

	public String getZook() {
		return "";
	}

	@RequestMapping("/getServices")
	public String discoveryClent() {
		List<String> serviceList = client.getServices();
		List<ServiceInstance> list=client.getInstances("info");
		 //获取实例化的服务
        StringBuffer sb = new StringBuffer();
        if (list != null && list.size() > 0 ) {
            sb.append(list.get(0).getUri()+",");
            System.out.println(">>>>>>>>>>>>>>>>"+list.get(0).isSecure());
        }
	    System.out.println("sb>>>>>"+sb);
		System.out.println("注册服务的数量>>>>>>>>>>>>>>>>>" + serviceList.size());
		for (String service : serviceList) {
			System.out.println("注册的服务>>>>>>" + service);
		}
		return "info";
	}

	@GetMapping("/env")
	public String test() {
		String[] profiles = environment.getActiveProfiles();
		System.out.println("profiles>>>>>>>" + profiles.length);
		for (String item : profiles) {
			System.out.println("item>>>>>>>>>>>>>>>" + item);
		}
		
		String name = environment.getProperty("url");
		
		try {
			List <String> listChildren=curatorFramework.getChildren().forPath("/config/zook");
			for(String child:listChildren ){
				System.out.println("child>>>>>>>"+child);
				System.out.println(child+"的值是>>>>>>"+environment.getProperty(child));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(name);

		return "Hello," + name;
	}
}
