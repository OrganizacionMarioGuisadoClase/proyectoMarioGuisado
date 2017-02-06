package es.albarregas.beans;

import java.io.Serializable;


public class General implements Serializable{
    
    private double gastosEnvio;
    private double iva;

    /**
     * @return the gastosEnvio
     */
    public double getGastosEnvio() {
        return gastosEnvio;
    }

    /**
     * @param gastosEnvio the gastosEnvio to set
     */
    public void setGastosEnvio(double gastosEnvio) {
        this.gastosEnvio = gastosEnvio;
    }

    /**
     * @return the iva
     */
    public double getIva() {
        return iva;
    }

    /**
     * @param iva the iva to set
     */
    public void setIva(double iva) {
        this.iva = iva;
    }
    
    
    
}
