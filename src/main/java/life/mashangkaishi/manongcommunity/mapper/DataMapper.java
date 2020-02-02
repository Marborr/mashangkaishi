package life.mashangkaishi.manongcommunity.mapper;

import java.util.List;
import life.mashangkaishi.manongcommunity.model.Data;
import life.mashangkaishi.manongcommunity.model.DataExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface DataMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data
     *
     * @mbg.generated Sun Feb 02 22:41:54 CST 2020
     */
    long countByExample(DataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data
     *
     * @mbg.generated Sun Feb 02 22:41:54 CST 2020
     */
    int deleteByExample(DataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data
     *
     * @mbg.generated Sun Feb 02 22:41:54 CST 2020
     */
    int deleteByPrimaryKey(Long dataId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data
     *
     * @mbg.generated Sun Feb 02 22:41:54 CST 2020
     */
    int insert(Data record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data
     *
     * @mbg.generated Sun Feb 02 22:41:54 CST 2020
     */
    int insertSelective(Data record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data
     *
     * @mbg.generated Sun Feb 02 22:41:54 CST 2020
     */
    List<Data> selectByExampleWithBLOBsWithRowbounds(DataExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data
     *
     * @mbg.generated Sun Feb 02 22:41:54 CST 2020
     */
    List<Data> selectByExampleWithBLOBs(DataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data
     *
     * @mbg.generated Sun Feb 02 22:41:54 CST 2020
     */
    List<Data> selectByExampleWithRowbounds(DataExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data
     *
     * @mbg.generated Sun Feb 02 22:41:54 CST 2020
     */
    List<Data> selectByExample(DataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data
     *
     * @mbg.generated Sun Feb 02 22:41:54 CST 2020
     */
    Data selectByPrimaryKey(Long dataId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data
     *
     * @mbg.generated Sun Feb 02 22:41:54 CST 2020
     */
    int updateByExampleSelective(@Param("record") Data record, @Param("example") DataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data
     *
     * @mbg.generated Sun Feb 02 22:41:54 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") Data record, @Param("example") DataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data
     *
     * @mbg.generated Sun Feb 02 22:41:54 CST 2020
     */
    int updateByExample(@Param("record") Data record, @Param("example") DataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data
     *
     * @mbg.generated Sun Feb 02 22:41:54 CST 2020
     */
    int updateByPrimaryKeySelective(Data record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data
     *
     * @mbg.generated Sun Feb 02 22:41:54 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(Data record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data
     *
     * @mbg.generated Sun Feb 02 22:41:54 CST 2020
     */
    int updateByPrimaryKey(Data record);
}