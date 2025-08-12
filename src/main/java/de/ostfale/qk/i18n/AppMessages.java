package de.ostfale.qk.i18n;

import io.quarkus.qute.i18n.Message;
import io.quarkus.qute.i18n.MessageBundle;

/**
 * Note: the @MessageBundle("AppMessages") annotation links the message bundle to the
 * resource files under src/main/resources/messages/.
 */

@MessageBundle("AppMessages")
public interface AppMessages {
    @Message("Welcome!")
    String welcome();

    @Message("Goodbye, {0}!")
    String goodbye(String name);
}
