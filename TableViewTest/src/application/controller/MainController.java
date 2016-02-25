package application.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

import application.model.RowFile;
import application.model.State;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.DirectoryChooser;

public class MainController {

	@FXML
	public TableView<RowFile> tableView;

	@FXML
	public TableColumn<RowFile, String> dateCol, fileCol, stateCol;

	@FXML
	public Button addBtn;

	@FXML
	public void initialize() {
		dateCol.setCellValueFactory(new PropertyValueFactory<RowFile, String>("datepr"));
		fileCol.setCellValueFactory(new PropertyValueFactory<RowFile, String>("pathpr"));
		stateCol.setCellValueFactory(new PropertyValueFactory<RowFile, String>("statepr"));
		tableView.getSelectionModel().selectedItemProperty().addListener((obs,old,nev)->{
			RowFile rf = tableView.getSelectionModel().getSelectedItem();
			if(rf != null){
				if(rf.getState() == State.SELECTED){
					System.out.println("Before "+rf.getState());
					rf.setState(State.NO_SELECTED);
					System.out.println("After "+nev.getState());
				}else{
					System.out.println("Before "+rf.getState());
					rf.setState(State.SELECTED);
					System.out.println("After "+nev.getState());
				}
				rf.setState(nev.getState());
			}
		});
	}

	@FXML
	public void addFilesToTable(ActionEvent event) {
		File dir = new DirectoryChooser().showDialog(addBtn.getParent().getScene().getWindow());
		ObservableList<RowFile> tbData = FXCollections.observableArrayList();
		if (dir != null) {
			// Collection<RowFile> all = new TreeSet<RowFile>();
			try (DirectoryStream<Path> ds = Files.newDirectoryStream(dir.toPath())) {
				for (Path child : ds) {
					tbData.add(new RowFile(child.toString()));
				}
				tableView.setItems(tbData);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
