public class Main {

    public static void main(String[] args)
    {
        String stringClass = "";
        Ecriture write = new Ecriture();
        /******* Debut écriture *******/
        stringClass += write.debutEcriture();

        if(args[0] != null)
        {
            for(String val : args)
            {
                Controls ctrl = new Controls();
                stringClass += ctrl.controls(val);
            }
        }
        else {
            System.out.println("Veuillez choisir un fichier class a lancé.");
            return;
        }

        /******* Fin écriture *******/

        stringClass += write.finEcriture();

        ToUML print = new ToUML();
        print.ecriturePUML(stringClass);

        //System.out.println(stringClass);
    }

}
