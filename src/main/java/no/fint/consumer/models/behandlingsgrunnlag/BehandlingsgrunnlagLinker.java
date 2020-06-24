package no.fint.consumer.models.behandlingsgrunnlag;

import no.fint.model.resource.personvern.kodeverk.BehandlingsgrunnlagResource;
import no.fint.model.resource.personvern.kodeverk.BehandlingsgrunnlagResources;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

@Component
public class BehandlingsgrunnlagLinker extends FintLinker<BehandlingsgrunnlagResource> {

    public BehandlingsgrunnlagLinker() {
        super(BehandlingsgrunnlagResource.class);
    }

    public void mapLinks(BehandlingsgrunnlagResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public BehandlingsgrunnlagResources toResources(Collection<BehandlingsgrunnlagResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public BehandlingsgrunnlagResources toResources(Stream<BehandlingsgrunnlagResource> stream, int offset, int size, int totalItems) {
        BehandlingsgrunnlagResources resources = new BehandlingsgrunnlagResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(BehandlingsgrunnlagResource behandlingsgrunnlag) {
        return getAllSelfHrefs(behandlingsgrunnlag).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(BehandlingsgrunnlagResource behandlingsgrunnlag) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(behandlingsgrunnlag.getSystemId()) && !isEmpty(behandlingsgrunnlag.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(behandlingsgrunnlag.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(BehandlingsgrunnlagResource behandlingsgrunnlag) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(behandlingsgrunnlag.getSystemId()) && !isEmpty(behandlingsgrunnlag.getSystemId().getIdentifikatorverdi())) {
            builder.add(behandlingsgrunnlag.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

