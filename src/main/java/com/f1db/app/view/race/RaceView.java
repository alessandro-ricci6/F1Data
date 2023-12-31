package com.f1db.app.view.race;

import com.f1db.app.controller.race.RaceController;
import com.f1db.app.model.mixedTable.RaceTable;
import com.f1db.app.model.mixedTable.StandingTable;
import com.f1db.app.view.AbstractFXView;
import com.f1db.app.view.pages.Pages;
import com.f1db.app.view.pages.SceneManager;
import com.f1db.entity.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RaceView extends AbstractFXView {

    @FXML
    private TableColumn<RaceTable, Integer> championshipColumn;

    @FXML
    private ChoiceBox<Integer> choiceChamp;

    @FXML
    private TableColumn<StandingTable, String> driverColumn;

    @FXML
    private ChoiceBox<Integer> inputChampionship;

    @FXML
    private TextField inputLaps;

    @FXML
    private TextField inputRound;

    @FXML
    private ChoiceBox<String> inputTrack;

    @FXML
    private TableColumn<RaceTable, Integer> lapsColumn;

    @FXML
    private TableColumn<RaceTable, Integer> lengthColumn;

    @FXML
    private TableColumn<RaceTable, String> locationColumn;

    @FXML
    private TableColumn<StandingTable, Double> pointsColumn;

    @FXML
    private TableColumn<StandingTable,Integer> positionColumn;

    @FXML
    private ChoiceBox<String> choiceRace;

    @FXML
    private TableView<RaceTable> raceTable;

    @FXML
    private TableColumn<RaceTable, Integer> roundColumn;

    @FXML
    private TableView<StandingTable> standingTable;

    @FXML
    private TableColumn<RaceTable, String> trackColumn;

    @FXML
    private TableColumn<RaceTable, String> typeColumn;

    @FXML
    private CheckBox sprintRace;


    @Override
    public void init() {
        initRaceTable();
        initChampMenu();
        initInputTrack();
        initChampChoice();
    }

    private void initRaceTable() {
        trackColumn.setCellValueFactory(new PropertyValueFactory<>("trackName"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("trackLocation"));
        lapsColumn.setCellValueFactory(new PropertyValueFactory<>("laps"));
        lengthColumn.setCellValueFactory(new PropertyValueFactory<>("length"));
        roundColumn.setCellValueFactory(new PropertyValueFactory<>("round"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("raceType"));
        championshipColumn.setCellValueFactory(new PropertyValueFactory<>("championship"));
        trackColumn.prefWidthProperty().bind(raceTable.widthProperty().divide(7));
        locationColumn.prefWidthProperty().bind(raceTable.widthProperty().divide(7));
        lapsColumn.prefWidthProperty().bind(raceTable.widthProperty().divide(7));
        lengthColumn.prefWidthProperty().bind(raceTable.widthProperty().divide(7));
        roundColumn.prefWidthProperty().bind(raceTable.widthProperty().divide(7));
        typeColumn.prefWidthProperty().bind(raceTable.widthProperty().divide(7));
        championshipColumn.prefWidthProperty().bind(raceTable.widthProperty().divide(7));
        raceTable.setItems(FXCollections.observableList(this.getRaceController().getRaceTableList()));
        raceTable.getSortOrder().add(roundColumn);
    }

    private void initStandingTable(Race race) {
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
        driverColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        positionColumn.prefWidthProperty().bind(standingTable.widthProperty().divide(3));
        pointsColumn.prefWidthProperty().bind(standingTable.widthProperty().divide(3));
        driverColumn.prefWidthProperty().bind(standingTable.widthProperty().divide(3));
        List<Standing> standList = this.getRaceController().getQueryManager().getStandingByRace(race.getRaceId());
        List<StandingTable> tableList = new ArrayList<>();
        standList.forEach(s -> tableList.add
                (new StandingTable(s, this.getRaceController().getQueryManager().getDriverById(s.getDriver()))));
        standingTable.setItems(FXCollections.observableList(tableList));
        standingTable.getSortOrder().add(positionColumn);
    }

    private void initChampMenu() {
        List<Integer> yearList = new ArrayList<>();
        List<Championship> champList = this.getRaceController().getQueryManager().getAllChampionship();
        champList.forEach(c -> yearList.add(c.getYear()));
        inputChampionship.setItems(FXCollections.observableList(yearList));
    }

    private void initInputTrack(){
        List<String> nameList = new ArrayList<>();
        List<Track> trackList = this.getRaceController().getQueryManager().getAllTrack();
        trackList.forEach(t -> nameList.add(t.getName()));
        inputTrack.setItems(FXCollections.observableList(nameList));
    }

    private void initChampChoice() {
        List<Championship> champList = this.getRaceController().getQueryManager().getAllChampionship();
        List<Integer> yearList = new ArrayList<>();
        champList.forEach(c -> yearList.add(c.getYear()));
        choiceChamp.setItems(FXCollections.observableList(yearList));
        choiceChamp.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
                initRaceChoice(newValue));
    }

    private void initRaceChoice(int year) {
        List<Race> raceList = this.getRaceController().getRaceByYear(year);
        List<String> nameList = new ArrayList<>();
        raceList.forEach(r -> nameList.add(this.getRaceController().getRaceType(r.isSprintRace()) +
                " - " + this.getRaceController().getTrackByRace(r).getName()));
        choiceRace.setItems(FXCollections.observableList(nameList));
        choiceRace.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{
            Race selRace = new Race();
            String type = newValue.substring(0, newValue.indexOf("-")-1).trim();
            String name = newValue.substring(newValue.indexOf("-") + 1).trim();
            for(var r : this.getRaceController().getQueryManager().getAllRaces()){
                if(this.getRaceController().getTrackByRace(r).getName().equals(name)
                && r.isSprintRace() == sprintCheck(type)){
                    selRace = r;
                }
            }
            initStandingTable(selRace);});
    }

    private boolean sprintCheck(String type) {
        if(type.equals("Sprint")) return true;
        else return false;
    }


    @FXML
    void onAddTrackClick() {
        SceneManager.getInstance().switchPage(new Stage(), Pages.TRACK);
    }

    @FXML
    void onDriverClick() {
        SceneManager.getInstance().switchPage(this.getStage(), Pages.DRIVER);
    }

    @FXML
    void onEngineerClick() {
        SceneManager.getInstance().switchPage(this.getStage(), Pages.ENGINEER);
    }

    @FXML
    private void onChampionshipClick() {SceneManager.getInstance().switchPage(this.getStage(), Pages.CHAMPIONSHIP);}

    @FXML
    void onNextClick() {
        this.getRaceController().addRace(inputChampionship.getValue(), inputLaps.getText(),
                inputRound.getText(), inputTrack.getValue(), sprintRace.isSelected());
        SceneManager.getInstance().switchPage(new Stage(), Pages.STANDING);
    }

    @FXML
    void onTeamClick() {
        SceneManager.getInstance().switchPage(this.getStage(), Pages.TEAM);
    }

    @FXML
    void onAddChampionshipClick() {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Add championship");
        //dialog.setHeaderText("Look, a Text Input Dialog");
        dialog.setContentText("Enter the year of the championship");

// Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(s -> this.getRaceController().addChampionship(Integer.parseInt(s)));

    }

    private RaceController getRaceController() {
        return (RaceController) this.getController();
    }
}
