package de.ostfale.qk.i18n;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.UriInfo;

import java.util.List;
import java.util.Locale;

@RequestScoped
public class CurrentRequestLocale {

    @Context
    UriInfo uriInfo;

    @Context
    HttpHeaders headers;

    public Locale get() {
        String lang = uriInfo.getQueryParameters().getFirst("lang");
        if (lang != null && !lang.isBlank()) {
            Log.info("Locale from query parameter: " + lang);
            return Locale.forLanguageTag(lang);
        }

        List<Locale> locales = headers.getAcceptableLanguages();
        if (!locales.isEmpty()) {
            Log.info("Locale from Accept-Language header: " + locales.getFirst());
            return locales.getFirst();
        }

        return Locale.ENGLISH;
    }
}
