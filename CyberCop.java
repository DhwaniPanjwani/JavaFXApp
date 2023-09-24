package hw2;

import java.net.URL;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CyberCop extends Application{

	public static final String DEFAULT_PATH = "data"; //folder name where data files are stored
	public static final String DEFAULT_HTML = "/CyberCop.html"; //local HTML
	public static final String APP_TITLE = "Cyber Cop"; //displayed on top of app

	CCView ccView = new CCView();
	CCModel ccModel = new CCModel();

	CaseView caseView; //UI for Add/Modify/Delete menu option

	GridPane cyberCopRoot;
	Stage stage;

	static Case currentCase; //points to the case selected in TableView.

	public static void main(String[] args) {
		launch(args);
	}

	/** start the application and show the opening scene */
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		primaryStage.setTitle("Cyber Cop");
		cyberCopRoot = ccView.setupScreen();  
		setupBindings();
		Scene scene = new Scene(cyberCopRoot, ccView.ccWidth, ccView.ccHeight);
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		ccView.webEngine.load(getClass().getResource(DEFAULT_HTML).toExternalForm());
		primaryStage.show();
	}

	/** setupBindings() binds all GUI components to their handlers.
	 * It also binds disableProperty of menu items and text-fields 
	 * with ccView.isFileOpen so that they are enabled as needed
	 */
	void setupBindings() {
		//write your code here

		//The following is some helper code to display web-pages. It is commented out to start with
		//Uncomment it to plug it in your code as needed.  

//		if (currentCase.getCaseLink() == null || currentCase.getCaseLink().isBlank()) {  //if no link in data
//			URL url = getClass().getClassLoader().getResource(DEFAULT_HTML);  //default html
//			if (url != null) ccView.webEngine.load(url.toExternalForm());
//		} else if (currentCase.getCaseLink().toLowerCase().startsWith("http")){  //if external link
//			ccView.webEngine.load(currentCase.getCaseLink());
//		} else {
//			URL url = getClass().getClassLoader().getResource(currentCase.getCaseLink().trim());  //local link
//			if (url != null) ccView.webEngine.load(url.toExternalForm());
//		}
	}
}

