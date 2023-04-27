import com.huang.HelloService;
import com.huang.annotation.RpcScan;
import com.huang.config.RpcServiceConfig;
import com.huang.remoting.transport.netty.server.NettyRpcServer;
import com.huang.serviceimpl.HelloServiceImpl2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Huang RD
 * @date 2023/4/26 18:55
 * @description 服务器：通过 @RpcService 注解自动注册服务
 */
@RpcScan(basePackage = {"com.huang"})
public class NettyServerMain {

    public static void main(String[] args) {
        // 通过注解注册服务
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(NettyServerMain.class);
        NettyRpcServer nettyRpcServer = (NettyRpcServer) applicationContext.getBean("nettyRpcServer");
        // 手动注册服务
        HelloService helloService2 = new HelloServiceImpl2();
        RpcServiceConfig rpcServiceConfig = RpcServiceConfig.builder()
                .group("test2").version("version2").service(helloService2).build();

        nettyRpcServer.registerService(rpcServiceConfig);
        nettyRpcServer.start();
    }

}
