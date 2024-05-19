package ma.ac.usms.ensak.presentation.Views;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StatisticView extends VBox{
    private HBox TotalHoursWork;
    private HBox ProjectHoursWork;

    public StatisticView() {
        TotalHoursWork = new HBox();
        ProjectHoursWork = new HBox();
        getChildren().addAll(TotalHoursWork, ProjectHoursWork);
    }

    public HBox getTotalHoursWork() {
        return TotalHoursWork;
    }

    public HBox getProjectHoursWork() {
        return ProjectHoursWork;
    }
}
