package life.mashangkaishi.manongcommunity.model;

public class Student {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.id
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.stu_id
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    private String stuId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.password
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.sex
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    private Integer sex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.gmt_create
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    private String gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.state
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    private Integer state;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.email
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.card_number
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    private Long cardNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.rank_number
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    private Integer rankNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.security_issue
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    private String securityIssue;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.verification_code
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    private Integer verificationCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.class_number
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    private String classNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.class_name
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    private String className;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.task_done
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    private Integer taskDone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.task_not_done
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    private Integer taskNotDone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.identify
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    private String identify;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.student_name
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    private String studentName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.id
     *
     * @return the value of student.id
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
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
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.stu_id
     *
     * @return the value of student.stu_id
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    public String getStuId() {
        return stuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.stu_id
     *
     * @param stuId the value for student.stu_id
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.password
     *
     * @return the value of student.password
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
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
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
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
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
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
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
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
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    public String getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.gmt_create
     *
     * @param gmtCreate the value for student.gmt_create
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate == null ? null : gmtCreate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.state
     *
     * @return the value of student.state
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
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
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
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
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
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
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
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
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
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
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
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
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
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
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
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
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
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
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
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
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
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
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    public void setVerificationCode(Integer verificationCode) {
        this.verificationCode = verificationCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.class_number
     *
     * @return the value of student.class_number
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    public String getClassNumber() {
        return classNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.class_number
     *
     * @param classNumber the value for student.class_number
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber == null ? null : classNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.class_name
     *
     * @return the value of student.class_name
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    public String getClassName() {
        return className;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.class_name
     *
     * @param className the value for student.class_name
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.task_done
     *
     * @return the value of student.task_done
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    public Integer getTaskDone() {
        return taskDone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.task_done
     *
     * @param taskDone the value for student.task_done
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    public void setTaskDone(Integer taskDone) {
        this.taskDone = taskDone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.task_not_done
     *
     * @return the value of student.task_not_done
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    public Integer getTaskNotDone() {
        return taskNotDone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.task_not_done
     *
     * @param taskNotDone the value for student.task_not_done
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    public void setTaskNotDone(Integer taskNotDone) {
        this.taskNotDone = taskNotDone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.identify
     *
     * @return the value of student.identify
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    public String getIdentify() {
        return identify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.identify
     *
     * @param identify the value for student.identify
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    public void setIdentify(String identify) {
        this.identify = identify == null ? null : identify.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.student_name
     *
     * @return the value of student.student_name
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.student_name
     *
     * @param studentName the value for student.student_name
     *
     * @mbg.generated Wed Feb 12 20:32:33 CST 2020
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }
}