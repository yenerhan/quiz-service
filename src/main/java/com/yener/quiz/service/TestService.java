package com.yener.quiz.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yener.quiz.base.enums.MessageTypeENUM;
import com.yener.quiz.base.util.Message;
import com.yener.quiz.dto.test.DeleteTestResponseDTO;
import com.yener.quiz.dto.test.SaveTestResponseDTO;
import com.yener.quiz.dto.test.TestDTO;
import com.yener.quiz.dto.test.UpdateTestResponseDTO;
import com.yener.quiz.entity.Test;
import com.yener.quiz.repository.TestRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    ObjectMapper objectMapper;


    public List<TestDTO> findAllTest() {
        List<Test> testList = testRepository.findAll();
        List<TestDTO> testDTOList = new ArrayList<>();
        for (Test test : testList) {
            TestDTO testDTO = new TestDTO();
            BeanUtils.copyProperties(test, testDTO);
            testDTOList.add(testDTO);
        }
        return testDTOList;

    }


    public SaveTestResponseDTO saveTest(TestDTO testDTO) {
        Test test = new Test();
        BeanUtils.copyProperties(testDTO, test);
        test = testRepository.save(test);
        SaveTestResponseDTO saveTestResponseDTO = new SaveTestResponseDTO();
        if (test.getTestId() != null) {
            List<Message> messageList = new ArrayList();
            messageList.add(new Message(MessageTypeENUM.SUCCESS, "Kayıt Başarılı"));
            saveTestResponseDTO.setMessageList(messageList);
        }
        return saveTestResponseDTO;
    }

    public DeleteTestResponseDTO deleteTest(Long testId) {
        testRepository.delete(testId);
        DeleteTestResponseDTO testResponseDTO = new DeleteTestResponseDTO();
        List<Message> messageList = new ArrayList();
        messageList.add(new Message(MessageTypeENUM.SUCCESS, "Kayıt Başarıyla Başarılı"));
        testResponseDTO.setMessageList(messageList);
        return testResponseDTO;
    }

    public UpdateTestResponseDTO updateTest(TestDTO testDTO) {
        Test test = testRepository.findTestByTestId(testDTO.getTestId());
        UpdateTestResponseDTO updateTestResponseDTO = new UpdateTestResponseDTO();
        List<Message> messageList = new ArrayList();
        if (test == null) {
            messageList.add(new Message(MessageTypeENUM.SUCCESS, "Kayıt Bulunamadı."));
            updateTestResponseDTO.setMessageList(messageList);
            return updateTestResponseDTO;
        }

        BeanUtils.copyProperties(testDTO, test);
        testRepository.save(test);
        messageList.add(new Message(MessageTypeENUM.SUCCESS, "Güncelleme Başarılı."));
        updateTestResponseDTO.setMessageList(messageList);
        return updateTestResponseDTO;
    }


}
