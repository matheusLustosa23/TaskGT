package com.matheuslustosa.user_registration.config;




import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.*;
import java.util.Base64;

public class RSAGenerator {
    private static String toPem(String type, byte[] encoded) {
        String base64 = Base64.getMimeEncoder(64, new byte[]{'\n'}).encodeToString(encoded);
        return "-----BEGIN " + type + "-----\n" + base64 + "\n-----END " + type + "-----\n";
    }

    public static void main(String[] args) throws Exception {
        // path to the resources folder
        Path resourcePath = Path.of("src/main/resources");
        Files.createDirectories(resourcePath); // garante que a pasta exista

        // path to the files
        Path publicKeyPath = resourcePath.resolve("app.pub");
        Path privateKeyPath = resourcePath.resolve("app.key");

        // checked if the key files already exist
        if (Files.exists(publicKeyPath) || Files.exists(privateKeyPath)) {
            System.out.println("⚠️ Arquivos de chave já existem. Nenhuma chave foi gerada. | Key files already exist. No new keys were generated.");
            return;
        }

        // generate the RSA key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair pair = keyGen.generateKeyPair();
        PublicKey publicKey = pair.getPublic();
        PrivateKey privateKey = pair.getPrivate();



        // encode keys to base 64 and convert to PEM format
        String publicKeyContent = toPem("PUBLIC KEY", publicKey.getEncoded());
        String privateKeyContent = toPem("PRIVATE KEY", privateKey.getEncoded());

        // Save the keys to files
        try (FileOutputStream pubOut = new FileOutputStream(publicKeyPath.toFile())) {
            pubOut.write(publicKeyContent.getBytes());
        }

        try (FileOutputStream privOut = new FileOutputStream(privateKeyPath.toFile())) {
            privOut.write(privateKeyContent.getBytes());
        }

        System.out.println("✅ Chaves RSA geradas e salvas com sucesso. | RSA keys generated and saved successfully");
    }
}

