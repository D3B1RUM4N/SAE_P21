import java.lang.reflect.Method;

import static java.lang.System.lineSeparator;

public class GetMethod {

    public static void umlMethode()
    {
        int mod;
        try {
            Method[] methode = Init.cName.getDeclaredMethods();
            for(Method val : methode)
            {
                mod = val.getModifiers();
                //System.out.println("//////////"+Modifier.toString(mod));
                String vis = Init.visibilité(mod);
                String param = type(val);
                Init.stringClass += vis + val.getName() + "()" + param + lineSeparator();
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

        //System.out.println("La classe de l'objet obj est : " + c.getName())
    }


    private static String type(Method mod)
    {
        String res ="";
        Class[] parameters = mod.getParameterTypes();
        for(Class val : parameters)
        {
            if(val.getSimpleName().contains("int"))
            {
                res += ": Integer ";
            }
            else
            {
                res += ": "+val.getSimpleName() + " ";
            }

        }
        //System.out.println("//////////////////////" + res);
        return res;
    }
}
