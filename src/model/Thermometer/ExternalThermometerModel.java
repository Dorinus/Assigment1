package model.Thermometer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ExternalThermometerModel implements PropretyChangeThermometer, ExternalThermometer
{
  /**
   * Calculating the external temperature.
   * Values are only valid if the temperature is being measured
   * approximately every 10th second.
   *
   * @param t0 the last measured external temperature
   * @param min a lower limit (may temporally be deceeded)
   * @param max an upper limit (may temporally be exceeded)
   * @return an updated external temperature
   */

  private double min = 20;
  private double max = 20;
  private double currentTemp = 1;
  private PropertyChangeSupport support;

  public ExternalThermometerModel()
  {
    support = new PropertyChangeSupport(this);
  }

   public double calculateExternalTemperature(double t0)
  {
    double left = t0 - min;
    double right = max - t0;
    int sign = Math.random() * (left + right) > left ? 1 : -1;
    t0 += sign * Math.random();
    return t0;
  }


  @Override public double getExternalTemperature()
  {
    return currentTemp;
    // take from Proprety change listener
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removeListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

  @Override public void run()
  {

    while (true)
    {
      try
      {
        Thread.sleep(6000);
        double tempTemp = calculateExternalTemperature(currentTemp);
        System.out.println("Temperature for external thermometer is " + tempTemp + ".");

        support.firePropertyChange("Temp Changed", currentTemp, tempTemp);
        currentTemp = tempTemp;
      }
      catch (InterruptedException e)
      {
        System.out.println(" ExternalThermometerModel Interupted");
        e.printStackTrace();
      }

    }
  }
}
