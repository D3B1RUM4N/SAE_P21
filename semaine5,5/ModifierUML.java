import java.lang.reflect.Modifier;

public class ModifierUML {
    public ModifierUML() {}

    int mod;
    public String visibilite(int val)
    {
        mod = val;

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

    public String access()
    {
        if(Modifier.isFinal(mod))
        {
            System.out.println("////////{readOnly}");
            return "{readOnly}";
        }
        return "";
    }
}
