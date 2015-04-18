package com.lvarela.stratic.algoritmo.queima;

import java.io.FileReader;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {       
        Algorithm a = new Algorithm("Berlin", "London");

        CSVParser parser = new CSVParser(new FileReader("time.csv"), CSVFormat.DEFAULT.withDelimiter(';').withHeader());


        Set<String> set = parser.getHeaderMap().keySet();
        set.remove(set.toArray()[0]); //removes the first column
        
        //load data
        for (CSVRecord record : parser) {
            for (String s : set) {
                if (!"".equals(record.get(s)) && record.get(s) != null) {
                    a.put(record.get(0), s, Float.parseFloat(record.get(s)));
                }
            }
        }
        parser.close();

        a.load(); //pre-processing

        //computes and prints
        a.run().print();
        System.out.println();
        System.out.println("All: ");
        a.print();
        System.exit(0);
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
