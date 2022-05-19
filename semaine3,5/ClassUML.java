import java.lang.reflect.Field;

import static java.lang.System.lineSeparator;

public class ClassUML {
    //public static Class cName;
    private static Class cName;
    private static String uml = "";


    public void classGet(Class c) {

        //lecture de la class
        cName = c;
        uml += "class " + cName.getName() + "{" + lineSeparator();

        FieldUML fieldUML = new FieldUML();

        try {
            Field[] attribut = cName.getDeclaredFields();
            for(Field val : attribut)
            {
                //visibilité
                uml += fieldUML.visibilite(val);
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        //System.out.println("La classe de l'objet obj est : " + c.getName())
    }
}

