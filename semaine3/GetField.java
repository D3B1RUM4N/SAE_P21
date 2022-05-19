import java.lang.reflect.Field;

import static java.lang.System.lineSeparator;

public class GetField {
    public static void umlAtribute()
    {
        try {
            Field[] attribut = Init.cName.getDeclaredFields();
            for(Field val : attribut)
            {
                int mod = val.getModifiers();
                String vis = Init.visibilité(mod);

                Init.stringClass += vis + val.getName()+ ": " + val.getType().getSimpleName() + lineSeparator();
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
