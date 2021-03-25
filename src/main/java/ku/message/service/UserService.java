package ku.message.service;

import ku.message.dto.SignupDto;
import ku.message.model.User;
import ku.message.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.Instant;


@Service
public class UserService
{
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    public boolean isUsernameAvailable(String username)
    {
        return repository.findByUsername(username) == null;
    }

    public int createUser(SignupDto signupDto)
    {
        User newUser = modelMapper.map(signupDto, User.class);
        newUser.setCreatedAt(Instant.now());

        String hashedPassword = passwordEncoder.encode(signupDto.getPassword());

        newUser.setPassword(hashedPassword);

        repository.save(newUser);

        return 1;
    }

    public User getUser(String username)
    {
        return repository.findByUsername(username);
    }
}
