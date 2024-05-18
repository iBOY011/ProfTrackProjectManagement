package ma.ac.usms.ensak.metier.Services;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

public class GoogleOAuth2Login {
    private static final String CLIENT_SECRET_FILE = "/.configs/client_secret.json";
    private static final List<String> SCOPES = Arrays.asList("https://www.googleapis.com/auth/drive.metadata.readonly");
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static HttpTransport httpTransport;
    private static final String TOKENS_DIRECTORY_PATH = "src/main/resources/.tokens";

    public static Credential authorize() throws IOException, GeneralSecurityException, InterruptedException {
        ensureTokensDirectoryExists();  // Ensure the tokens directory exists

        httpTransport = GoogleNetHttpTransport.newTrustedTransport();

        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY,
                new InputStreamReader(GoogleOAuth2Login.class.getResourceAsStream(CLIENT_SECRET_FILE)));

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                httpTransport, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();

        return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver.Builder().setPort(8888).build())
                .authorize("user");
    }

    private static void ensureTokensDirectoryExists() {
        File tokensDir = new File(TOKENS_DIRECTORY_PATH);
        if (!tokensDir.exists()) {
            tokensDir.mkdirs();
        }
    }

    public static void logout() throws IOException {
        File tokensDir = new File(TOKENS_DIRECTORY_PATH);
        if (tokensDir.exists()) {
            for (File file : tokensDir.listFiles()) {
                if (!file.isDirectory()) {
                    file.delete();
                }
            }
        }
    }
}
