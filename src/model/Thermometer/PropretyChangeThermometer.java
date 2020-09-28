package model.Thermometer;

import java.beans.PropertyChangeListener;

public interface PropretyChangeThermometer
{
  public void addListener(PropertyChangeListener listener );
  public void removeListener(PropertyChangeListener listener);
}
