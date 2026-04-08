package com.example.webapp.service;

import java.util.List;
import com.example.webapp.entity.ToDo;

/**
 * ToDo サービス
 */
public interface ToDoService {
  /**
   * 全てのすることを検索します
   * 
   * @return
   */
  List<ToDo> findAllToDo();

  /**
   * 指定されたIDのすることを検索します
   * 
   * @param id ID
   * @return ToDo
   */
  ToDo findByIdToDo(Integer id);

  /**
   * することを新規登録します
   *
   * @param toDo
   */
  void insertToDo(ToDo toDo);

  /**
   * することを更新します
   * 
   * @param toDo
   */
  void updateToDo(ToDo toDo);

  /**
   * 指定されたIDnoすることを削除します
   *
   * @param id
   */
  void deleteToDo(Integer id);


}
