import java.math.*;
import java.security.SecureRandom;

/**
 * RSA Generator class is used to calculate the private and public keys, based
 * on a specified bit length. Encrypt and Decrypt Methods also defined below.
 * 
 * @author obikag
 * @since 2013-06-22
 */
public class RSAGenerator {

	private Key publickey; // Public Key
	private Key privatekey; // Private key
	private static final BigInteger ONE = BigInteger.ONE; // Value of 1
															// expressed as a
															// BigInteger for
															// ease of
															// calculation

	/**
	 * Object Constructor
	 * 
	 * @param numbits
	 *            Bit Length used to generate the various components
	 */
	public RSAGenerator(int numbits) {
		// Generate p and q
		BigInteger p = BigInteger.probablePrime(numbits, new SecureRandom());
		BigInteger q = BigInteger.probablePrime(numbits, new SecureRandom());
		// Compute n - modulus
		BigInteger n = p.multiply(q);
		// Compute Euler's totient function, phiN
		BigInteger p_minus_one = p.subtract(ONE);
		BigInteger q_minus_one = q.subtract(ONE);
		BigInteger phiN = p_minus_one.multiply(q_minus_one);
		// Calculate public exponent
		BigInteger e, d;
		do {
			e = BigInteger.probablePrime(numbits, new SecureRandom());
		} while ((e.compareTo(ONE) == 1) && (e.compareTo(phiN) == -1) && (e.gcd(phiN).compareTo(ONE) != 0));
		// Calculate private exponent
		d = e.modInverse(phiN);
		// Set Keys
		publickey = new Key(e, n);
		privatekey = new Key(d, n);
	}

	/**
	 * Method used to encrypt a message string
	 * 
	 * @param msg
	 *            Message string to be encrypted
	 * @return BigInteger value of encrypted message
	 */
	public BigInteger encrypt(String msg) {
		return (new BigInteger(msg.getBytes())).modPow(publickey.getComponent(), publickey.getModulus());
	}

	/**
	 * Method used to decrypt a message
	 * 
	 * @param encrypt_msg
	 *            Encrypted message as a BigInteger
	 * @return BigInteger value of decrypted string
	 */
	public BigInteger decrypt(BigInteger encrypt_msg) {
		return encrypt_msg.modPow(privatekey.getComponent(), privatekey.getModulus());
	}

	/**
	 * Prints to screen Public and Private key components
	 */
	@Override
	public String toString() {
		return "Public Key -> " + publickey.toString() + "\nPrivate Key -> " + privatekey.toString();
	}
}