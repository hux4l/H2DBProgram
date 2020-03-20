package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public Button buttonUprav;
    public Label labelTest;
    public Button btnNacitaj;

    public void upravUdaj() {
        System.out.println("Gotcha!");
        labelTest.setText("Gotcha!");
    }



    @FXML
    private TableView<ModelTable> table;
    @FXML
    private TableColumn<ModelTable, String> col_id;
    @FXML
    private TableColumn<ModelTable, String> col_meno;
    @FXML
    private TableColumn<ModelTable, String> col_priezvisko;
    @FXML
    private TableColumn<ModelTable, String> col_email;
    @FXML
    private TableColumn<ModelTable, String> col_telefon;
    @FXML
    private TableColumn<ModelTable, String> col_datum;

    private ObservableList<ModelTable> data;
    private DBConnect connect;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        connect = new DBConnect();
    }

    public void nacitajUdaje() throws SQLException, ClassNotFoundException {
        Connection conn = connect.Connect();
        data= FXCollections.observableArrayList();
        // Execute querry and store result in a resultset
        ResultSet rs = conn.createStatement().executeQuery("select * from test;");
        while(rs.next()) {
            data.add(new ModelTable(rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)));
        }

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_meno.setCellValueFactory(new PropertyValueFactory<>("meno"));
        col_priezvisko.setCellValueFactory(new PropertyValueFactory<>("priezvisko"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        col_telefon.setCellValueFactory(new PropertyValueFactory<>("cislo"));
        col_datum.setCellValueFactory(new PropertyValueFactory<>("datum"));

        table.setItems(data);


    }
}


