package th.com.example.springTHMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import th.com.example.springTHMVC.exception2.StorageException;
import th.com.example.springTHMVC.model2.Person;
import th.com.example.springTHMVC.repostory.PersonRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
public class StorageService {
    @Autowired
    private PersonRepository personRepository;
    @Value("${upload.path}")
    private String path;
    public void uploadFile(MultipartFile file, int id) throws Exception {
        if(file.isEmpty()){
            throw new StorageException("Failed to store empty file");
        }
        String fileName = file.getOriginalFilename();

        try{
            var is = file.getInputStream();
            var address = path + "pic"+id+".jpg";
            Files.copy(is, Paths.get(address), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            var msg = String.format("Failed to store file %s",fileName);
            throw new StorageException(msg,e);
        }
    }

    public void deleteFile(int id){
        Optional<Person> personOp = personRepository.get(id);
        if(personOp.isPresent()){
            Person person = personOp.get();
            String fileName = person.getPhoto().getOriginalFilename();
            try{
                var address = path + "pic"+id+".jpg";
                Files.deleteIfExists(Paths.get(address));
            }catch(Exception e){
                var msg = String.format("Failed to delete file %s",fileName);
                throw new StorageException(msg,e);
            }
        }
    }

}
