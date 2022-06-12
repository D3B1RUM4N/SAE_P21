import java.lang.reflect.*;

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
//        String val = methode.getReturnType().getSimpleName();
//        if (val.contains("void")) {
//            return "";
//        } else if (val.contains("String")) {
//            return ": String";
//        } else if (val.contains("int")) {
//            return ": Integer";
//        } else {
//            return ": " + val;
//        }
        String type = "";
        Type t = methode.getGenericReturnType();


        if (t instanceof ParameterizedType) {

            ParameterizedType paramType = (ParameterizedType) t;
            // On récupère tous les types
            Type[] arr = paramType.getActualTypeArguments();

            String typeStr = "";
            String typeSplt = "";

            for (Type type1 : arr) {

                // On split avec les virgules
                String tab[] = type1.getTypeName().split(", ");

                // Pour après
                String tab2[];

                // Si c'est une Map
                if(t.toString().contains("Map"))

                {

                    String typeTemporaire = "";
                    for (int i = 0; i < tab.length; i++) {
                        typeSplt += tab[i];
                        System.out.println(typeSplt);
                        tab2 = typeSplt.split("\\.");

                        typeTemporaire = tab2[tab2.length - 1];
                    }

                    typeStr = typeTemporaire + "[*]";


                }
                else{
                    for (int i = 0; i < tab.length; i++) {
                        typeSplt += tab[i];
                        tab2 = typeSplt.split("\\.");

                        typeStr = tab2[tab2.length - 1];
                        //System.out.println("test : "+typeStr);
                    }
                    typeStr += "[*]" ;
                }

                if(type1 instanceof ParameterizedType){
                    returnType();
                }
            }

            type = typeStr;
        }
        else{

            String typeNormal[];

            //System.out.println(t.getTypeName());

            typeNormal = t.getTypeName().split("\\.");
            //System.out.println("type normal : " + typeNormal[typeNormal.length-1]);

            String retour = typeNormal[typeNormal.length-1];

            if (retour.compareTo("int") == 0 || retour.compareTo("long") == 0 || retour.compareTo("int[]") == 0 || retour.compareTo("long[]") == 0) {
                type = "Integer";
                if(retour.contains("[]"))
                {
                    type = type + "[*]";
                }
            } else if (retour.compareTo("string") == 0 || retour.compareTo("char") == 0 || retour.compareTo("string[]") == 0 || retour.compareTo("char[]") == 0) {
                type = "String";
                if(retour.contains("[]"))
                {
                    type = type + "[*]";
                }
            } else if (retour.compareTo("boolean") == 0 || retour.compareTo("boolean[]") == 0) {
                type = "Boolean";
                if(retour.contains("[]"))
                {
                    type = type + "[*]";
                }
            }
            else if(retour.compareTo("void") == 0)
            {
                type = "";
            }
            else if(retour.contains("[]"))
            {
                type = retour.substring(0,retour.length()-2) + "[*]";
            }
            else{
                type = typeNormal[typeNormal.length-1];
            }

        }


        if(type.contains(">")){
            String CollecSplit[] = type.split(">");
            for(int i=0; i<CollecSplit.length;i++){
                type = CollecSplit[0]+"[*]";
            }
        }

        if(t.toString().contains("Map") || t.toString().contains("Set"))
        {
            type = type + " {isUnique}";
        }
        else if(t.toString().contains("List") || t.toString().contains("Queue") || t.toString().contains("Vector") || t.toString().contains("HashTable"))
        {
            type = type + " {isOrdered}";
        }

    return type;
    }

        //System.out.println("////////////" + methode.getName());
        //System.out.println("///" + methode.getReturnType().getTypeName());




}
