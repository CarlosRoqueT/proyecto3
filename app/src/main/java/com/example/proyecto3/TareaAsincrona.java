package com.example.proyecto3;


import android.os.AsyncTask;

public class TareaAsincrona extends AsyncTask<Object, Void, Boolean> {
    private Comunicacion comunicacion;


    public TareaAsincrona(Comunicacion comunicacion) {
        this.comunicacion = comunicacion;
    }


    @Override
    protected void onPreExecute() {
        comunicacion.toggleProgressBar(true);
    }

    @Override
    protected Boolean doInBackground(Object... objects) {
        try {
            Thread.sleep((int)objects[2]);
            String user = (String) objects[0];
            String pass = (String) objects[1];
            if (user.equals("admin") && pass.equals("admin")){
                return true;
            }else{
                return false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    protected void onPostExecute(Boolean bo) {
        if (bo){
            this.comunicacion.lanzarActividad(Menu.class);
            this.comunicacion.showMessage("Datos Correctos");
            this.comunicacion.toggleProgressBar(false);
        }else{
            this.comunicacion.showMessage("Datos Incorrectos");

        }
    }
}
