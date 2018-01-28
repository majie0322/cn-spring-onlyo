package cn.spring.onlyo.action;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class HelloAction {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public String execute() {
        name = "Tom";
        return "success";
    }
}
