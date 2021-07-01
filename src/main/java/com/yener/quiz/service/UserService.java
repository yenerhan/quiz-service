package com.yener.quiz.service;

import com.yener.quiz.base.enums.MessageTypeENUM;
import com.yener.quiz.base.util.Message;
import com.yener.quiz.base.util.Utils;
import com.yener.quiz.dto.user.*;
import com.yener.quiz.entity.User;
import com.yener.quiz.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserResponseDTO searchUser(SearchUserRequestDTO searchUserRequestDTO) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        User user = userRepository.findUserByUserId(searchUserRequestDTO.getUserId());

        if (user == null) {
            throw new UsernameNotFoundException(searchUserRequestDTO.getUserId());
        }

        BeanUtils.copyProperties(user, userResponseDTO);
        return userResponseDTO;
    }

    public UserResponseDTO createUser(SaveUserRequestDTO saveUserRequestDTO) {

        if (userRepository.findUserByEmail(saveUserRequestDTO.getEmail()) != null) {
            throw new RuntimeException("Bu Email adresli kullanıcı zaten var.");
        }

        User user = new User();
        BeanUtils.copyProperties(saveUserRequestDTO, user);
        user.setEncryptedPassword("test");
        user.setUserId(utils.generateUserId(30));
        user.setEmailVerificationStatus(Boolean.FALSE);
        user.setEncryptedPassword(bCryptPasswordEncoder.encode(saveUserRequestDTO.getPassword()));
        user = userRepository.save(user);

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        BeanUtils.copyProperties(user, userResponseDTO);
        return userResponseDTO;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getEncryptedPassword(), new ArrayList<>());
    }


    public UserResponseDTO updateUser(UpdateUserRequestDTO updateUserRequestDTO) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        User user = userRepository.findUserByUserId(updateUserRequestDTO.getUserId());

        if (user == null) {
            throw new UsernameNotFoundException(updateUserRequestDTO.getUserId());
        }
        user.setFirstName(updateUserRequestDTO.getFirstName());
        user.setLastName(updateUserRequestDTO.getLastName());

        user = userRepository.save(user);
        BeanUtils.copyProperties(user, userResponseDTO);
        return userResponseDTO;
    }

    public DeleteUserResponseDTO deleteUser(DeleteUserRequestDTO deleteUserRequestDTO) {
        DeleteUserResponseDTO deleteUserResponseDTO = new DeleteUserResponseDTO();
        List<Message> messageList = new ArrayList();
        User user = userRepository.findUserByUserId(deleteUserRequestDTO.getUserId());
        if (user == null) {
            throw new UsernameNotFoundException(deleteUserRequestDTO.getUserId());
        }
        userRepository.delete(user);
        messageList.add(new Message(MessageTypeENUM.SUCCESS, "Silme İşlemi Başarılı"));
        deleteUserResponseDTO.setMessageList(messageList);
        return deleteUserResponseDTO;
    }
}
