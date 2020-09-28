package model.Radiator;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Radiator implements PropretyChangeRadiator
{

  private RadiatorState radiatorState;
  private PropertyChangeSupport support;

  public Radiator()
  {
    this.radiatorState = new OffState();
    support = new PropertyChangeSupport(this);
  }

  public void turnUp(){
    radiatorState.turnUp(this);
    support.firePropertyChange("Changed",-1, radiatorState.getPower());
  }

  public void turnDown(){
    radiatorState.turnDown(this);
    support.firePropertyChange("Changed",-1, radiatorState.getPower());
  }

  public int getPower(){
    return radiatorState.getPower();
  }

  void setPowerState(RadiatorState state){
    radiatorState = state;
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removeListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }
}
