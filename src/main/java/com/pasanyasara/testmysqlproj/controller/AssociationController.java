package com.pasanyasara.testmysqlproj.controller;

import com.pasanyasara.testmysqlproj.model.Association;
import com.pasanyasara.testmysqlproj.model.User;
import com.pasanyasara.testmysqlproj.repository.AssociationRepository;
import com.pasanyasara.testmysqlproj.repository.UserRepository;
import netscape.javascript.JSObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/demo")
public class AssociationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AssociationRepository associationRepository;

    @Value("${user.base.url}")
    private String baseUrl;


    @GetMapping("/associations")
    public @ResponseBody Iterable<Association> getAllAssociations(){
        return associationRepository.findAll();
    }



//    @GetMapping("associations/{id}") //change into cnie
//    public @ResponseBody Optional<Association> getAssociationById(@PathVariable int id){
//        return associationRepository.findById(id);
//
//    }

//    @GetMapping("associations/rc/{rc_Num}") //change to cnie
//    public @ResponseBody List<Association> getAssociationByRCNUM(@PathVariable int rc_Num){
//        return associationRepository.sqlAssociationbyrc(rc_Num);
//
//    }

    @GetMapping("associations/{cnie_Collab}")
    public @ResponseBody List<Association> getAllAssociationByCNIE(@PathVariable String cnie_Collab){



        return associationRepository.sqlAssociationByCnie(cnie_Collab);

    }



    //@GetMapping("associations/{cnie_Collab}")
    public @ResponseBody Association cnieCustomResponse(String cnie_Collab){

        return new Association(cnie_Collab,null,null);


    }

    //public JSONParser





    @PostMapping("/add/{name}/{email}")
    public @ResponseBody String addNewUser (@PathVariable String name, @PathVariable String email)
    {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "User "+name+" saved successfully.";
    }

    @GetMapping("/users")
    public @ResponseBody Iterable<User> getAllUsers(){

        return userRepository.findAll();
    }
}
