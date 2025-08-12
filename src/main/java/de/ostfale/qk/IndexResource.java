package de.ostfale.qk;

import de.ostfale.qk.i18n.CurrentRequestLocale;
import io.quarkus.logging.Log;
import io.quarkus.qute.Template;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Locale;

@Path("/")
public class IndexResource {

    @Inject
    Template index;

    @Inject
    CurrentRequestLocale currentRequestLocale;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String get() {
        Locale locale = new Locale(currentRequestLocale.get().getLanguage());
        Log.info("Locale from IndexResource: " + locale);
        return index.instance().setLocale(locale).data("locale", locale).render();
    }
}
