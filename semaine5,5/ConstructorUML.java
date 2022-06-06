import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

import static java.lang.System.lineSeparator;

public class ConstructorUML {
    public ConstructorUML() {}

    private Constructor constructeur;

    public String lectureConstructor(Constructor cons)
    {
        constructeur = cons;
        //System.out.println("/////////////" + constructeur.getName().toString());
        ModifierUML modifieur = new ModifierUML();
        int mod = constructeur.getModifiers();
        return modifieur.visibilite(mod) + "<<create>>" + constructeur.getName().toString() + "("+type()+")" + lineSeparator();
    }

    private String type()
    {
        String res ="";

        Parameter[] parametersName = constructeur.getParameters();
        for(Parameter val : parametersName)
        {
            //System.out.println("///////////////// nom param : " + val.getName());
            res += val.getName();
        }
        //System.out.println("/////////////////////////" );

        Class[] parametersType = constructeur.getParameterTypes();
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
