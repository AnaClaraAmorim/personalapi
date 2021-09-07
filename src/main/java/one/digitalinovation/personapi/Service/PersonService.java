package one.digitalinovation.personapi.Service;

import one.digitalinovation.personapi.entity.Person;
import one.digitalinovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public one.digitalinnovation.personapi.dto.response.MessageResponseDTO createPerson(Person person){
        Person savedPerson = personRepository.save(person);
        return one.digitalinnovation.personapi.dto.response.MessageResponseDTO.builder().message("Created person with ID" + savedPerson.getId()).build();
    }
}
