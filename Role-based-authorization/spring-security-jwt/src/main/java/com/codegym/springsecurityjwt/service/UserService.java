package com.codegym.springsecurityjwt.service;

import com.codegym.springsecurityjwt.model.Role;
import com.codegym.springsecurityjwt.model.UserPrinciple;
import com.codegym.springsecurityjwt.model.dto.UserDTO;
import com.codegym.springsecurityjwt.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements UserDetailsService {

    public static List<User> listUser = new ArrayList<>();
    public static List<Role> listRole = new ArrayList<>();

    public UserService() {
        // Khởi tạo danh sách vai trò
        listRole.add(new Role(1L, "ROLE_ADMIN"));
        listRole.add(new Role(2L, "ROLE_USER"));

        // Mật khẩu đã mã hóa sẵn
        String password = "$2a$10$xMq9EwZvdKUuvgiaM2T1Iuw9A1EGXVZaCIUPEwn1Isa9ffvPqNabe";

        // Khởi tạo người dùng kai với ROLE_ADMIN
        Set<Role> roleKai = new HashSet<>();
        roleKai.add(listRole.get(0));
        User userKai = new User(1L, "kai", password, roleKai);

        // Khởi tạo người dùng sena với ROLE_USER
        Set<Role> roleSena = new HashSet<>();
        roleSena.add(listRole.get(1));
        User userSena = new User(2L, "sena", password, roleSena);

        // Thêm vào danh sách
        listUser.add(userKai);
        listUser.add(userSena);
    }

    public List<UserDTO> findAll() {
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User u : listUser) {
            userDTOS.add(toDTO(u));
        }
        return userDTOS;
    }

    public UserDTO findById(Long id) {
        for (User user : listUser) {
            if (Objects.equals(user.getId(), id)) {
                return toDTO(user);
            }
        }
        return null;
    }

    public User findByUsername(String username) {
        for (User user : listUser) {
            if (Objects.equals(user.getUsername(), username)) {
                return user;
            }
        }
        return null;
    }

    public boolean add(User user) {
        for (User userExist : listUser) {
            if (Objects.equals(user.getId(), userExist.getId()) ||
                    Objects.equals(user.getUsername(), userExist.getUsername())) {
                return false;
            }
        }
        listUser.add(user);
        return true;
    }

    public void delete(int id) {
        listUser.removeIf(user -> Objects.equals(user.getId(), (long) id));
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        for (User user : listUser) {
            if (Objects.equals(user.getUsername(), username)) {
                return UserPrinciple.build(user);
            }
        }
        return null;
    }

    public UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getRoles());
    }
}
