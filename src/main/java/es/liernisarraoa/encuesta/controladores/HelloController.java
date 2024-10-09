package es.liernisarraoa.encuesta.controladores;


import es.liernisarraoa.encuesta.HelloApplication;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;


import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.System.exit;


public class HelloController implements Initializable {
    private Scene sceneApplication;

    @FXML
    private TextField labelProfesion;

    @FXML
    private TextField labelHermanos;

    @FXML
    private ComboBox<String> comboBoxEdad;

    @FXML
    private RadioButton radioHombre;

    @FXML
    private RadioButton radioMujer;

    @FXML
    private RadioButton radioOtro;

    @FXML
    private ToggleGroup RadioGrupo;

    @FXML
    private CheckBox checkBoxPractica;

    @FXML
    private ListView<String> listaDeportes;

    @FXML
    private Slider sliderCompras;

    @FXML
    private Slider sliderTelevision;

    @FXML
    private Slider sliderCine;

    @FXML
    private Button botonAceptar;

    @FXML
    private Button botonCancelar;

    @FXML
    private VBox VBoxPantalla;
    
    public void visualizarLista(ActionEvent actionEvent) {
        listaDeportes.setDisable(!checkBoxPractica.isSelected());
    }

    public void mensajeInfo(ActionEvent actionEvent) {
        sceneApplication = HelloApplication.getScene();
        alerta();
    }

    public void alerta(){
        ObservableList<String> deportesSeleccionados = listaDeportes.getSelectionModel().getSelectedItems();
        String deportes = "";
        for(int i = 0; i < deportesSeleccionados.size(); i++){
            deportes += "\t" + deportesSeleccionados.get(i) + "\n";
        }
        SingleSelectionModel<String> edadSeleccionada = comboBoxEdad.getSelectionModel();
        String sexoSeleccionado = ((RadioButton) RadioGrupo.getSelectedToggle()).getText();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(sceneApplication.getWindow());
        alert.setHeaderText(null);
        alert.setTitle("TUS DATOS");
        if(checkBoxPractica.isSelected()){
            alert.setContentText("Profesion: " + labelProfesion.getText() + "\n" +
                    "Nº de Hermanos: " + labelHermanos.getText() + "\n" +
                    "Edad: " + edadSeleccionada.getSelectedItem() + "\n" +
                    "Sexo: " + sexoSeleccionado + "\n" +
                    "Deportes que practicas: \n" +
                    deportes +
                    "Grado de aficcion a las compras: " + sliderCompras.getValue() + "\n" +
                    "Grado de aficcion a ver la television: " + sliderTelevision.getValue() + "\n" +
                    "Grado de aficcion a ir al cine: " + sliderCine.getValue() + "\n");
        } else {
            alert.setContentText("Profesion: " + labelProfesion.getText() + "\n" +
                    "Nº de Hermanos: " + labelHermanos.getText() + "\n" +
                    "Edad: " + edadSeleccionada.getSelectedItem() + "\n" +
                    "Sexo: " + sexoSeleccionado + "\n" +
                    "Grado de aficcion a las compras: " + sliderCompras.getValue() + "\n" +
                    "Grado de aficcion a ver la television: " + sliderTelevision.getValue() + "\n" +
                    "Grado de aficcion a ir al cine: " + sliderCine.getValue() + "\n");
        }

        alert.showAndWait();
    }

    public void salirPrograma(ActionEvent actionEvent) {
        exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] listaString = new String[] {"Futbol", "Tenis", "Baloncesto", "Natacion", "Ciclismo", "Otro"};
        listaDeportes.getItems().addAll(listaString);
        listaDeportes.setDisable(true);
        listaDeportes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        String[] edadesCombo = new String[] {"Menores de 18", "Entre 18 - 30", "Entre 31 - 50", "Entre 51 - 70", "Mayores de 70"};
        comboBoxEdad.getItems().addAll(edadesCombo);
    }
}