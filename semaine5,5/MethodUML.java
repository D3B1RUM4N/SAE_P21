import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class MethodUML {

    public MethodUML() {}

    private Method methode;
    private int mod;

    public String traitementMethod(Method met)
    {
        methode = met;
        mod = methode.getModifiers();
        //declarer mod en global
        ModifierUML modifieur = new ModifierUML();
        return modifieur.visibilite(mod) + name() + "("+type()+")" + returnType();
    }

    private String name()
    {
        //System.out.println("///////////////////// nom param 2"+methode.getName());
        return methode.getName();
    }

    private String type()
    {
        String res ="";

        Parameter[] parametersName = methode.getParameters();
        for(Parameter val : parametersName)
        {
            //System.out.println("///////////////// nom param : " + val.getName());
            res += val.getName();
        }
        //System.out.println("/////////////////////////" );

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

    private String returnType() {
        //System.out.println("/////" + methode.getReturnType().getSimpleName());
        String val = methode.getReturnType().getSimpleName();
        if (val.contains("void")) {
            return "";
        } else if (val.contains("String")) {
            return ": String";
        } else if (val.contains("int")) {
            return ": Integer";
        } else {
            return ": " + val;
        }
    }

        //System.out.println("////////////" + methode.getName());
        //System.out.println("///" + methode.getReturnType().getTypeName());




}
