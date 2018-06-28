package by.kizin.konstantin.resttask.controller;

import by.kizin.konstantin.resttask.entity.User;
import by.kizin.konstantin.resttask.entity.UserStatus;
import by.kizin.konstantin.resttask.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.MockitoJUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import javax.persistence.EntityNotFoundException;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @MockBean
    private EntityNotFoundException notFoundException;


    @Test
    public void when_get_user_then_should_return_user_as_json() throws Exception {

        User user = new User();
        user.setStatus(UserStatus.Offline);
        user.setName("userName");
        user.setId(1l);

        when(userService.getUserById(1l)).thenReturn(user);
        mvc.perform(get("/user/get/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)));
    }


    @Test
    public void when_get_user_with_not_existing_id_then_should_return_correct_json() throws Exception {

        String id = "3";
        when(userService.getUserById(Long.valueOf(id))).thenThrow(notFoundException);
        String errorMessage = "Entity with {id="+Integer.valueOf(id)+"} not exists.";
        when(notFoundException.getMessage()).thenReturn(errorMessage);

        mvc.perform(get("/user/get/3").contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message",is(errorMessage)));

    }



}
