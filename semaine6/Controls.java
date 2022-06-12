import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Dictionary;

import static java.lang.System.lineSeparator;


public class Controls {
    
    //private String fichier;
    public Controls() {    }


    protected String[] test(Dictionary testest) {return new String[]{"", ""};}
    public String controls(String fichier)
    {
        String stringClass = "";

        /******* Traitement Class *******/

        ClassUML classe = new ClassUML();
        try {
            stringClass += classe.lectureClass(Class.forName(fichier));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return stringClass;
    }
    
}
