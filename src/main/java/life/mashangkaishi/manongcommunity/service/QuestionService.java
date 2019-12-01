package life.mashangkaishi.manongcommunity.service;

import life.mashangkaishi.manongcommunity.dto.PageDTO;
import life.mashangkaishi.manongcommunity.dto.QuestionDTO;
import life.mashangkaishi.manongcommunity.mapper.QuestionMapper;
import life.mashangkaishi.manongcommunity.mapper.UserMapper;
import life.mashangkaishi.manongcommunity.model.Question;
import life.mashangkaishi.manongcommunity.model.QuestionExample;
import life.mashangkaishi.manongcommunity.model.User;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;

    public PageDTO list(Integer page, Integer size) {
        PageDTO pageDTO=new PageDTO();
        List<QuestionDTO> questionDTOList=new ArrayList<>();
        Integer totalPage;
        Integer totalcount =(int) questionMapper.countByExample(new QuestionExample());

        if (totalcount %size ==0){
            totalPage=totalcount /size;
        }else {
            totalPage=totalcount /size +1;
        }

        if (page<1){
            page=1;
        }
        if (page>totalPage)
        {
            if (page<totalPage)
            page=totalPage;
        }



        pageDTO.setPageNumber(totalPage,page);

        Integer offset=size*(page-1);
        List<Question> questions = questionMapper.selectByExampleWithRowbounds(new QuestionExample(), new RowBounds(offset, size));
        for (Question question : questions
             ) {
            User user=userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);//快速的将第一个元素的属性拷贝到第二个元素上
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        pageDTO.setQuestions(questionDTOList);


        return pageDTO;
    }

    public PageDTO list(Integer userId, Integer page, Integer size) {
        PageDTO pageDTO=new PageDTO();
        List<QuestionDTO> questionDTOList=new ArrayList<>();
        Integer totalPage;
        QuestionExample example = new QuestionExample();
        example.createCriteria().andCreatorEqualTo(userId);
        Integer totalcount =(int) questionMapper.countByExample(example);

        if (totalcount %size ==0){
            totalPage=totalcount /size;
        }else {
            totalPage=totalcount /size +1;
        }


        if (page<1){
            page=1;
        }
        if (page>totalPage){
            if (page<totalPage)
                page=totalPage;
        }

        pageDTO.setPageNumber(totalPage,page);

        Integer offset=size*(page-1);

        QuestionExample example1 = new QuestionExample();
        example1.createCriteria().andCreatorEqualTo(userId);
        //example1等参数都是查询条件
        List<Question> questions = questionMapper.selectByExampleWithRowbounds(example1, new RowBounds(offset, size));
        for (Question question : questions
        ) {
            User user=userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);//快速的将第一个元素的属性拷贝到第二个元素上
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        pageDTO.setQuestions(questionDTOList);
        return pageDTO;
    }

    public QuestionDTO getById(Integer id) {
        Question question = questionMapper.selectByPrimaryKey(id);
        QuestionDTO questionDTO=new QuestionDTO();
        BeanUtils.copyProperties(question,questionDTO);
        User user=userMapper.selectByPrimaryKey(question.getCreator());
        questionDTO.setUser(user);
        return questionDTO;
    }

    public void creatOrUpdate(Question question) {
        if (question.getId() == null){
            //创建
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
            questionMapper.insert(question);
        }else {
            //更新
            question.setGmtModified(question.getGmtCreate());
            Question updateQuestion = new Question();
            updateQuestion.setGmtModified(System.currentTimeMillis());
            updateQuestion.setTitle(question.getTitle());
            updateQuestion.setDescription(question.getDescription());
            updateQuestion.setTag(question.getTag());
            QuestionExample example = new QuestionExample();
            example.createCriteria()
                    .andCreatorEqualTo(question.getId());
            questionMapper.updateByExampleSelective(updateQuestion, example);
        }
    }
}
