package application.model;

import java.io.File;
import java.text.SimpleDateFormat;

import javafx.beans.property.SimpleStringProperty;

public class RowFile extends File {
	
	private static final long serialVersionUID = 1L;
	
	private SimpleStringProperty datepr, pathpr, statepr;
	
	private State state;
	
	public RowFile(String pathname) {
		super(pathname);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");		
		this.datepr = new SimpleStringProperty(sdf.format(this.lastModified()));
		this.pathpr = new SimpleStringProperty(this.getPath().toString());
		this.state = State.NO_SELECTED;
		this.statepr = new SimpleStringProperty(state.toString());		
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
		statepr.set(state.toString());
	}	

	public String getDatepr() {
		return datepr.get();
	}

	public String getPathpr() {
		return pathpr.get();
	}

	public String getStatepr() {
		return statepr.get();
	}

	@Override
	public String toString() {
		return "RowFile [datepr=" + datepr + ", pathpr=" + pathpr + ", statepr=" + statepr + ", state=" + state + "]";
	}

}
