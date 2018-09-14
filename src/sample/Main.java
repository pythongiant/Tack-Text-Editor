package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.CodeArea;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;



public class Main extends Application {

    public static void main(String[] args) { Application.launch(args); }

    @Override public void start(Stage stage) {
        VBox root = new VBox();
        StackPane stack = new StackPane();
        CodeArea codeArea= new CodeArea();

        MenuBar menuBar = new MenuBar();

        Menu menuFile = new Menu("File");
            MenuItem open = new MenuItem("new");
            MenuItem save = new MenuItem("save");

        Menu menuEdit = new Menu("Edit");
            MenuItem menuCopy = new MenuItem("Copy");
            MenuItem menuCut = new MenuItem("Cut");
            MenuItem menuPaste = new MenuItem("Paste");

        Menu menuView = new Menu("View");
            MenuItem dark = new MenuItem("Dark Mode");

        menuBar.getMenus().addAll(menuFile,menuEdit,menuView);

        menuFile.getItems().addAll(open,save);
        menuEdit.getItems().addAll(menuCopy,menuCut,menuPaste);
        menuView.getItems().addAll(dark);


        codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
        VirtualizedScrollPane codingPane=new VirtualizedScrollPane<>(codeArea);

        VBox.setVgrow(stack,Priority.ALWAYS);
        stack.getChildren().add(codingPane);
        root.getChildren().addAll(menuBar,stack);

        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("TackTextEdit");
        stage.show();
    }
}

