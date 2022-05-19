import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.System.lineSeparator;

public class Init {
    public static String stringClass = "";
    public static String fichier = "semaineDeux";

    public static void debutEcriture()
    {
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

        //recuperation de la class
        ClassUML classUML = new ClassUML();
        Class cName = classUML.classGet(fichier);
        stringClass += "class " + classUML.name(cName) + "{" + lineSeparator();

        FieldUML fieldUML = new FieldUML();
        try {
            Field[] attribut = cName.getDeclaredFields();
            for (Field val : attribut) {
                int mod = val.getModifiers();
                stringClass += fieldUML.visibilite(mod);
                stringClass += fieldUML.name(val);
                fieldUML.type(mod);
            }
        } catch (Exception e) {
                throw new RuntimeException(e);
        }



        MethodUML.umlMethode();

        //fermeture de la class
        stringClass += lineSeparator() +
                "}" + lineSeparator() +
                "@enduml";

        ecriture();
    }



    private static void ecriture()
    {
        Path path = Paths.get("../../../semaine3/uml/classUML.puml");
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


    public static String visibilité(int mod)
    {
        String res ="";

        if(Modifier.toString(mod).contains("public"))
        {
            res +="+";
        }
        else if(Modifier.toString(mod).contains("private"))
        {
            res += "-";
        }
        if(Modifier.toString(mod).contains("static"))
        {
            res += "{static}";
        }
        return res;
    }


}
