package view.thermometer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ThermoeterViewController
{
  @FXML
  private Label outsideTemp;
  @FXML
  private Label sevenMetersTemp;

  @FXML
  private Label oneMeterTemp;
  @FXML
  private Label powerLabel;

  private ThermometerViewModel viewModel;


  public void init(ThermometerViewModel viewModel){
    this.viewModel = viewModel;



    outsideTemp.textProperty().bind(viewModel.outsideTempProperty());
    sevenMetersTemp.textProperty().bind(viewModel.sevenMetersTempProperty());
    oneMeterTemp.textProperty().bind(viewModel.oneMeterTempProperty());

    powerLabel.textProperty().bind(viewModel.powerLabelProperty());
  }


  @FXML
  public void onMainScreenButton(ActionEvent actionEvent)
  {
    System.out.println("Main Screen");

  }

  @FXML
  public void OnGraphScreenButton(ActionEvent actionEvent)
  {
    System.out.println("Graph Screen");
  }

  @FXML
  public void upPowerButton(ActionEvent actionEvent)
  {
    System.out.println("Up");
    viewModel.powerUp();

  }

  @FXML
  public void downPowerButton(ActionEvent actionEvent)
  {
    System.out.println("Down");
    viewModel.powerDown();
  }


}
