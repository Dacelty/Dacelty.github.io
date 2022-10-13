package java.com.example.springTHMVC.repostory;

import org.springframework.stereotype.Repository;

import java.com.example.springTHMVC.model2.Job;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class JobRepository {
    private List<Job> jobs = new ArrayList<>();

    public JobRepository() {
        List<Job> list = Arrays.asList(
                new Job(1,"Front-End"),
                new Job(2,"Back-End"),
                new Job(3,"Full Stack")
        );
        jobs.addAll(list);
    }

    public List<Job> getAll() {
        return jobs;
    }

    public Job create(Job job){
        int id;
        if (jobs.isEmpty()) {
            id = 1;
        } else {
            Job lastJ = jobs.get(jobs.size() - 1);
            id = lastJ.getId() + 1;
        }
        job.setId(id);
        for(Job c: jobs){
            if(c.getName().equalsIgnoreCase(job.getName()))
                return null;
        }
        jobs.add(job);
        return job;
    }

    public Job edit(Job job){
        get(job.getId()).ifPresent(existJob->{
            existJob.setName(job.getName());
        });
        return job;
    }

    public Optional<Job> get(int id) {
        return jobs.stream().filter(c -> c.getId() == id).findFirst();
    }

    public void deleteById(int id) {
        get(id).ifPresent(existed -> jobs.remove(existed));
    }
}
