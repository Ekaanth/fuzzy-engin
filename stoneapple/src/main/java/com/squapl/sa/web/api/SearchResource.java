package com.squapl.sa.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.squapl.sa.elasticrepository.ElasticRepository;

@RestController
@RequestMapping("/rest/search")
public class SearchResource {

    @Autowired
   ElasticRepository elasticRepository;

//    @GetMapping(value = "/name/{text}")
//    public List<Users> searchName(@PathVariable final String text) {
//        return usersElasticRepository.findByName(text);
//    }
//
//
//    @GetMapping(value = "/salary/{salary}")
//    public List<Users> searchSalary(@PathVariable final Long salary) {
//        return usersElasticRepository.findBySalary(salary);
//    }
//
//
//    @GetMapping(value = "/all")
//    public List<Users> searchAll() {
//        List<Users> usersList = new ArrayList<>();
//        Iterable<Users> userses = usersElasticRepository.findAll();
//        userses.forEach(usersList::add);
//        return usersList;
//    }


}
