package com.example.reggie.dto;

import com.example.reggie.entity.Dish;
import com.example.reggie.entity.DishFlavor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO可以用于前后端数据交互
 */
@Data
public class DishDto extends Dish {
    private List<DishFlavor> flavors = new ArrayList<>();
    //dish表中使用了外键categoryId，而前端需要的是categoryName
    private String categoryName;

    private Integer copies;

}
