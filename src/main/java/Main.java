import controller.Controller;
import models.Polynomial;
import view.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Polynomial model = new Polynomial();
        Controller controller = new Controller(view, model);
    }
}



