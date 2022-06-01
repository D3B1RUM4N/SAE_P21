import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static java.lang.System.lineSeparator;



public class MethodUML {

    private static Method methode;

    public String traitementMethod(Method met)
    {
        methode = met;
        int mod = methode.getModifiers();

        return visibilite(mod) + name() + "("+type()+")"+ lineSeparator();
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
        return methode.getName();
    }

    private String type()
    {
        String res ="";
        Class[] parameters = methode.getParameterTypes();
        for(Class val : parameters)
        {
            if(val.getSimpleName().contains("int"))
            {
                res += ": Integer ";
            }
            else
            {
                res += ": " + val.getSimpleName() + " ";
            }
        }
        //System.out.println("//////////////////////" + res);
        return res;

    }
}
