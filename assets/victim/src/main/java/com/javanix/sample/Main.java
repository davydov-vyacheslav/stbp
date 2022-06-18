package com.javanix.sample;

import org.apache.commons.io.IOUtils;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Properties;

public class Main {
	public static void main(String[] args) throws Exception {
		System.out.println("Reading plaintext data from external resources: ");
		System.out.println(MessageRetriever.getSimpleTextFromGithub());
		System.out.println(MessageRetriever.getSimpleTextFromIp());

		// How it was encrypted ...
//		PrivateKey privateKey = getPrivateKey("/Users/davs/dev/IdeaProjects/javaagent-victim/private_key.der");
//		final String textToEncode = "Hello, world";
//		Cipher encrypt = Cipher.getInstance("RSA/ECB/PKCS1Padding");
//		encrypt.init(Cipher.ENCRYPT_MODE, privateKey);
//		byte[] encryptedMessage1 = encrypt.doFinal(textToEncode.getBytes(StandardCharsets.UTF_8));
//		System.out.println(Base64.getEncoder().encodeToString(encryptedMessage1));

		PublicKey publicKey = getPublicKey("public_key.der");
		Properties properties = new Properties();
		properties.load(Main.class.getClassLoader().getResourceAsStream("messages.properties"));
		String encryptedMessage = properties.getProperty("mytext");
		Cipher decrypt=Cipher.getInstance("RSA/ECB/PKCS1Padding");
		decrypt.init(Cipher.DECRYPT_MODE, publicKey);
		String decryptedMessage = new String(decrypt.doFinal(Base64.getDecoder().decode(encryptedMessage.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8);
		System.out.println("DecryptedText: " + decryptedMessage);

	}

	private static PrivateKey getPrivateKey(String filename) throws Exception {
		byte[] keyBytes = Files.readAllBytes(Paths.get(filename));
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePrivate(spec);
	}

	private static PublicKey getPublicKey(String filename) throws Exception {
		byte[] keyBytes = IOUtils.resourceToByteArray(filename, Main.class.getClassLoader());
		X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		return kf.generatePublic(spec);
	}

}