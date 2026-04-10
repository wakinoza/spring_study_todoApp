package com.example.webapp.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * すること：Ｆｏｒｍ
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoForm {

  /**
   * することID
   */
  private Integer id;

  /**
   * すること
   */
  private String todo;

  /**
   * すること詳細
   */
  private String detail;

  /**
   * 新規判定
   */
  private Boolean isNew;
}

