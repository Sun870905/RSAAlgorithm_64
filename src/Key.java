import java.math.BigInteger;

/**
 * Key class used to store the key's Component and Modulus
 * 
 * @author obikag
 * @since 2013-06-22
 */
public class Key {

	private BigInteger component; // Component
	private BigInteger modulus; // Modulus

	/**
	 * Object Constructor
	 * 
	 * @param component
	 *            Component of Key
	 * @param modulus
	 *            Modulus
	 */
	Key(BigInteger component, BigInteger modulus) {
		this.component = component;
		this.modulus = modulus;
	}

	/**
	 * Method used to return the Component of the Key
	 * 
	 * @return BigInteger value of key's Component
	 */
	public BigInteger getComponent() {
		return component;
	}

	/**
	 * Method used to return the Modulus
	 * 
	 * @return BigInteger value of Modulus
	 */
	public BigInteger getModulus() {
		return modulus;
	}

	/**
	 * Prints to screen Key Information
	 */
	@Override
	public String toString() {
		return "Component: " + component + " / Modulus: " + modulus;
	}
}