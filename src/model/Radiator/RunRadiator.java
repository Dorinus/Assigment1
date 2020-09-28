package model.Radiator;

public class RunRadiator
{
  public static void main(String[] args) throws InterruptedException
  {
    Radiator radiator = new Radiator();
    radiator.setPowerState(new Power3State(radiator));
    System.out.println(radiator.getPower());

    Thread.sleep(11000);
    System.out.println(radiator.getPower());

  }
}
