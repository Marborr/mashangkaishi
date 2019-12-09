package life.mashangkaishi.manongcommunity.service;

import life.mashangkaishi.manongcommunity.dto.PageDTO;
import life.mashangkaishi.manongcommunity.dto.QuestionDTO;
import life.mashangkaishi.manongcommunity.dto.QuestionQueryDTO;
import life.mashangkaishi.manongcommunity.exception.CustomizeErrorCode;
import life.mashangkaishi.manongcommunity.exception.CustomizeException;
import life.mashangkaishi.manongcommunity.mapper.QuestionExtMapper;
import life.mashangkaishi.manongcommunity.mapper.QuestionMapper;
import life.mashangkaishi.manongcommunity.mapper.UserMapper;
import life.mashangkaishi.manongcommunity.model.Question;
import life.mashangkaishi.manongcommunity.model.QuestionExample;
import life.mashangkaishi.manongcommunity.model.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionExtMapper questionExtMapper;

    public PageDTO list(String search, Integer page, Integer size) {
        //搜索功能实现
        if (StringUtils.isNoneBlank(search)){
           String[] tags = StringUtils.split(search, " ");
           search = Arrays.stream(tags).collect(Collectors.joining("|"));
        }



        PageDTO pageDTO=new PageDTO();
        List<QuestionDTO> questionDTOList=new ArrayList<>();
        Integer totalPage;
        QuestionQueryDTO questionQueryDTO = new QuestionQueryDTO();
        questionQueryDTO.setSearch(search);
        Integer totalcount =questionExtMapper.countBySearch(questionQueryDTO);

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
        questionQueryDTO.setSize(size);
        questionQueryDTO.setPage(offset);
        List<Question> questions = questionExtMapper.selectBySearch(questionQueryDTO);

        for (Question question : questions
             ) {
            User user=userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);//快速的将第一个元素的属性拷贝到第二个元素上
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        pageDTO.setData(questionDTOList);
        return pageDTO;
    }

    public PageDTO list(Long userId, Integer page, Integer size) {
        PageDTO pageDTO=new PageDTO();
        List<QuestionDTO> questionDTOList=new ArrayList<>();
        Integer totalPage;
        QuestionExample example = new QuestionExample();
        example.createCriteria()
                .andCreatorEqualTo(userId);
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
        List<Question> questions = questionMapper.selectByExampleWithRowbounds
                (example1, new RowBounds(offset, size));

        for (Question question : questions
        ) {
            User user=userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);//快速的将第一个元素的属性拷贝到第二个元素上
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        pageDTO.setData(questionDTOList);
        return pageDTO;
    }

    public QuestionDTO getById(Long id) {
        Question question = questionMapper.selectByPrimaryKey(id);
        if(question==null){
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }

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
            int update = questionMapper.updateByExampleSelective(updateQuestion, example);
            if (update!=1){
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
        }
    }

    public void inView(Long id) {

        Question question= new Question();
        question.setId(id);
        question.setViewCount(1);
        questionExtMapper.incView(question);
    }

    public List<QuestionDTO> selectRelated(QuestionDTO queryDTO) {
        if (StringUtils.isBlank(queryDTO.getTag())){
            return new ArrayList<>();
        }
        //正则匹配搜索标签
        String[] tags = StringUtils.split(queryDTO.getTag(), ",");
        String regexpTag = Arrays.stream(tags).collect(Collectors.joining("|"));
        Question question = new Question();
        question.setId(queryDTO.getId());
        question.setTag(regexpTag);

        List<Question> questions=questionExtMapper.selectRelated(question);
        List<QuestionDTO> questionDTOs = questions.stream().map(q -> {
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(q,questionDTO);
            return questionDTO;
        }).collect(Collectors.toList());
        return questionDTOs;
    }
}
