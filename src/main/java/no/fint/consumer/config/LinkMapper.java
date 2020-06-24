package no.fint.consumer.config;

import no.fint.consumer.utils.RestEndpoints;
import java.util.Map;
import com.google.common.collect.ImmutableMap;

import no.fint.model.personvern.kodeverk.*;

public class LinkMapper {

	public static Map<String, String> linkMapper(String contextPath) {
		return ImmutableMap.<String,String>builder()
			.put(Behandlingsgrunnlag.class.getName(), contextPath + RestEndpoints.BEHANDLINGSGRUNNLAG)
			/* .put(TODO,TODO) */
			.build();
	}

}
