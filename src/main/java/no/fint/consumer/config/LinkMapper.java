package no.fint.consumer.config;

import no.fint.consumer.utils.RestEndpoints;
import java.util.Map;
import com.google.common.collect.ImmutableMap;
import no.fint.model.personvern.kodeverk.Behandlingsgrunnlag;
import no.fint.model.personvern.kodeverk.Personopplysning;

public class LinkMapper {

    public static Map<String, String> linkMapper(String contextPath) {
        return ImmutableMap.<String,String>builder()
            .put(Behandlingsgrunnlag.class.getName(), contextPath + RestEndpoints.BEHANDLINGSGRUNNLAG)
            .put(Personopplysning.class.getName(), contextPath + RestEndpoints.PERSONOPPLYSNING)
            /* .put(TODO,TODO) */
            .build();
    }

}
