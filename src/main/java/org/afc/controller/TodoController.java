package org.afc.controller;


import org.afc.entities.Todo;
import org.afc.service.impl.TodoServiceImpl;
import org.afc.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author czy
 * @since 2022-08-04
 */
@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoServiceImpl todoService;

    @GetMapping("/all")
    public Response findAllTodo(){
        return todoService.findAllTodo();

    }

    @GetMapping("/allDone")
    public Response findTodoDone(){
        return todoService.findTodoDone();
    }
    @GetMapping("/todo/one/{id}")
    public Response findTodoById(@PathVariable String id){
        return todoService.findTodoById(id);
    }

    @PostMapping("/addtodo")
    public Response addTodo(@RequestBody Todo addTodo){
        addTodo.setId(null);
        return todoService.addTodo(addTodo);
    }

    @PutMapping("/updatetodo/{id}")
    public Response updateTodo(@PathVariable String id,@RequestBody Todo addTodo){
        return todoService.updateTodo(id,addTodo);
    }

    @DeleteMapping ("/deletetodo/{id}")
    public Response deleteTodo(@PathVariable String id){
        return todoService.deleteTodo(id);
    }
}

