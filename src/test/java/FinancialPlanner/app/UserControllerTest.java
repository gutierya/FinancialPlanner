package FinancialPlanner.app;


import FinancialPlanner.app.Controllers.UserController;
import FinancialPlanner.app.Models.User;
import FinancialPlanner.app.Repos.UserRepo;
import FinancialPlanner.app.Services.ErrorsService;
import FinancialPlanner.app.Services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserRepo userRepo;

    @MockBean
    UserService userService;

    @MockBean
    ErrorsService errorsService;

    @Test
    void testAddUser() throws Exception {
        String url = "/userview";

        mockMvc.perform(MockMvcRequestBuilders.post(url).content(asJsonString((new User("First1", "Last1"))))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
    }

    @Test
    void getOneUser() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                .get("/userview/1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllUsers() throws Exception{
        mockMvc.perform( MockMvcRequestBuilders
                .get("/userview")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteUser() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                .delete("/userview/1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * util method - Converting/marshalling Java object to Json
     * @param obj
     * @return Json String
     */
    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
