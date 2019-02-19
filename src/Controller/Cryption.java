/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

/**
 *
 * @author Eric Embestro
 */
public class Cryption {
    
    private Cipher encrypt;
    private Cipher decrypt;
    
    private SecretKey key;
    
    public Cryption() {
        
        try {
             
             // generate secret key using DES algorithm
             key = KeyGenerator.getInstance("DES").generateKey();
             
             encrypt = Cipher.getInstance("DES");
             decrypt = Cipher.getInstance("DES");
             
             // initialize the ciphers with the given key
             
             encrypt.init(Cipher.ENCRYPT_MODE, key);
             decrypt.init(Cipher.DECRYPT_MODE,key);
             
             // create a sealed object
             
             SealedObject sealed = new SealedObject(new SecretObject("My secret message"), encrypt);
                          
             // get the algorithm with the object has been sealed
             
             String algorithm = sealed.getAlgorithm();
             
             System.out.println("Algorithm " + algorithm);
             
             // unseal (decrypt) the object
             
             SecretObject o = (SecretObject) sealed.getObject(decrypt);
             
             System.out.println("Original Object " + o);
         }
         catch (NoSuchAlgorithmException e) {
             System.out.println("No Such Algorithm:" + e.getMessage());
             return;
         }
         catch (NoSuchPaddingException e) {
             System.out.println("No Such Padding:" + e.getMessage());
             return;
         }
         catch (BadPaddingException e) {
             System.out.println("Bad Padding:" + e.getMessage());
             return;
         }
         catch (InvalidKeyException e) {
             System.out.println("Invalid Key:" + e.getMessage());
             return;
         }
         catch (IllegalBlockSizeException e) {
             System.out.println("Illegal Block:" + e.getMessage());
             return;
         }
         catch (ClassNotFoundException e) {
             System.out.println("Class not found:" + e.getMessage());
             return;
         }
         catch (IOException e) {
             System.out.println("I/O Error:" + e.getMessage());
             return;
         }
        
    }
}
