package com.example.liv2train.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TrainingCenterController.class)
class TrainingCenterControllerTest {

    @Autowired
    private MockMvc mockMvc;



    @Test
     void testSaveTrainingCenter() throws Exception {
        // Create a JSON string manually instead of using a DTO
        String trainingCenterJson = "{ \"centerCode\": \"TC001\", \"centerName\": \"Center 1\" }";

        mockMvc.perform(post("/api/training-center")
                .contentType(MediaType.APPLICATION_JSON)
                .content(trainingCenterJson))
                .andExpect(status().isOk());
    }

    @Test
     void testSaveTrainingCenterInvalidInput() throws Exception {
        // JSON with an invalid centerCode (empty string)
        String invalidTrainingCenterJson = "{ \"centerCode\": \"\", \"centerName\": \"Center 2\" }";

        mockMvc.perform(post("/api/training-center")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidTrainingCenterJson))
                .andExpect(status().isBadRequest());
    }
}
