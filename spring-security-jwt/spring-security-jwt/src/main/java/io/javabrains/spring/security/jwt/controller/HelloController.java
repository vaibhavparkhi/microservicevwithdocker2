package io.javabrains.spring.security.jwt.controller;

import io.javabrains.spring.security.jwt.model.JwtRequest;
import io.javabrains.spring.security.jwt.model.JwtResponse;
import io.javabrains.spring.security.jwt.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    UserDetailsService userDetailsService;

    @RequestMapping("/")
    public String hello() {
        return "hello";
    }


//    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//    public ResponseEntity createJWT(@RequestBody JwtRequest jwtRequest) throws Exception {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
//        } catch (Exception ex) {
//            throw new Exception("Incorrect username or password");
//        }
//
//        final UserDetails userDetails = userDetailsService.
//                loadUserByUsername(jwtRequest.getUsername());
//        final String jwt = jwtUtils.generateToken(userDetails);
//
//        return ResponseEntity.ok(new JwtResponse(jwt));
//
//    }

    @GetMapping("/user")
    public String user(){
        return "Users";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }


}
