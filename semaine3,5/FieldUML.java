import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static java.lang.System.lineSeparator;

public class FieldUML {

    public String visibilite(Field f)
    {
        int mod = f.getModifiers();

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

}
