package model.Radiator;

public class OffState implements RadiatorState
{

  private final int power = 0;


  @Override public void turnUp(Radiator radiator)
  {
    radiator.setPowerState(new Power1State());
  }

  @Override public void turnDown(Radiator radiator)
  {
    System.out.println("Radiator is already at 0");
  }

  @Override public int getPower()
  {
    return power;
  }
}
