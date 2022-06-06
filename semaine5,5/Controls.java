import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.System.lineSeparator;


public class Controls {
    
    private String fichier;
    private String stringClass = "";

    public Controls() {    }
    
    public void controls(String arg)
    {
        fichier = arg;

        Ecriture write = new Ecriture();
        /******* Debut ecriture *******/
        stringClass += write.debutEcriture();

        /******* Traitement Class *******/
        ClassUML classe = new ClassUML();
        try {
            stringClass += classe.lectureClass(Class.forName(fichier));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        /******* Fin ecriture *******/
        stringClass += write.finEcriture();
    }
    
}
