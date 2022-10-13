package th.com.example.springTHMVC.repostory;

import org.springframework.stereotype.Repository;
import th.com.example.springTHMVC.model2.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository {
    private List<Person> people = new ArrayList<>();

    public List<Person> getAll(){return this.people;}

    public Person create(Person person){
        int id;
        if (people.isEmpty()){
            id=1;
        }else{
            Person lastPer = people.get(people.size() - 1);
            id = lastPer.getId() + 1;
        }
        person.setId(id);
        people.add(person);
        return person;
    }

    public Person edit(Person people){
        var optionalPerson = get(people.getId());
        if(optionalPerson.isPresent()){
            var existPerson = optionalPerson.get();
            existPerson.setName(people.getName());
            existPerson.setJob(people.getJob());
            existPerson.setBirthdate(people.getBirthdate());

            if(!people.getPhoto().getOriginalFilename().isEmpty())
                existPerson.setPhoto(people.getPhoto());
            return existPerson;
        }
        return null;
    }

    public Optional<Person> get(int id) {
        return people.stream().filter(p -> p.getId() == id).findFirst();
    }

    public void deleteById(int id) {
        get(id).ifPresent(existed -> people.remove(existed));
    }
}
