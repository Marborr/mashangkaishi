package life.mashangkaishi.manongcommunity.mapper;

import java.util.List;
import life.mashangkaishi.manongcommunity.model.Administrator;
import life.mashangkaishi.manongcommunity.model.AdministratorExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface AdministratorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table administrator
     *
     * @mbg.generated Fri Jan 24 17:09:45 CST 2020
     */
    long countByExample(AdministratorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table administrator
     *
     * @mbg.generated Fri Jan 24 17:09:45 CST 2020
     */
    int deleteByExample(AdministratorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table administrator
     *
     * @mbg.generated Fri Jan 24 17:09:45 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table administrator
     *
     * @mbg.generated Fri Jan 24 17:09:45 CST 2020
     */
    int insert(Administrator record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table administrator
     *
     * @mbg.generated Fri Jan 24 17:09:45 CST 2020
     */
    int insertSelective(Administrator record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table administrator
     *
     * @mbg.generated Fri Jan 24 17:09:45 CST 2020
     */
    List<Administrator> selectByExampleWithBLOBsWithRowbounds(AdministratorExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table administrator
     *
     * @mbg.generated Fri Jan 24 17:09:45 CST 2020
     */
    List<Administrator> selectByExampleWithBLOBs(AdministratorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table administrator
     *
     * @mbg.generated Fri Jan 24 17:09:45 CST 2020
     */
    List<Administrator> selectByExampleWithRowbounds(AdministratorExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table administrator
     *
     * @mbg.generated Fri Jan 24 17:09:45 CST 2020
     */
    List<Administrator> selectByExample(AdministratorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table administrator
     *
     * @mbg.generated Fri Jan 24 17:09:45 CST 2020
     */
    Administrator selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table administrator
     *
     * @mbg.generated Fri Jan 24 17:09:45 CST 2020
     */
    int updateByExampleSelective(@Param("record") Administrator record, @Param("example") AdministratorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table administrator
     *
     * @mbg.generated Fri Jan 24 17:09:45 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") Administrator record, @Param("example") AdministratorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table administrator
     *
     * @mbg.generated Fri Jan 24 17:09:45 CST 2020
     */
    int updateByExample(@Param("record") Administrator record, @Param("example") AdministratorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table administrator
     *
     * @mbg.generated Fri Jan 24 17:09:45 CST 2020
     */
    int updateByPrimaryKeySelective(Administrator record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table administrator
     *
     * @mbg.generated Fri Jan 24 17:09:45 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(Administrator record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table administrator
     *
     * @mbg.generated Fri Jan 24 17:09:45 CST 2020
     */
    int updateByPrimaryKey(Administrator record);
}