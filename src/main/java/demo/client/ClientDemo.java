package demo.client;

public class ClientDemo {

    public static void main(String[] args) throws Exception {
        RpcClient client = new RpcClient();
        System.out.println("client runing..." );
        CalculatorService service = client.refer(CalculatorService.class, "127.0.0.1", 1234);
        int count;
        int result=0;
        for (int i = 0; i < 10; i++) {
            count = i;
            result = service.add(count, i);
        }
        System.out.println("result:" + result);
    }

}
