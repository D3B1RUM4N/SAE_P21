import java.lang.reflect.Field;

import static java.lang.System.lineSeparator;

public class ClassUML {

    public ClassUML() {}
    private Class cName;
    private String toUML = "";

    public String lectureClass(Class c)
    {
        cName = c;

        /******* Package ******/
        Package p = c.getPackage();
        toUML+= p.getName();

        /******* Type d'Objet ******/
        if(cName.isInterface())
        {
            toUML += "interface " + cName.getName() + "{" + lineSeparator();
        } else if (c.isEnum()) {
            toUML += "enumeration " + cName.getName() + "{" + lineSeparator();
        } else {
            toUML += "class " + cName.getName() + "{" + lineSeparator();
        }

        /******* Attribut ******/
        FieldUML field = new FieldUML();
        try {
            Field[] attribut = cName.getDeclaredFields();
            for(Field val : attribut)
            {
                //info sur les attribut
                toUML += field.lectureField(val) + lineSeparator();
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
                toUML += methodUML.traitementMethod(val) + lineSeparator();
            }

        }catch (Exception e) {
            throw new RuntimeException(e);
        }

        return toUML;
    }
}
