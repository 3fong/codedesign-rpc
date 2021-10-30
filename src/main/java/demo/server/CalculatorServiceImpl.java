package demo.server;

public class CalculatorServiceImpl implements CalculatorService {

  @Override
  public int add(int a, int b) {
    System.out.println("count value a: "+a+" b: "+b);
    return a + b;
  }
}
