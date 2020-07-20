import java.math.BigInteger;

/**
 * Test Section of RSA Generator
 * 
 * @author obikag
 * @since 2013-06-22
 */
public class RSATest {
	public static void main(String[] args) throws Exception {
		// Create a new RSA Generator Object of 64 bit length
		RSAGenerator rsa_gen = new RSAGenerator(64);
		// Create a message to encrypt
		String msg = "This is my gladfeeffeefe";
		// Encrypt message
		String encrypted = rsa_gen.encrypt(msg).toString();
		// Decrypt message
		BigInteger decrypt = rsa_gen.decrypt(new BigInteger(encrypted));
		String decrypted = "";
		// BigInteger must be converted to a byte array in order to rebuild the
		// original message
		for (byte b : decrypt.toByteArray()) {
			decrypted += (char) b;
		}
		System.out.println("Original Message: " + msg);
		System.out.println(rsa_gen.toString());
		System.out.println("Encrypted: " + encrypted);
		System.out.println("Decrypted: " + decrypted);

		/*
		 * Example Output:
		 * 
		 * Original Message: This is a test!! Public Key -> Component:
		 * 14493509104177907227 / Modulus:
		 * 112625708915384646043981538437387484617 Private Key -> Component:
		 * 7249569340342942776596243374501560163 / Modulus:
		 * 112625708915384646043981538437387484617 Encrypted:
		 * 79682373572381863577079732109682216626 Decrypted: This is a test!!
		 * 
		 */
	}
}