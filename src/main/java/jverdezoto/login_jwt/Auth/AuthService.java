package jverdezoto.login_jwt.Auth;

import jverdezoto.login_jwt.Jwt.JwtService;
import jverdezoto.login_jwt.User.Role;
import jverdezoto.login_jwt.User.User;
import jverdezoto.login_jwt.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthResponse login(LoginRequest request) {
        return null;
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.username)
                .password(request.password)
                .firstname(request.firstname)
                .lastname(request.lastname)
                .country(request.country)
                .role(Role.USER)
                .build();

        userRepository.save(user);
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
