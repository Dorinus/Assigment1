package view.thermometer;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Radiator.Radiator;
import model.Thermometer.ExternalThermometer;
import model.Thermometer.ExternalThermometerModel;
import model.Thermometer.Thermometer;

import java.beans.PropertyChangeEvent;

public class ThermometerViewModel
{
  private ExternalThermometer externalThermometer;
  private Radiator radiator;
  private Thermometer thermometer, thermometer1;
  private StringProperty outsideTempLabel, sevenMetersTemp, oneMeterTemp, powerLabel;

  public ThermometerViewModel(ExternalThermometer subject)
  {
    subject = new ExternalThermometerModel();
    Thread externarTherm = new Thread((Runnable) subject);
    externarTherm.start();   //??

    // proprety change thermometer
  //  subject.addListener(this::outsideTemp);

    outsideTempLabel = new SimpleStringProperty();


    thermometer = new Thermometer(15,1,"id1m");
    oneMeterTemp = new SimpleStringProperty(Double.toString(thermometer.getCurrentTemperature()));

    thermometer1  =new Thermometer(14,7,"id7m");
    sevenMetersTemp = new SimpleStringProperty(Double.toString(thermometer1.getCurrentTemperature()));


    radiator = new Radiator();
    powerLabel = new SimpleStringProperty(Integer.toString(radiator.getPower()));
  }



  public StringProperty outsideTempProperty()
  {

    return outsideTempLabel;
  }

  public StringProperty sevenMetersTempProperty()
  {
    return sevenMetersTemp;
  }

  public StringProperty oneMeterTempProperty()
  {
    return oneMeterTemp;
  }

  public StringProperty powerLabelProperty()
  {
    powerLabel.set(Integer.toString(radiator.getPower()));
    return powerLabel;
  }

  public void powerUp(){
    radiator.turnUp();
    powerLabelProperty();
  }

  public void powerDown(){
    radiator.turnDown();
    powerLabelProperty();
  }

public void outsideTemp(PropertyChangeEvent propertyChangeEvent)
  {

    // fiecare event in consola
      outsideTempLabel = (StringProperty) propertyChangeEvent.getNewValue() ;
  }
}
