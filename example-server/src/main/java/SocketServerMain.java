import com.huang.HelloService;
import com.huang.config.RpcServiceConfig;
import com.huang.remoting.transport.socket.SocketRpcServer;
import com.huang.serviceimpl.HelloServiceImpl;

/**
 * @author Huang RD
 * @date 2023/4/26 19:04
 * @description
 */
public class SocketServerMain {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        SocketRpcServer socketRpcServer = new SocketRpcServer();
        RpcServiceConfig rpcServiceConfig = new RpcServiceConfig();
        rpcServiceConfig.setService(helloService);
        socketRpcServer.registerService(rpcServiceConfig);
        socketRpcServer.start();
    }

}
