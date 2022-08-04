package org.afc.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.afc.entities.Todo;
import org.afc.mappers.TodoMapper;
import org.afc.service.TodoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.afc.utils.Response;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author czy
 * @since 2022-08-04
 */
@Service
public class TodoServiceImpl extends ServiceImpl<TodoMapper, Todo> implements TodoService {

    public Response findAllTodo() {
        List<Todo> todos = baseMapper.selectList(null);
        return Response.SUCCESS("findAllTodo success").data("data", todos);
    }

    public Response findTodoDone() {
        List<Todo> doneTodos = baseMapper.selectList(Wrappers.<Todo>lambdaQuery().eq(Todo::getDone, true));
        return Response.SUCCESS("findTodoDone success").data("data", doneTodos);
    }

    public Response addTodo(Todo addTodo) {
        addTodo.setDone(false);
        baseMapper.insert(addTodo);
        return Response.SUCCESS("addTodo success").data("data", addTodo);
    }

    public Response updateTodo(String id, Todo todo) {
        Todo todoFromDb = baseMapper.selectById(id);
        if (todoFromDb == null) {
            return Response.FAIL("updateTodo fail");
        } else {
            todoFromDb.setDone(todo.getDone());
            todoFromDb.setText(todo.getText());
            baseMapper.updateById(todoFromDb);
            return Response.SUCCESS("updateTodo success").data("data", todoFromDb);
        }
    }
    public Response deleteTodo(String id) {
        Todo todoFromDb = baseMapper.selectById(id);
        if (todoFromDb == null) {
            return Response.FAIL("deleteTodo fail");
        } else {
            baseMapper.deleteById(todoFromDb);
            return Response.SUCCESS("deleteTodo success").data("data", todoFromDb);
        }
    }

    public Response findTodoById(String id) {
        Todo todo = baseMapper.selectById(id);
        if (todo == null) {
            return Response.FAIL("no find this todo");
        }
        return Response.SUCCESS("find this todo!!!")
                .data("data", todo);
    }
}
