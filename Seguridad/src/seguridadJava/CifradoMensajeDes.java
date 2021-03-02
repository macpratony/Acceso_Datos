package seguridadJava;

	import java.security.InvalidKeyException;
	import java.security.NoSuchAlgorithmException;
	import java.security.spec.InvalidKeySpecException;
	import java.security.spec.KeySpec;

	import javax.crypto.BadPaddingException;
	import javax.crypto.Cipher;
	import javax.crypto.IllegalBlockSizeException;
	import javax.crypto.KeyGenerator;
	import javax.crypto.NoSuchPaddingException;
	import javax.crypto.SecretKey;
	import javax.crypto.SecretKeyFactory;
	import javax.crypto.spec.DESKeySpec;
	import javax.crypto.spec.SecretKeySpec;

public class CifradoMensajeDes {
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			System.out.println("Obteniendo generador de claves con cifrado DES");
			try {
				KeyGenerator keygen=KeyGenerator.getInstance("DES");
				
				System.out.println("Generando claves");
				
				SecretKey key=keygen.generateKey();
				
				System.out.println("Obtengo clave transparente");
				SecretKeyFactory keyfac=SecretKeyFactory.getInstance("DES");
				DESKeySpec keyspec=(DESKeySpec)keyfac.getKeySpec(key, DESKeySpec.class);
				System.out.println("Clave transparente: "+new String(keyspec.getKey()));
				
				System.out.println("Obteniendo generador Cipher con cifrado DES");
				
				Cipher desCipher = Cipher.getInstance("DES");
				
				System.out.println("Configurando Cipher para encriptar");
				
				desCipher.init(Cipher.ENCRYPT_MODE,key);
				
				System.out.println("Preparando mensaje");
				
				String mensaje="Mensaje de prueba";
				
				System.out.println("Mensaje original: "+mensaje);
				
				System.out.println("Cifrando mensaje mensaje");
				
				String mesnajeCifrado=new String(desCipher.doFinal(mensaje.getBytes()));
				
				System.out.println("Mensaje cifrado: "+mesnajeCifrado);
				
				System.out.println("Configurando Cipher para desencriptar");
				
				desCipher.init(Cipher.DECRYPT_MODE,key);
				
				System.out.println("Descifrando mensaje");
				
				String mesnajeDescifrado=new String(desCipher.doFinal(mesnajeCifrado.getBytes()));
				
				System.out.println("Mensaje descifrado: "+mesnajeDescifrado);
				
				// Con clave transparente
				byte[] keySecret= keyspec.getKey();
				SecretKeySpec secretKeySpec = new SecretKeySpec(keySecret, "DES");
				desCipher.init(Cipher.DECRYPT_MODE,secretKeySpec);
				mesnajeDescifrado=new String(desCipher.doFinal(mesnajeCifrado.getBytes()));
				System.out.println("Mensaje descifrado a traves de clave transparente: "+mesnajeDescifrado);
				
			} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalBlockSizeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BadPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();			

			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
