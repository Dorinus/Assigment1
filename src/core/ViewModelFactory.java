package core;

import model.Radiator.Radiator;
import view.thermometer.ThermometerViewModel;

public class ViewModelFactory
{

  private ModelFactory mf;
  private ThermometerViewModel thermometerViewModel;
  private Radiator radiator

  public ViewModelFactory(ModelFactory mf)
  {
    this.mf = mf;
  }

  public ThermometerViewModel getThermometerViewModel()
  {
    if(thermometerViewModel==null){
      thermometerViewModel = new ThermometerViewModel(mf.getExternalThermometer());
    }
    return thermometerViewModel;
  }
}
