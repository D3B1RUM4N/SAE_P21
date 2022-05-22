import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static java.lang.System.lineSeparator;

public class ClassUML {
    //public static Class cName;
    private static Class cName;
    private static String uml = "";


    public String classGet(Class c) {

        //lecture de la class
        cName = c;
        uml += "class " + cName.getName() + "{" + lineSeparator();


        /******* POUR LES ATTRIBUTS *******/
        FieldUML fieldUML = new FieldUML();
        try {
            Field[] attribut = cName.getDeclaredFields();
            for(Field val : attribut)
            {
                //info sur les attribut
                uml += fieldUML.traitementField(val) + lineSeparator();
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

        /******* POUR LES METHODES *******/
        MethodUML methodUML = new MethodUML();
        try {
            Method[] methode = cName.getDeclaredMethods();
            for(Method val : methode)
            {
                uml += methodUML.traitementMethod(val) + lineSeparator();
            }

        }catch (Exception e) {
            throw new RuntimeException(e);
        }

        /******* FERMETURE DE LA CLASS *******/
        uml += lineSeparator() +
                "}" + lineSeparator() +
                "@enduml";
        return uml;
    }
}

