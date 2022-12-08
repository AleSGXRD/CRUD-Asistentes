/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

/**
 *
 * @author AleXRD
 */
public class GestionDeCuentas {
    	static String direc = "C:\\dataAleXRD.bin";
    //GuardarDatos de CLIENTES
    public static void GuardarDatos(Vector<Persona> datos) throws FileNotFoundException,IOException{
        File file = new File(direc);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        DataOutputStream outStream = new DataOutputStream(fileOutputStream);
        
        outStream.writeInt(datos.size());
        
        for(int i =0;i<datos.size();i++){
            outStream.writeUTF(datos.get(i).getNombre());
            outStream.writeUTF(datos.get(i).getApellido());
            outStream.writeUTF(datos.get(i).getCI());
            outStream.writeUTF(datos.get(i).getDireccion());
            outStream.writeInt(datos.get(i).getEdad());
        }
        
        outStream.flush();
        outStream.close();
    }
    //CargarDatos de CLIENTES
    public static Vector<Persona> CargarDatos() throws FileNotFoundException,IOException,ClassNotFoundException{
        File file = new File(direc);
        Vector<Persona> users=new Vector<Persona>();
        
        FileInputStream fileInputStream = new FileInputStream(file);
        DataInputStream InStream = new DataInputStream(fileInputStream);
        
        int capacidad = InStream.readInt();
        
        for(int i =0;i<capacidad;i++){
            String nombre = InStream.readUTF();
            String apellido = InStream.readUTF();
            String ci = InStream.readUTF();
            String direc = InStream.readUTF();
            int edad = InStream.readInt();
            Persona info =new Persona(nombre,apellido,ci,direc,edad);
            
            users.add(info);
        }
        InStream.close();
        return users;
        
    }
    public static Vector<Persona> Register_Client(Persona info, Vector<Persona> users) throws Exception{
        for(int i =0;i<users.size();i++){
            if(users.get(i).getCI().equals(info.getCI())){
                throw new Exception("Ya se encuentra el nombre del usuario");
            }
        }
        users.add(info);
        GuardarDatos(users);
        return users;
    }
    public static Vector<Persona> Delete_Client(String CI,Vector<Persona> users){
        for(int i =0;i<users.size();i++){
            if(users.get(i).getCI().equals(CI)){
                users.remove(i);
                return users;
            }
        }
        return users;
    }
    public static void leer(Vector<Persona>users) {
    	for(int i =0;i<users.size();i++) {
    		System.out.println(i+"-"+users.get(i).getNombre()+" "+users.get(i).getApellido());
    	}
    }
    
}
