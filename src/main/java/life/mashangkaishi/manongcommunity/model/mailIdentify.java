package life.mashangkaishi.manongcommunity.model;

public class mailIdentify {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mail_identify.id
     *
     * @mbg.generated Thu Feb 27 21:05:30 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mail_identify.email
     *
     * @mbg.generated Thu Feb 27 21:05:30 CST 2020
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mail_identify.identify_number
     *
     * @mbg.generated Thu Feb 27 21:05:30 CST 2020
     */
    private String identifyNumber;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mail_identify.id
     *
     * @return the value of mail_identify.id
     *
     * @mbg.generated Thu Feb 27 21:05:30 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mail_identify.id
     *
     * @param id the value for mail_identify.id
     *
     * @mbg.generated Thu Feb 27 21:05:30 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mail_identify.email
     *
     * @return the value of mail_identify.email
     *
     * @mbg.generated Thu Feb 27 21:05:30 CST 2020
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mail_identify.email
     *
     * @param email the value for mail_identify.email
     *
     * @mbg.generated Thu Feb 27 21:05:30 CST 2020
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mail_identify.identify_number
     *
     * @return the value of mail_identify.identify_number
     *
     * @mbg.generated Thu Feb 27 21:05:30 CST 2020
     */
    public String getIdentifyNumber() {
        return identifyNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mail_identify.identify_number
     *
     * @param identifyNumber the value for mail_identify.identify_number
     *
     * @mbg.generated Thu Feb 27 21:05:30 CST 2020
     */
    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber == null ? null : identifyNumber.trim();
    }
}