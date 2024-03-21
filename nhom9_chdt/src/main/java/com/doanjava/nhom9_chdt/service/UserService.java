package com.doanjava.nhom9_chdt.service;

import com.doanjava.nhom9_chdt.constants.Provider;
import com.doanjava.nhom9_chdt.constants.Role;
import com.doanjava.nhom9_chdt.entity.Dienthoai;
import com.doanjava.nhom9_chdt.entity.User;
import com.doanjava.nhom9_chdt.repository.RoleRepository;
import com.doanjava.nhom9_chdt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Transactional(isolation = Isolation.SERIALIZABLE,
            rollbackFor = {Exception.class, Throwable.class})
    public void save(@NotNull User user) {
        user.setPassword(new BCryptPasswordEncoder()
                .encode(user.getPassword()));
        userRepository.save(user);
    }
    @Transactional(isolation = Isolation.SERIALIZABLE,
            rollbackFor = {Exception.class, Throwable.class})
    public void setDefaultRole(String username){
        userRepository.findByUsername(username)
                .getRoles()
                .add(roleRepository
                        .findRoleById(Role.USER.value));
    }
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username);
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getAuthorities())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
    public List<User> getUserByRole(Long roleId) {
        return userRepository.findByRoles_Id(roleId);
    }
    public void saveOauthUser(String email, @NotNull String username) {
        Optional<User> existingUser = Optional.ofNullable(userRepository.findByUsername(username));
        if (existingUser.isPresent()) {
            return;
        }
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(new BCryptPasswordEncoder().encode(username));
        user.setProvider(Provider.GOOGLE.value);
        user.getRoles().add(roleRepository.findRoleById(Role.USER.value));
        userRepository.save(user);
    }@Transactional(isolation = Isolation.SERIALIZABLE,
            rollbackFor = {Exception.class, Throwable.class})
    public void setRoleNV(String username){
        userRepository.findByUsername(username)
                .getRoles()
                .add(roleRepository
                        .findRoleById(2L));
    }
    public void saveOauthNV(String email, @NotNull String username) {
        Optional<User> existingUser = Optional.ofNullable(userRepository.findByUsername(username));
        if (existingUser.isPresent()) {
            return;
        }
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(new BCryptPasswordEncoder().encode(username));
        user.setProvider(Provider.GOOGLE.value);
        user.getRoles().add(roleRepository.findRoleById(Role.NV.value));
        userRepository.save(user);
    }

}
