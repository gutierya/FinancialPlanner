package FinancialPlanner.app;

import FinancialPlanner.app.Controllers.GoalController;
import FinancialPlanner.app.Repos.GoalRepo;
import FinancialPlanner.app.Services.ErrorsService;
import FinancialPlanner.app.Services.GoalService;
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

@WebMvcTest(GoalController.class)
class GoalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    GoalRepo goalRepo;

    @MockBean
    GoalService goalService;

    @MockBean
    ErrorsService errorsService;

    @MockBean
    UserService userService;

//    @Test
//    void testAddGoal() throws Exception {
//        String url = "/goalview";
//
//        mockMvc.perform(MockMvcRequestBuilders.post(url).content(asJsonString((new User("First1", "Last1"))))
//        .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
//
//        mockMvc.perform(MockMvcRequestBuilders.post(url).content(asJsonString((new Goal("goal name", "goal desc", 50D))))
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
//    }

    @Test
    void getOneGoal() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                .get("/goalview/1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllGoals() throws Exception{
        mockMvc.perform( MockMvcRequestBuilders
                .get("/goalview/all")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteAGoal() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                .delete("/goalview/1")
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
