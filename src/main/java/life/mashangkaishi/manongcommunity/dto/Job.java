package life.mashangkaishi.manongcommunity.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Job {
    private String money;
    private List<String> companies = new ArrayList<String>();
    private int count;

    @Override
    public String toString() {
        return "工资待遇为" + money + "的公司有" + count + "家，他们是：" + companies;
    }

}
