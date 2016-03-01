package application.model;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class RowChanger implements Callback<TableView<RowFile>, TableRow<RowFile>> {
	private final ObservableList<Integer> styledRowIndices = FXCollections.observableArrayList();
	private final ObservableList<TableRow<RowFile>> selectedRows = FXCollections.observableArrayList();
	private final ObservableList<TableRow<RowFile>> noSelectedRows = FXCollections.observableArrayList();

	private final RowState SELECTED = RowState.SELECTED;
	private final RowState NO_SELECTED = RowState.NO_SELECTED;

	@Override
	public TableRow<RowFile> call(TableView<RowFile> param) {
		TableRow<RowFile> row = new TableRow<>();

		styledRowIndices.addListener((ListChangeListener<Integer>) (changed) -> {
			this.updateNotSelectedRows(row);
		});
		row.getStyleClass().addListener((ListChangeListener<String>) (changed) -> {
			if (row.getItem() != null) {
				if (selectedRows.contains(row) && !row.getStyleClass().contains(SELECTED.toString())) {
					selectedRows.remove(row);
					if (!noSelectedRows.contains(row))
						noSelectedRows.add(row);

				} else {
					selectedRows.add(row);
					if (noSelectedRows.contains(row))
						noSelectedRows.remove(row);

				}
			}
		});
		row.setOnMouseClicked(e -> {
			updateStyleSelectedRows(row);

		});

		return row;
	}

	private void updateStyleSelectedRows(TableRow<RowFile> row) {
		ObservableList<String> rowStyleClasses = row.getStyleClass();
		if (row.getItem() != null) {
			if (!rowStyleClasses.contains(SELECTED.toString()) && !rowStyleClasses.contains(SELECTED.toString())) {
				rowStyleClasses.add(SELECTED.toString());

			} else if (rowStyleClasses.contains(NO_SELECTED.toString())) {
				rowStyleClasses.clear();
				rowStyleClasses.add(SELECTED.toString());

			} else if (rowStyleClasses.contains(SELECTED.toString())) {
				rowStyleClasses.clear();
				rowStyleClasses.add(NO_SELECTED.toString());
			}
			
		}

	}

	private void updateNotSelectedRows(TableRow<RowFile> row) {
		ObservableList<String> rowStyleClasses = row.getStyleClass();
		if (row.getItem() != null) {
			if (!styledRowIndices.contains(row.getIndex()) && !row.getStyleClass().contains(SELECTED.toString())) {
				rowStyleClasses.add(NO_SELECTED.toString());
				row.getItem().setState(NO_SELECTED);
				if (!noSelectedRows.contains(row))
					noSelectedRows.add(row);
				row.getItem().setState(NO_SELECTED);
			}
		}

	}
}
