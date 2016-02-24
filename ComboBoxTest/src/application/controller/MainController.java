package application.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.TreeSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.DirectoryChooser;

public class MainController {

	@FXML
	private ComboBox<String> comboBox;

	@FXML
	private ListView<String> listView, pathList;

	@FXML
	private Button add, cFolderBtn;

	private ObservableList<String> options = FXCollections.observableArrayList(),
			listItems = FXCollections.observableArrayList();

	@FXML
	public void initialize() {
		populateComboBox();
	}

	private void populateComboBox() {
		options.addAll("word1", "word2", "word3");
		comboBox.setItems(options);
	}

	@FXML
	public void addWordToList(ActionEvent e) {
		String cbValue = comboBox.getValue();
		System.out.println(cbValue);
		if (!cbValue.toString().isEmpty() && cbValue != null) {
			listItems.add(cbValue.toString());
			listView.setItems(listItems);
		} else {
			System.err.println("comboBox value is null");
		}
	}

	@FXML
	public void addFilesToList(ActionEvent event) {
		File dir = new DirectoryChooser().showDialog(cFolderBtn.getParent().getScene().getWindow());
		if (dir != null) {
			Collection<String> all = new TreeSet<String>();
			try (DirectoryStream<Path> ds = Files.newDirectoryStream(dir.toPath())) {
				for (Path child : ds) {
					all.add(child.toString());
					ObservableList<String> pList = FXCollections.observableArrayList();
					pList.addAll(all);
					pathList.setItems(pList);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
