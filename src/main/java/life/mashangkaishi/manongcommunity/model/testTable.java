package life.mashangkaishi.manongcommunity.model;

import java.util.Date;

public class testTable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_table.id
     *
     * @mbg.generated Sun Mar 01 23:11:45 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_table.description
     *
     * @mbg.generated Sun Mar 01 23:11:45 CST 2020
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_table.time
     *
     * @mbg.generated Sun Mar 01 23:11:45 CST 2020
     */
    private Date time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column test_table.data_time
     *
     * @mbg.generated Sun Mar 01 23:11:45 CST 2020
     */
    private Date dataTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_table.id
     *
     * @return the value of test_table.id
     *
     * @mbg.generated Sun Mar 01 23:11:45 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_table.id
     *
     * @param id the value for test_table.id
     *
     * @mbg.generated Sun Mar 01 23:11:45 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_table.description
     *
     * @return the value of test_table.description
     *
     * @mbg.generated Sun Mar 01 23:11:45 CST 2020
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_table.description
     *
     * @param description the value for test_table.description
     *
     * @mbg.generated Sun Mar 01 23:11:45 CST 2020
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_table.time
     *
     * @return the value of test_table.time
     *
     * @mbg.generated Sun Mar 01 23:11:45 CST 2020
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_table.time
     *
     * @param time the value for test_table.time
     *
     * @mbg.generated Sun Mar 01 23:11:45 CST 2020
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column test_table.data_time
     *
     * @return the value of test_table.data_time
     *
     * @mbg.generated Sun Mar 01 23:11:45 CST 2020
     */
    public Date getDataTime() {
        return dataTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column test_table.data_time
     *
     * @param dataTime the value for test_table.data_time
     *
     * @mbg.generated Sun Mar 01 23:11:45 CST 2020
     */
    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }
}