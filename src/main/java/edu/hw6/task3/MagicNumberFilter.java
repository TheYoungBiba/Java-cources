package edu.hw6.task3;

import java.io.IOException;
import java.nio.file.Files;

public interface MagicNumberFilter {

    @SuppressWarnings("MagicNumber")
    static AbstractFilter magicNumber(int... magicBytes) {
        return path -> {
            try {
                byte[] bytes = Files.readAllBytes(path);
                if (bytes.length < magicBytes.length) {
                    return false;
                }
                for (int i = 0; i < magicBytes.length; i++) {
                    if ((bytes[i] & 0xFF) != magicBytes[i]) {
                        return false;
                    }
                }
                return true;
            } catch (IOException e) {
                return false;
            }
        };
    }

}
