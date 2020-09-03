// Built from tag personvern

package no.fint.model.resource.personvern.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collection;
import java.util.List;

import lombok.NoArgsConstructor;
import no.fint.model.resource.AbstractCollectionResources;

@NoArgsConstructor
public class PersonopplysningResources extends AbstractCollectionResources<PersonopplysningResource> {

    public PersonopplysningResources(Collection<PersonopplysningResource> input) {
        super(input);
    }

    @JsonIgnore
    @Deprecated
    @Override
    public TypeReference<List<PersonopplysningResource>> getTypeReference() {
        return new TypeReference<List<PersonopplysningResource>>() {};
    }
}