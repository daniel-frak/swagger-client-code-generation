package com.danielfrak.code.swaggerclientcodegeneration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

/**
 * Based on:
 * https://github.com/springfox/springfox/issues/1959
 */
@RunWith(SpringRunner.class)
@IfProfileValue(name = "test-profile", value = "GenerateSwagger")
@SpringBootTest
@TestPropertySource("classpath:application.properties")
public class GenerateSwagger {

    @Autowired
    WebApplicationContext context;

    /**
     * This test is intentionally skipped.
     * You can use it to generate a swagger.json file using the following command:
     * mvn -Dtest=GenerateSwagger -Dtest-profile=GenerateSwagger test
     */
    @Test
    public void generateSwagger() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/v2/api-docs")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(this::saveToFile);
    }

    private Path saveToFile(MvcResult r) throws IOException {
        return Files.write(Paths.get("swagger.json"),
                Collections.singletonList(r.getResponse().getContentAsString()), StandardCharsets.UTF_8);
    }
}
