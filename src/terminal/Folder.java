package terminal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class IOFolders {

    public String[] properties (String[] args) throws IOException {

        File propertyFile = new File("config.properties");

        if(propertyFile.exists()) {
            FileInputStream props = new FileInputStream(propertyFile);
            Properties property = new Properties();
            property.load(props);
            String[] paths = new String[4];
            paths[0] = property.getProperty("INPUT_FOLDER");
            paths[1] = property.getProperty("OUTPUT_FOLDER");
            paths[2] = property.getProperty("DEFAULT_INPUT_FOLDER");
            paths[3] = property.getProperty("DEFAULT_OUTPUT_FOLDER");
            return paths;
        } else {
            System.err.println("Missing file config.properties!");
        }
        return paths;
    }

    public String inFolder(String[] paths){

        String input;

        if (paths[0].length() < 3) {
            input = paths[2];
            System.out.println("The path to the input folder is not assigned. "
                    + "Using default path.");
        } else {
            input = paths[0];
        }
        return input;
    }

    public String outFolder(String[] paths) {

        String output;

        if (paths[1].length() < 3) {
            output = paths[3];
            System.out.println("The path to the output folder is not assigned. "
                    + "Using default path.");
        } else {
            output = paths[1];
        }
        return output;
    }

}