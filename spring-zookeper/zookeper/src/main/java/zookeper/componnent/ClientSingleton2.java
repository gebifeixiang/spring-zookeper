package zookeper.componnent;

import zookeper.entity.User;

/**
*
* 项目名称：zookeper
* 类名称：ClientSingleton2
* 类描述：
* 创建人：john
* 创建时间：2018年8月8日 下午2:35:47
* 修改人：john
* 修改时间：2018年8月8日 下午2:35:47
* 修改备注：
* @version
*
*/
public enum ClientSingleton2 {
	INSTANCE;
	
	private User user;
	
	ClientSingleton2(){
		System.out.println("构造方法");
		user=new User();
		user.setAge(1000);
		user.setUserName("singleton");
	}
	public User returnUser(){
		return user;
	}

}

