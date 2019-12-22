package life.mashangkaishi.manongcommunity.model;

public class Student {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.id
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.username
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.password
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.sex
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    private Integer sex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.gmt_create
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.state
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    private Integer state;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.email
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.card_number
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    private Long cardNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.rank_number
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    private Integer rankNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.security_issue
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    private String securityIssue;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.verification_code
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    private Integer verificationCode;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.id
     *
     * @return the value of student.id
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.id
     *
     * @param id the value for student.id
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.username
     *
     * @return the value of student.username
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.username
     *
     * @param username the value for student.username
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.password
     *
     * @return the value of student.password
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.password
     *
     * @param password the value for student.password
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.sex
     *
     * @return the value of student.sex
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.sex
     *
     * @param sex the value for student.sex
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.gmt_create
     *
     * @return the value of student.gmt_create
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.gmt_create
     *
     * @param gmtCreate the value for student.gmt_create
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.state
     *
     * @return the value of student.state
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.state
     *
     * @param state the value for student.state
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.email
     *
     * @return the value of student.email
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.email
     *
     * @param email the value for student.email
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.card_number
     *
     * @return the value of student.card_number
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    public Long getCardNumber() {
        return cardNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.card_number
     *
     * @param cardNumber the value for student.card_number
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.rank_number
     *
     * @return the value of student.rank_number
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    public Integer getRankNumber() {
        return rankNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.rank_number
     *
     * @param rankNumber the value for student.rank_number
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    public void setRankNumber(Integer rankNumber) {
        this.rankNumber = rankNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.security_issue
     *
     * @return the value of student.security_issue
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    public String getSecurityIssue() {
        return securityIssue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.security_issue
     *
     * @param securityIssue the value for student.security_issue
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    public void setSecurityIssue(String securityIssue) {
        this.securityIssue = securityIssue == null ? null : securityIssue.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.verification_code
     *
     * @return the value of student.verification_code
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    public Integer getVerificationCode() {
        return verificationCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.verification_code
     *
     * @param verificationCode the value for student.verification_code
     *
     * @mbg.generated Mon Dec 23 02:03:46 CST 2019
     */
    public void setVerificationCode(Integer verificationCode) {
        this.verificationCode = verificationCode;
    }
}