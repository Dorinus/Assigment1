package core;

import model.Radiator.Radiator;
import model.Thermometer.ExternalThermometer;
import model.Thermometer.ExternalThermometerModel;

public class ModelFactory
{

  private ExternalThermometer externalThermometer;
  private Radiator radiator;


  public ExternalThermometer getExternalThermometer(){
    if (externalThermometer == null){
      externalThermometer = new ExternalThermometerModel();
    }

    return externalThermometer;
  }

  public Radiator getRadiator()
  {
    if(radiator==null){
      radiator= new Radiator();
    }
    return radiator;
  }
}
