package emanuelmcp.io.github.skills.database;

import org.jetbrains.annotations.NotNull;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EncryptUtils {
    public String hashPasswordWithSHA256 (@NotNull String password) {
        MessageDigest md;
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        byte[] hash = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for(byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    /*
    La contraseña tiene al menos 8 caracteres y maximo de 20 caracteres
    La contraseña tiene al menos una letra mayúscula
    La contraseña tiene al menos una letra minúscula
    La contraseña tiene al menos un dígito
    La contraseña tiene al menos un carácter especial
    */
    public boolean passwordIsValid(@NotNull String password){
        final String PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        Pattern passwordPattern = Pattern.compile (PATTERN);
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.matches();
    }

    public boolean passwordIsCorrect(@NotNull String hash, @NotNull String password){
        return hash.equals(hashPasswordWithSHA256(password));
    }
}
