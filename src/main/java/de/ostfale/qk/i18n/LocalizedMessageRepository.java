package de.ostfale.qk.i18n;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Locale;
import java.util.Optional;

@ApplicationScoped
public class LocalizedMessageRepository implements PanacheRepositoryBase<LocalizedMessage, Long> {

    public Optional<String> findMessage(String key, Locale locale) {
        Log.info("LOCALE: " + locale.toString());
        Optional<LocalizedMessage> message = find("messageKey = ?1 and langTag = ?2", key, locale.toString())
                .firstResultOptional();
        if (message.isPresent())
            return Optional.of(message.get().messageContent);

        if (!locale.getCountry().isEmpty()) {
            message = find("messageKey = ?1 and langTag = ?2", key, locale.getLanguage()).firstResultOptional();
            if (message.isPresent())
                return Optional.of(message.get().messageContent);
        }

        return Optional.empty();
    }
}
