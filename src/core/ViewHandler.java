package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.thermometer.ThermoeterViewController;

import java.io.IOException;

public class ViewHandler
{
  private Scene uppercaseScene;
  private Stage stage;
  private ViewModelFactory vmf;

  public ViewHandler(ViewModelFactory vmf)
  {
    this.vmf = vmf;
  }

  public void start()
  {
    stage = new Stage();
    openToUppercase();
  }

  public void openToUppercase()
  {
    if (uppercaseScene == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/thermometer/ThermoeterView.fxml"));
        Parent root = loader.load();

        ThermoeterViewController ctrl = loader.getController();
        ctrl.init(vmf.getThermometerViewModel());

        stage.setTitle("Upper Case");
        uppercaseScene  = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }

    stage.setScene(uppercaseScene);
    stage.show();

  }

}
