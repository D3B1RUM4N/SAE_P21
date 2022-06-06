public class Main {

    public static void main(String[] args)
    {
        if(args[0] != null)
        {
            Controls ctrl = new Controls();
            ctrl.controls(args[0]);
        }
        else {
            System.out.println("Veuillez choisir un fichier class a lancé.");
            return;
        }
    }

}
