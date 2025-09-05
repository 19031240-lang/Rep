import controllers.CajeroControlles;
import models.CajeroModels;
import views.CajeroViews;

public class main {
    public static void main(String[] args) {
        CajeroModels model = new CajeroModels();
        CajeroViews views = new CajeroViews();
        CajeroControlles controller = new CajeroControlles(model, views);

        controller.iniciarSistema();
    }
}
