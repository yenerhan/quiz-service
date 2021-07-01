package com.yener.quiz.controller;

import com.yener.quiz.dto.test.DeleteTestResponseDTO;
import com.yener.quiz.dto.test.SaveTestResponseDTO;
import com.yener.quiz.dto.test.TestDTO;
import com.yener.quiz.dto.test.UpdateTestResponseDTO;
import com.yener.quiz.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/findAllTest", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    List<TestDTO> findAllTest() {
        return testService.findAllTest();
    }

    @RequestMapping(value = "/saveTest", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    SaveTestResponseDTO saveTest(@RequestBody TestDTO testDTO) {
        return testService.saveTest(testDTO);
    }

    @RequestMapping(value = "/deleteTest", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    DeleteTestResponseDTO deleteTest(@RequestBody Long testId) {
        return testService.deleteTest(testId);
    }

    @RequestMapping(value = "/updateTest", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public
    @ResponseBody
    UpdateTestResponseDTO updateTest(@RequestBody TestDTO testDTO) {
        return testService.updateTest(testDTO);
    }

}
