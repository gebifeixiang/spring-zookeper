package zookeper.componnent;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
*
* 项目名称：zookeper
* 类名称：ClientSingleton
* 类描述：
* 创建人：john
* 创建时间：2018年8月1日 下午9:06:00
* 修改人：john
* 修改时间：2018年8月1日 下午9:06:00
* 修改备注：
* @version
*
*/

public class ClientSingleton {
    private static CuratorFramework client = null;

    private ClientSingleton() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        client = CuratorFrameworkFactory.builder().connectString("127.0.0.1:2181").retryPolicy(retryPolicy)
                .sessionTimeoutMs(1000 * 6).connectionTimeoutMs(1000 * 6).build();
    }

    public static synchronized CuratorFramework newClient() {
        if (client == null) {
            new ClientSingleton();
        }
        return client;
    }

    public static void start() {
        client.start();
    }

    public static void close() {
        client.close();
    }
}
