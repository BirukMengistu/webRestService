package com.springboot.Rest.webservices.restfulwebservices.user;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
public class UserResource {
    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    public List<User> retrieveAllusers() {
        return service.findAll();
    }

    @GetMapping("/user/{id}")
    public Resource<User> retrieveAlluser(@PathVariable int id) {
        User user = service.findOne(id);
        if(user == null)
            throw new userNotFoundExceptions("id-"+ id);
        //”all-users”,SERVER_PATH+ “/users”
        //HATAOS
        org.springframework.hateoas.Resource<User> resource = new org.springframework.hateoas.Resource<User>(user);
        ControllerLinkBuilder linkTO = linkTo(methodOn(this.getClass()).retrieveAllusers());
        resource.add(linkTO.withRel("all-users"));
        return resource;
    }
    @DeleteMapping("/user/{id}")
    public void DeleteUser(@PathVariable int id) {
        User user = service.DeleteUserById(id);
        if(user == null)
            throw new userNotFoundExceptions("id-"+ id);

    }

    @PostMapping("/user")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

}


