/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.Serializable;

/**
 *
 * @author Eric Embestro
 */
public class SecretObject implements Serializable{
    
    private static long serialVersionUID = -1335351770906357695L;
    
    private final String message;

    public SecretObject(String message) {
        this.message = message;
    }
    
    @Override
    public String toString() {
        return "SecretObject[message=" + message + "]";
    }
}
