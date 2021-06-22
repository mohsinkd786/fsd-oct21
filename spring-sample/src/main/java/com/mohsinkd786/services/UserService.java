package com.mohsinkd786.services;

import com.mohsinkd786.dtos.UserDto;
import com.mohsinkd786.mappers.UserMapper;
import com.mohsinkd786.repositories.UserRepository;
import com.mohsinkd786.repositories.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserDto> getUsers(){
        return userRepository.findAll().parallelStream().map(user-> userMapper.map(user,UserDto.class)).collect(Collectors.toList());
    }

    public boolean createUser(UserDto userDto){
        User entity = userMapper.map(userDto,User.class);
        entity.setUserId(UUID.randomUUID().toString());

        userRepository.save(entity);

        return true;
    }

    public boolean removeUser(String userId) throws Exception {
        // remove object
//        Optional<UserDto> optionalUserDto = userDtos
//                .stream()
//                .filter(u-> u.getId() == id)
//                .findFirst();
//        if(!optionalUserDto.isPresent()){
//            throw new Exception("Invalid or no user details specified");
//        }
//        userDtos.remove(optionalUserDto.get());

        User user = userRepository.findByUserId(userId);
        userRepository.delete(user);

        //userRepository.deleteByUserId(userId);

        return true;
    }

    public boolean updateUserEmail(String email,String userId){
        User user = userRepository.findByUserId(userId);
        user.setEmail(email);
        userRepository.save(user);
        return true;
    }
}
