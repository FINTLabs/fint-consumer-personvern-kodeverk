package no.fint.consumer.models.personopplysning;

import no.fint.model.resource.personvern.kodeverk.PersonopplysningResource;
import no.fint.model.resource.personvern.kodeverk.PersonopplysningResources;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

@Component
public class PersonopplysningLinker extends FintLinker<PersonopplysningResource> {

    public PersonopplysningLinker() {
        super(PersonopplysningResource.class);
    }

    public void mapLinks(PersonopplysningResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public PersonopplysningResources toResources(Collection<PersonopplysningResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public PersonopplysningResources toResources(Stream<PersonopplysningResource> stream, int offset, int size, int totalItems) {
        PersonopplysningResources resources = new PersonopplysningResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(PersonopplysningResource personopplysning) {
        return getAllSelfHrefs(personopplysning).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(PersonopplysningResource personopplysning) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(personopplysning.getSystemId()) && !isEmpty(personopplysning.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(personopplysning.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(PersonopplysningResource personopplysning) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(personopplysning.getSystemId()) && !isEmpty(personopplysning.getSystemId().getIdentifikatorverdi())) {
            builder.add(personopplysning.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

