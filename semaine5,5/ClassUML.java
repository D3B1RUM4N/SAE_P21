import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static java.lang.System.lineSeparator;

public class ClassUML {

    public ClassUML() {}


    public String lectureClass(Class cName)
    {
        String toUML = "";

        /******* Package ******/
        //Package p = c.getPackage();
        //toUML+= p.getName();

        /******* Type d'Objet ******/
        if(cName.isInterface())
        {
            toUML += "interface " + cName.getName() + "{" + lineSeparator();
        } else if (cName.isEnum()) {
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
            System.out.println("erreure a Attribut");
            throw new RuntimeException(e);
        }

        /****** POUR LES CONSTRUCRTEUR ******/
        ConstructorUML constructeurUML = new ConstructorUML();
        try {
            Constructor[] constructeur = cName.getDeclaredConstructors();
            for(Constructor val : constructeur)
            {
                toUML += constructeurUML.lectureConstructor(val);
            }
        } catch (Exception e) {
            System.out.println("erreure a Constructeur");
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
            System.out.println("erreure a Methode");
            throw new RuntimeException(e);
        }

        toUML += lineSeparator() +
                "}" + lineSeparator();

        return toUML;
    }
}
