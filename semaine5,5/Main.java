public class Main {
    public void Main(String[] args)
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
