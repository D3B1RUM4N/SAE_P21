import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldUML {
    public FieldUML() {}

    private Field field;
    private int mod;

    public String lectureField(Field fVal)
    {
        field = fVal;
        mod = fVal.getModifiers();
        ModifierUML modifieur = new ModifierUML();
        return modifieur.visibilite(mod) + name() + type() + modifieur.access();
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
