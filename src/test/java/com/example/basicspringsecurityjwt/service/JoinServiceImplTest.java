package com.example.basicspringsecurityjwt.service;

import com.example.basicspringsecurityjwt.dto.JoinDTO;
import com.example.basicspringsecurityjwt.entity.UserEntity;
import com.example.basicspringsecurityjwt.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("local")
class JoinServiceImplTest {
    @Autowired
    JoinService joinService;
    @Autowired
    UserRepository userRepository;

    @Test
    @Transactional
    @Rollback(value = true)
    void joinTest(){
        JoinDTO joinDTO = new JoinDTO();
        joinDTO.setUsername("pyi");
        joinDTO.setPassword("123");

        joinService.joinProcess(joinDTO);
        UserEntity user = userRepository.findByUsername("pyi");
        assertNotNull(user);
        assertThat(user.getUsername()).isEqualTo("pyi");
    }

}
