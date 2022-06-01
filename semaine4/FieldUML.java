import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static java.lang.System.lineSeparator;

public class FieldUML {
    private static Field fVal;

    public String traitementField(Field f)
    {
        fVal = f;
        int mod = fVal.getModifiers();

        return visibilite(mod) + name() + type();
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
        return fVal.getName();
    }


    private String type()
    {
        return ": " + fVal.getType().getSimpleName();
    }

}
