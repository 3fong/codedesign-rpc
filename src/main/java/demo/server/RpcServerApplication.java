package demo.server;

public class RpcServerApplication {

    public static void main(String[] args) throws Exception {
      CalculatorService service = new CalculatorServiceImpl();
        System.out.println("server runing..............................");
        RpcServer server = new RpcServer();
        server.export(service, 1234);
    }

}
