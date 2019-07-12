package com.shellming.eleservice.vo;

import com.shellming.eleservice.entity.Category;
import com.shellming.eleservice.entity.Shop;
import lombok.Data;

@Data
public class ShopVo extends Shop {
    public Category categoryData;
}
