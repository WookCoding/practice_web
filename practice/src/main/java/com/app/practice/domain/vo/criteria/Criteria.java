package com.app.practice.domain.vo.criteria;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Criteria {
    private Integer page;
    private Integer amount;

    public Criteria() {
        this(1, 9);
    }

    public Criteria(Integer pageNum, Integer amount) {
        this.page = pageNum;
        this.amount = amount;
    }

    public int getStartRow(){
        return (this.page -1) * this.amount;
    }

}
