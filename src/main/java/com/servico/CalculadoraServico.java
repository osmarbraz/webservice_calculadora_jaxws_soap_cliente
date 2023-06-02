package com.servico;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Interface dos métodos remotos.
 *
 * @author osmar
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface CalculadoraServico {

    @WebMethod
    public double getSoma(double a, double b);

    @WebMethod
    public double getDiferenca(double a, double b);

    @WebMethod
    public double getProduto(double a, double b);

    @WebMethod
    public double getQuociente(double a, double b);

}
