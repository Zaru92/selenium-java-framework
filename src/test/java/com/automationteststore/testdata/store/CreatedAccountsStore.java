package com.automationteststore.testdata.store;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreatedAccountsStore {

    private static final Path FILE = Path.of("created-accounts.csv");

    private static final Object LOCK = new Object();

    public static void save(String username, String password) {
        String ts = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        String line = String.format(
                "%s,%s,%s%n",
                ts,
                escapeCsv(username),
                escapeCsv(password)
        );

        synchronized (LOCK) {
            try {

                if (Files.notExists(FILE)) {
                    Files.writeString(
                            FILE,
                            "timestamp,username,password\n",
                            StandardCharsets.UTF_8,
                            StandardOpenOption.CREATE
                    );
                }

                Files.writeString(
                        FILE,
                        line,
                        StandardCharsets.UTF_8,
                        StandardOpenOption.APPEND
                );

            } catch (IOException e) {
                throw new RuntimeException(
                        "Could not write created account to: " + FILE.toAbsolutePath(),
                        e
                );
            }
        }
    }

    private static String escapeCsv(String s) {
        if (s == null) return "";
        boolean needsQuotes =
                s.contains(",") || s.contains("\"") || s.contains("\n") || s.contains("\r");

        String escaped = s.replace("\"", "\"\"");
        return needsQuotes ? "\"" + escaped + "\"" : escaped;
    }
}
