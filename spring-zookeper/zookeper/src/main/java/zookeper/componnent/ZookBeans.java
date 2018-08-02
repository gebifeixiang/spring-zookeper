package zookeper.componnent;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.CuratorTempFramework;
import org.apache.curator.framework.imps.CuratorTempFrameworkImpl;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
*
* 项目名称：zookeper
* 类名称：ZookBeans
* 类描述：
* 创建人：john
* 创建时间：2018年8月1日 下午5:17:38
* 修改人：john
* 修改时间：2018年8月1日 下午5:17:38
* 修改备注：
* @version
*
*/

@Configuration
public class ZookBeans {
	
	
	/*@Bean
	public InterProcessSemaphoreMutex InterProcessMutex(String path){
		return new InterProcessSemaphoreMutex(ClientSingleton.newClient(),  path);
	}*/
	
	/*public CuratorFramework curatorFramework(){
		return new CuratorFrameworkFactory().newClient(connectString, retryPolicy);
	}*/

}
