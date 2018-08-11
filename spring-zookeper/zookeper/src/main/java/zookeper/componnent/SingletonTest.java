package zookeper.componnent;

import zookeper.entity.User;

/**
*
* 项目名称：zookeper
* 类名称：SingletonTest
* 类描述：
* 创建人：john
* 创建时间：2018年8月8日 下午2:36:53
* 修改人：john
* 修改时间：2018年8月8日 下午2:36:53
* 修改备注：
* @version
*
*/
public class SingletonTest {
	public static void main(String[] args){
		User user= ClientSingleton2.INSTANCE.returnUser();
		System.out.println("枚举单例模式>>>>>"+user);
	}

}
