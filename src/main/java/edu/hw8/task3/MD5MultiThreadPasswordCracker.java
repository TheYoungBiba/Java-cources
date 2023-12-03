package edu.hw8.task3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MD5MultiThreadPasswordCracker implements PasswordCracker {
    private Map<String, String> passwordMap;

    private final int countOfThreads;

    public MD5MultiThreadPasswordCracker(Map<String, String> passwordMap) {
        this.passwordMap = passwordMap;
        countOfThreads = Runtime.getRuntime().availableProcessors();
    }

    public MD5MultiThreadPasswordCracker(Map<String, String> passwordMap, int countOfThreads) {
        this.passwordMap = passwordMap;
        this.countOfThreads = countOfThreads;
    }

    @Override
    public Map<String, String> crackPasswords() {
        Map<String, String> crackedPasswordsMap = new HashMap<>();
        ExecutorService executor = Executors.newFixedThreadPool(countOfThreads);
        for (Map.Entry<String, String> entry : passwordMap.entrySet()) {
            String userName = entry.getKey();
            String expectedHash = entry.getValue();
            Runnable task = () -> {
                final int PASSWORDS = 1000000;
                for (int i = 0; i < PASSWORDS; i++) {
                    String tempPassword = generatePassword(i);
                    if (getMD5Hash(tempPassword).equals(expectedHash)) {
                        crackedPasswordsMap.put(userName, tempPassword);
                        break;
                    }
                }
            };
            executor.execute(task);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            return null;
        }
        return crackedPasswordsMap;
    }

    @SuppressWarnings("MagicNumber")
    private String generatePassword(int number) {
        return String.format("%06d", number);
    }

    @SuppressWarnings("MagicNumber")
    private String getMD5Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
