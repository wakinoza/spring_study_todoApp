package com.example.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.webapp.entity.ToDo;
import com.example.webapp.form.ToDoForm;
import com.example.webapp.helper.ToDoHelper;
import com.example.webapp.service.ToDoService;
import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDoController {
  /**
   * DI
   */
  private final ToDoService toDoService;

  /**
   * することの一覧を表示します
   */
  @GetMapping
  public String list(Model model) {
    model.addAttribute("todos", toDoService.findAllToDo());
    return "todo/list";
  }

  /**
   * 指定されたIDのすることを詳細に表示します
   */
  @GetMapping("/{id}")
  public String detail(@PathVariable Integer id, Model model, RedirectAttributes attributes) {
    ToDo ToDo = toDoService.findByIdToDo(id);
    if (ToDo != null) {
      model.addAttribute("todo", toDoService.findByIdToDo(id));
      return "todo/detail";
    } else {
      attributes.addFlashAttribute("errorMessage", "対象データがありません");
      return "redirect:/todos";
    }
  }

  /**
   * 新規登録画面を表示します
   */
  @GetMapping("/form")
  public String newToDo(@ModelAttribute ToDoForm form) {
    form.setIsNew(true);
    return "todo/form";
  }


  /**
   * 新規登録を実行します
   */
  @PostMapping("/save")
  public String create(ToDoForm form, RedirectAttributes attributes) {
    ToDo ToDo = ToDoHelper.convertToDo(form);
    toDoService.insertToDo(ToDo);
    attributes.addFlashAttribute("message", "新しいToDoが作成されました");
    return "rediect:/todos";
  }


  /**
   * 指定されたIDの修正画面を表示します
   * 
   */
  @GetMapping("/edit/{id}")
  public String edit(@PathVariable Integer id, Model model, RedirectAttributes attributes) {
    ToDo target = toDoService.findByIdToDo(id);
    if (target != null) {
      ToDoForm form = ToDoHelper.convertToDoForm(target);
      model.addAttribute("toDoForm", form);
      return "todo/form";
    } else {
      attributes.addFlashAttribute("errorMessage", "対象データがありません");
      return "redirect:/todos";
    }
  }

  /**
   * することの情報を更新します
   */
  @PostMapping("/update")
  public String update(ToDoForm form, RedirectAttributes attributes) {
    ToDo ToDo = ToDoHelper.convertToDo(form);
    toDoService.updateToDo(ToDo);
    attributes.addFlashAttribute("message", "Todoが更新されました");
    return "redirect:/todos";

  }



}
