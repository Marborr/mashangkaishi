package life.mashangkaishi.manongcommunity.mapper;

import java.util.List;
import life.mashangkaishi.manongcommunity.model.testTable;
import life.mashangkaishi.manongcommunity.model.testTableExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface testTableMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_table
     *
     * @mbg.generated Sun Mar 01 23:11:45 CST 2020
     */
    long countByExample(testTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_table
     *
     * @mbg.generated Sun Mar 01 23:11:45 CST 2020
     */
    int deleteByExample(testTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_table
     *
     * @mbg.generated Sun Mar 01 23:11:45 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_table
     *
     * @mbg.generated Sun Mar 01 23:11:45 CST 2020
     */
    int insert(testTable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_table
     *
     * @mbg.generated Sun Mar 01 23:11:45 CST 2020
     */
    int insertSelective(testTable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_table
     *
     * @mbg.generated Sun Mar 01 23:11:45 CST 2020
     */
    List<testTable> selectByExampleWithRowbounds(testTableExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_table
     *
     * @mbg.generated Sun Mar 01 23:11:45 CST 2020
     */
    List<testTable> selectByExample(testTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_table
     *
     * @mbg.generated Sun Mar 01 23:11:45 CST 2020
     */
    testTable selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_table
     *
     * @mbg.generated Sun Mar 01 23:11:45 CST 2020
     */
    int updateByExampleSelective(@Param("record") testTable record, @Param("example") testTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_table
     *
     * @mbg.generated Sun Mar 01 23:11:45 CST 2020
     */
    int updateByExample(@Param("record") testTable record, @Param("example") testTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_table
     *
     * @mbg.generated Sun Mar 01 23:11:45 CST 2020
     */
    int updateByPrimaryKeySelective(testTable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_table
     *
     * @mbg.generated Sun Mar 01 23:11:45 CST 2020
     */
    int updateByPrimaryKey(testTable record);
}