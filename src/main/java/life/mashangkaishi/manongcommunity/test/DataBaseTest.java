package life.mashangkaishi.manongcommunity.test;

import life.mashangkaishi.manongcommunity.mapper.testTableMapper;
import life.mashangkaishi.manongcommunity.model.testTable;
import life.mashangkaishi.manongcommunity.model.testTableExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataBaseTest {
    @Autowired
    testTableMapper testTableMapper;

    @PostMapping("/test1")
    @ResponseBody
    public int test1(@RequestBody testTable testTable){
        int insert = testTableMapper.insert(testTable);
        return insert;
    }
    @PostMapping("/test2")
    @ResponseBody
    public int test2(@RequestBody testTable testTable){
        testTableExample example = new testTableExample();
        example.createCriteria().andIdEqualTo(testTable.getId());
        int delete = testTableMapper.deleteByExample(example);
        return delete;
    }
}
