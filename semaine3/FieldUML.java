import java.lang.reflect.Field;

import static java.lang.System.lineSeparator;

public class FieldUML {

    public String visibilite(int mod)
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
    public String name(Field val)
    {
        return val.getName();
    }


    public void type(int mod)
    {


        Init.stringClass += vis + val.getName()+ ": " + val.getType().getSimpleName() + lineSeparator();
    }

    public static String visibilité(int mod)
    {

    }
}
