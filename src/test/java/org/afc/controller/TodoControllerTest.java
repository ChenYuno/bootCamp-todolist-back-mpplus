package org.afc.controller;


import cn.hutool.json.JSONStrFormatter;
import com.alibaba.fastjson.JSON;
import org.afc.entities.Todo;
import org.afc.service.impl.TodoServiceImpl;
import org.afc.utils.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TodoControllerTest {

    @Autowired
    private TodoServiceImpl todoService;

    @BeforeEach
    public void initToIntegration(){
        List<Todo> todos = todoService.list();
        List<String> ids = todos.stream().map((todo -> todo.getId())).collect(Collectors.toList());
        todoService.removeBatchByIds(ids);
    }

    void repository_to_save_three_item(){
        Todo firstTodo = new Todo(null,"first todo",false);
        Todo secondTodo = new Todo(null,"second todo",false);
        Todo thirdTodo = new Todo(null,"third todo",false);
        todoService.save(firstTodo);
        todoService.save(secondTodo);
        todoService.save(thirdTodo);
    }
    @Autowired
    MockMvc client;
    @Test
    void should_query_3_all_todo_when_have_3_item_given_find_all() throws Exception {
        //given
        repository_to_save_three_item();
        //when
        //then
        client.perform(MockMvcRequestBuilders.get("/todo/all"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.data", hasSize(3)));
    }

    @Test
    void should_find_one_todo_for_update_when_find_todo_by_id_given_todo_id() throws Exception {
        //given
        Todo test_to_add = new Todo("", "test to add", false);
        todoService.save(test_to_add);
        //when
        client.perform(MockMvcRequestBuilders.get("/todo/todo/one/{id}",test_to_add.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.data.id", equalTo(test_to_add.getId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.data.text", equalTo(test_to_add.getText())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.data.done", equalTo(test_to_add.getDone())));
        //then
    }

    
    @Test
    void should_have_4_todo_when_add_one_todo_given_todo_msg() throws Exception {
        //given
        repository_to_save_three_item();
        Todo test_to_add = new Todo("", "test to add", false);
        String jsonString = JSON.toJSONString(test_to_add);
        //when
        client.perform(MockMvcRequestBuilders.post("/todo/addtodo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.data.text", equalTo("test to add")));
        //then
        client.perform(MockMvcRequestBuilders.get("/todo/all"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.data", hasSize(4)));
    }

    @Test
    void should_update_text_when_update_given_new_text() throws Exception {
        //given

        //then
    }

    @Test
    void should_delete_todo_when_delete_given_todo_id() throws Exception {

    }


    
}
