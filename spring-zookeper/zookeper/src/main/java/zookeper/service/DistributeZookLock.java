package zookeper.service;

import java.util.concurrent.TimeUnit;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import zookeper.componnent.ClientSingleton;

/**
*
* 项目名称：zookeper
* 类名称：DistributeZookLock
* 类描述：
* 创建人：john
* 创建时间：2018年8月1日 下午5:07:56
* 修改人：john
* 修改时间：2018年8月1日 下午5:07:56
* 修改备注：
* @version
*
*/

@Service
public class DistributeZookLock {
	
	
	private CuratorFramework curatorFramework=ClientSingleton.newClient();
	
	//@Autowired
	private InterProcessSemaphoreMutex InterProcessMutex=new InterProcessSemaphoreMutex(curatorFramework, "/config");
	public boolean tryLock(long time,TimeUnit unit){		
		try {
			return InterProcessMutex.acquire(time, unit);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return true;
		
	}
	
	public boolean unLock(){
		  try {
			InterProcessMutex.release();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return true;
	}
	

	  public static void main(String[] args){
		   
		  System.out.println("》》》》》"+new DistributeZookLock().curatorFramework);
	  }
}
