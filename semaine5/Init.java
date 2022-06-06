import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.System.lineSeparator;

public class Init {
    public static String stringClass = "";
    public static String fichier = "Main";

    public Init(String arg) throws ClassNotFoundException {
        fichier = arg;
        debutEcriture();
    }
    //public static String[] fichiers = {"ClassUML", "Init", "FieldUML"};

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
            stringClass += classUML.classGet(Class.forName(fichier));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        /****** Fin de l'UML ******/
        stringClass += "@enduml" + lineSeparator();


        ecriturePUML();
        ecritureSVG();
    }

    public static void ecriturePUML()
    {
        Path path = Paths.get("../../../semaine5/uml/classUML.puml");
        try {
            //String str = "Test creation \n Hello W0rld";
            byte[] bs = stringClass.getBytes();
            Path writtenFilePath = Files.write(path, bs);
            System.out.println("Written content in file:\n"+ new String(Files.readAllBytes(writtenFilePath)));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ecritureSVG()
    {
        Path path = Paths.get("../../../semaine3,5/uml/classUML.svg");
        try {
            //String str = "Test creation \n Hello W0rld";
            byte[] bs = stringClass.getBytes();
            Path writtenFilePath = Files.write(path, bs);
            System.out.println("Written content in file:\n"+ new String(Files.readAllBytes(writtenFilePath)));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}