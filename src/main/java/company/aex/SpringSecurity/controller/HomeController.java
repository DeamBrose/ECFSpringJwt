package company.aex.SpringSecurity.controller;

import company.aex.SpringSecurity.security.model.JwtRequest;
import company.aex.SpringSecurity.security.model.JwtResponse;
import company.aex.SpringSecurity.security.services.UserService;
import company.aex.SpringSecurity.security.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService serviceUser;

    @PostMapping("/autenticar")
    public JwtResponse authticate(@RequestBody JwtRequest jwtRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        }catch (BadCredentialsException e){
            throw  new Exception("INVALID_CREDENTIALS",e);
        }
        final UserDetails userDetails
               = serviceUser.loadUserByUsername(jwtRequest.getUsername());

        final  String token
                = jwtUtil.generateToken(userDetails);

        return new JwtResponse(token);
    }
}
