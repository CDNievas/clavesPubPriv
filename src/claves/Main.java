package claves;

public class Main {

	public static void main(String[] args) throws Exception {

		
		Usuario A = new Usuario("Juan");
		Usuario B = new Usuario("Carlos");
		
		casoUno(A,B);
		System.out.println("------------------------------------------------");
		casoDos(A,B);
		System.out.println("------------------------------------------------");
		//casoTres(A,B);
		
	}
	
	
	// CASO 1:
	// A envia un mensaje encriptado con su clave privada a B y B lo desencripta con la clave publica de A.
	// B puede confirmar que quien le envio el mensaje es A.
	// El mensaje puede abrirlo cualquier persona que tenga el mensaje encriptado y la clave publica de A.
	public static void casoUno(Usuario usuarioRem, Usuario usuarioDest) throws Exception{
		
		String mensaje = "Hola como andas bb?";
		byte[] mensajeEncriptado = usuarioRem.encriptarMensajeConClavePrivada(mensaje.getBytes());
		byte[] mensajeDesencriptado = usuarioDest.desencriptarMensajeConClavePublicaDe(usuarioRem,mensajeEncriptado);
		
		System.out.println(usuarioRem.nombre + " envia mensaje a " + usuarioDest.nombre);
		System.out.println("Mensaje original: " + mensaje);
		System.out.println("Mensaje encriptado: " + new String(mensajeEncriptado));
		System.out.println("Mensaje desencriptado: " + new String(mensajeDesencriptado));
		
	}
	
	
	// CASO 2:
	// A envia un mensaje encriptado con la clave publica de B a B y B lo desencripta con su propia clave privada.
	// B no puede confirmar quien le envio el mensaje.
	// A se asegura de que solo B pueda leer el mensaje, ya que solo B tiene su clave privada.
	public static void casoDos(Usuario usuarioRem, Usuario usuarioDest) throws Exception{
		
		String mensaje = "Bokita rey de copas";
		byte[] mensajeEncriptado = usuarioRem.encriptarMensajeConClavePublicaDe(usuarioDest, mensaje.getBytes());
		byte[] mensajeDesencriptado = usuarioDest.desencriptarMensajeConClavePrivada(mensajeEncriptado);
		
		System.out.println(usuarioRem.nombre + " envia mensaje a " + usuarioDest.nombre);
		System.out.println("Mensaje original: " + mensaje);
		System.out.println("Mensaje encriptado: " + new String(mensajeEncriptado));
		System.out.println("Mensaje desencriptado: " + new String(mensajeDesencriptado));
		
	}
	
	
	// CASO 3: (Rompe feo)
	// A encripta un mensaje con su llave privada y lo vuelve a encriptar con la llave publica de B.
	// A envia el mensaje a B
	// B desencripta el mensaje con su llave privada asegurando que solo el lo pueda leer.
	// B vuelve a desencriptar el mensaje usando la llave publica de A confirmando que A fue quien lo escribio.
	public static void casoTres(Usuario usuarioRem, Usuario usuarioDest) throws Exception{
		
		String mensaje = "Aguante manaos";
		byte[] mensajeEncriptado = usuarioRem.encriptarMensajeConClavePrivada(mensaje.getBytes());
		mensajeEncriptado = usuarioRem.encriptarMensajeConClavePublicaDe(usuarioDest,mensajeEncriptado);

		byte[] mensajeDesencriptado = usuarioDest.desencriptarMensajeConClavePrivada(mensajeEncriptado);
		mensajeDesencriptado = usuarioDest.desencriptarMensajeConClavePublicaDe(usuarioRem, mensajeDesencriptado);
		
		System.out.println(usuarioRem.nombre + " envia mensaje a " + usuarioDest.nombre);
		System.out.println("Mensaje original: " + mensaje);
		System.out.println("Mensaje encriptado: " + new String(mensajeEncriptado));
		System.out.println("Mensaje desencriptado: " + new String(mensajeDesencriptado));
		
	}

}
