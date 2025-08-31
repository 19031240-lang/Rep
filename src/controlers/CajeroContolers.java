package controlers;

import models.CajeroModels;
import views.cajeroViews;

public class CajeroContolers {
    private CajeroModels model;
    private cajeroViews views;
    private boolean sistemaActivo;

    public CajeroContolers(CajeroModels model, cajeroViews views) {
        this.model = model;
        this.views = views;
        this.sistemaActivo = true;
    }
    public void iniciarSistema(){
        views.mostrarBienvenida();
        while(sistemaActivo){
            if(autentificarUsuario()){
                ejecutarMenuPrincipal();
            }
            else{
                views.mostrarMensaje("Credenciales incorrectas");
            }
        }
        views.mostrarMensaje("Gracias por usar nuestro cajero");
    }
    private boolean autentificarUsuario(){
        String numeroCeunata=views.solicitarNumeroCuenta();
        String pin = views.solicitaPin();
        return models.autentificar(nuemroCuenta,pin);
    }
    private void ejecutarMenuPrincipal(){}
}
