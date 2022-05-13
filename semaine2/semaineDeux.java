import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.System.lineSeparator;

public class semaineDeux {

    public static String stringClass;
    public static Class cName;
    

    public static void main(String[] args)
    {
        //recuperation de la class
        classGet();
        umlClass();

        //fermeture de la class
        stringClass += lineSeparator() +
                "}" + lineSeparator() +
                "@enduml";

        ecriture();
    }

    public static void classGet()
    {

        try {
            cName = Class.forName("semaineDeux");
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //System.out.println("La classe de l'objet obj est : " + c.getName())
    }


    public static void umlClass()
    {
        //creation d'une class pour l'uml
        stringClass += "@startuml" + lineSeparator() +
                "skinparam style strictuml" + lineSeparator() +
                "skinparam classAttributeIconSize 0" + lineSeparator() +
                "skinparam classFontStyle Bold" + lineSeparator() +
                "hide empty members" + lineSeparator() +
                lineSeparator();


        stringClass += "class " + cName.getName() + "{" + lineSeparator();
    }

    public static void ecriture()
    {
        Path path = Paths.get("../../../fichierTXT/classUML.puml");
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
