package model.Radiator;

public class Power3State implements RadiatorState
{
  private final int power = 3;
  private Thread thread;

  public Power3State(Radiator radiator)
  {
    thread = new Thread(() -> {

      try
      {
        Thread.sleep(5000);
        radiator.setPowerState(new Power2State());
      } catch (InterruptedException e){
        e.printStackTrace();
      }
    });

    thread.start();
  }

  @Override public void turnUp(Radiator radiator)
  {
    System.out.println("Power Already at maximum");
  }

  @Override public void turnDown(Radiator radiator)
  {
    thread.interrupt();
    radiator.setPowerState(new Power2State());
  }

  @Override public int getPower()
  {
    return power;
  }
}
