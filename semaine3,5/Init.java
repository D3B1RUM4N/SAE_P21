import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.System.lineSeparator;

public class Init {
    public static String stringClass = "";
    public static String fichier = "semaineDeux";

    public static void debutEcriture() throws ClassNotFoundException {
        // debut de l'UML
        stringClass += "@startuml" + lineSeparator() +
                lineSeparator() +
                "'UML GENER PAR CODE :)" + lineSeparator() +
                lineSeparator() +
                "skinparam style strictuml" + lineSeparator() +
                "skinparam classAttributeIconSize 0" + lineSeparator() +
                "skinparam classFontStyle Bold" + lineSeparator() +
                "hide empty members" + lineSeparator() +
                lineSeparator();

        //recup de la class
        ClassUML classUML = new ClassUML();
        try {
            classUML.classGet(Class.forName(fichier));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}