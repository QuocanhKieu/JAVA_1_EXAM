package classList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;

public class ClassFormController {

    @FXML
    public TextField ipClassName;
    public TextField ipPhongHoc;
    public TextField ipMaLop;
    public DatePicker ipStartDate;
    public ComboBox<String> myComboBox; // Assuming you named your ComboBox "myComboBox" in Scene Builder

    // You can initialize the ComboBox items in your controller's initialize method, for instance
    public void initialize() {
        ObservableList<String> items = FXCollections.observableArrayList(
                "Aptech", "Arena", "Skillking");
        myComboBox.setItems(items);
    }

    public ListView<Class> listView;

    private ObservableList<Class> classList = FXCollections.observableArrayList();

    public void openEditDialog() {
        Class aClass = listView.getSelectionModel().getSelectedItem();
        if(aClass == null) return;
        Stage editStage = new Stage();
        editStage.initModality(Modality.APPLICATION_MODAL);
        editStage.setTitle("Edit Class");

        TextField ipClassName = new TextField(aClass.getClassName());
        TextField ipPhongHoc = new TextField(aClass.getPhongHoc());
        TextField ipMaLop = new TextField(aClass.getMaLop());
        DatePicker ipStartDate = new DatePicker(aClass.getStartDate());
        ComboBox<String>   myComboBox = new ComboBox<>();
        ObservableList<String> items = FXCollections.observableArrayList(
                "Aptech", "Arena", "Skillking");
        myComboBox.setItems(items);
        myComboBox.setValue(aClass.getTenChuongTrinh());


        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            // Update the selected student object with edited details
            aClass.setClassName(ipClassName.getText());
            aClass.setMaLop(ipMaLop.getText());
            aClass.setPhongHoc(ipPhongHoc.getText());
            aClass.setStartDate(ipStartDate.getValue());
            aClass.setTenChuongTrinh(myComboBox.getValue());
            listView.refresh();


            editStage.close(); // Close the edit dialog after saving changes
        });

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> editStage.close());

        VBox editLayout = new VBox(10);
        editLayout.getChildren().addAll(ipClassName, ipPhongHoc,ipMaLop, ipStartDate, myComboBox, saveButton, closeButton);

        Scene editScene = new Scene(editLayout, 250, 400);
        editStage.setScene(editScene);
        editStage.showAndWait(); // Wait for this stage to be closed before returning
    }

    public void submit(ActionEvent actionEvent) {
        try {
            String className = ipClassName.getText();
            String phongHoc = ipPhongHoc.getText();
            String maLop = ipMaLop.getText();
            LocalDate startDate = ipStartDate.getValue();
            String tenChuongTrinh = myComboBox.getSelectionModel().getSelectedItem();
            if(className.isEmpty()){
                throw new Exception("Vui lòng điền Tên Lớp");
            }
            if(phongHoc.isEmpty()){
                throw new Exception("Vui lòng điền Phòng Học");
            }
            if(maLop.isEmpty()){
                throw new Exception("Vui lòng điền Mã Lớp");
            }
            if(startDate == null){
                throw new Exception("Vui lòng điền startDate");
            }
            if(tenChuongTrinh == null){
                throw new Exception("Vui lòng chọn Chuong Trinh");
            }
            // set view
            Class s = new Class(className, phongHoc, maLop,startDate,tenChuongTrinh);
            classList.add(s);
            render();
            clearInput();
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }

    private void render() throws Exception{ // print list student to information
        listView.setItems(classList);
//        listView.refresh();
    }

    private void clearInput() throws Exception{
        ipClassName.clear();
        ipMaLop.clear();
        ipPhongHoc.clear();
        ipStartDate.setValue(null);
        myComboBox.setValue(null);
    }
}
