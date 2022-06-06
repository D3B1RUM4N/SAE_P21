import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldUML {
    public FieldUML() {}

    private Field field;
    int mod;

    public String lectureField(Field fVal)
    {
        field = fVal;
        mod = fVal.getModifiers();

        return visibilite() + name() + type();
    }

    private String visibilite()
    {
        String res ="";

        if(Modifier.isPublic(mod))
        {
            res+="+";
        } else if (Modifier.isPrivate(mod)) {
            res+="-";
        }

        if(Modifier.isStatic(mod)) {
            res +="{static}";
        } else if (Modifier.isAbstract(mod)) {
            res += "{abstract}";
        }

        return res;
    }

    private String name()
    {
        return field.getName();
    }

    private String type()
    {
        return ": " + field.getType().getSimpleName();
    }


}
