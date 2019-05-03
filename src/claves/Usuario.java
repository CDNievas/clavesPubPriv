package claves;

import java.security.PublicKey;
import java.security.PrivateKey;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

public class Usuario {

	public String nombre;
	public PublicKey clavePublica;
	private PrivateKey clavePrivada;

	public Usuario(String nombre) throws NoSuchAlgorithmException{
		
		KeyPair keys = RSA.generarKeys();
		
		this.nombre = nombre;
		this.clavePrivada = keys.getPrivate();
		this.clavePublica = keys.getPublic();
		
	}
	
	// Yo puedo encriptar/desencriptar usando mi llave publica o privada
	public byte[] encriptarMensajeConClavePrivada(byte[] mensajeAEncriptar) throws Exception{
		return RSA.encriptar(this.clavePrivada, mensajeAEncriptar);
	}
	
	public byte[] desencriptarMensajeConClavePrivada(byte[] mensajeADesencriptar) throws Exception{
		return RSA.desencriptar(this.clavePrivada, mensajeADesencriptar);
	}

	public byte[] encriptarMensajeConClavePublica(byte[] mensajeAEncriptar) throws Exception{
		return RSA.encriptar(this.clavePublica, mensajeAEncriptar);
	}
	
	public byte[] desencriptarMensajeConClavePublica(byte[] mensajeADesencriptar) throws Exception{
		return RSA.desencriptar(this.clavePublica, mensajeADesencriptar);
	}
	
	// Con otros solo puedo encriptar y desencriptar usando su clave publica
	public byte[] desencriptarMensajeConClavePublicaDe(Usuario usuario, byte[] mensajeADesencriptar)throws Exception{
		return usuario.desencriptarMensajeConClavePublica(mensajeADesencriptar);
	}
	
	public byte[] encriptarMensajeConClavePublicaDe(Usuario usuario, byte[] mensajeAEncriptar)throws Exception{
		return usuario.encriptarMensajeConClavePublica(mensajeAEncriptar);
	}
	
}
