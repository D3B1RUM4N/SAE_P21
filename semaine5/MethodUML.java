import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

import static java.lang.System.lineSeparator;



public class MethodUML {

    private static Method  methode;

    public String traitementMethod(Method met)
    {
        methode = met;
        int mod = methode.getModifiers();
        //declarer mod en global

        return visibilite(mod) + name() + "("+type()+")";
    }

    private String visibilite(int mod)
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

    private String name()
    {
        System.out.println("/////////////////////"+methode.getName());
        return methode.getName();
    }

    private String type()
    {
        String res ="";

        Parameter[] parametersName = methode.getParameters();
        for(Parameter val : parametersName)
        {

        }
        System.out.println("/////////////////////////" );

        Class[] parametersType = methode.getParameterTypes();
        ClassUML getClass = new ClassUML();
        for(Class val : parametersType)
        {
            if(val.getSimpleName().contains("int"))
            {
                res += ": Integer ";
            }
            else
            {
                res += ": " + val.getSimpleName() + " ";
            }
            return res;
        }
        //System.out.println("//////////////////////" + res);
        return res;

    }
}
