package life.mashangkaishi.manongcommunity.model;

public class Administrator {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column administrator.id
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column administrator.username
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column administrator.password
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column administrator.sex
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    private Integer sex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column administrator.departments
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    private String departments;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column administrator.state
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    private Integer state;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column administrator.email
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column administrator.security_issue
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    private String securityIssue;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column administrator.verification
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    private Integer verification;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column administrator.gmt_create
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    private String gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column administrator.class_number
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    private String classNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column administrator.class_name
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    private String className;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column administrator.task_name
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    private Integer taskName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column administrator.my_student
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    private String myStudent;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column administrator.id
     *
     * @return the value of administrator.id
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column administrator.id
     *
     * @param id the value for administrator.id
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column administrator.username
     *
     * @return the value of administrator.username
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column administrator.username
     *
     * @param username the value for administrator.username
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column administrator.password
     *
     * @return the value of administrator.password
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column administrator.password
     *
     * @param password the value for administrator.password
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column administrator.sex
     *
     * @return the value of administrator.sex
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column administrator.sex
     *
     * @param sex the value for administrator.sex
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column administrator.departments
     *
     * @return the value of administrator.departments
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public String getDepartments() {
        return departments;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column administrator.departments
     *
     * @param departments the value for administrator.departments
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public void setDepartments(String departments) {
        this.departments = departments == null ? null : departments.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column administrator.state
     *
     * @return the value of administrator.state
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column administrator.state
     *
     * @param state the value for administrator.state
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column administrator.email
     *
     * @return the value of administrator.email
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column administrator.email
     *
     * @param email the value for administrator.email
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column administrator.security_issue
     *
     * @return the value of administrator.security_issue
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public String getSecurityIssue() {
        return securityIssue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column administrator.security_issue
     *
     * @param securityIssue the value for administrator.security_issue
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public void setSecurityIssue(String securityIssue) {
        this.securityIssue = securityIssue == null ? null : securityIssue.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column administrator.verification
     *
     * @return the value of administrator.verification
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public Integer getVerification() {
        return verification;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column administrator.verification
     *
     * @param verification the value for administrator.verification
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public void setVerification(Integer verification) {
        this.verification = verification;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column administrator.gmt_create
     *
     * @return the value of administrator.gmt_create
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public String getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column administrator.gmt_create
     *
     * @param gmtCreate the value for administrator.gmt_create
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate == null ? null : gmtCreate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column administrator.class_number
     *
     * @return the value of administrator.class_number
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public String getClassNumber() {
        return classNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column administrator.class_number
     *
     * @param classNumber the value for administrator.class_number
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber == null ? null : classNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column administrator.class_name
     *
     * @return the value of administrator.class_name
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public String getClassName() {
        return className;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column administrator.class_name
     *
     * @param className the value for administrator.class_name
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column administrator.task_name
     *
     * @return the value of administrator.task_name
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public Integer getTaskName() {
        return taskName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column administrator.task_name
     *
     * @param taskName the value for administrator.task_name
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public void setTaskName(Integer taskName) {
        this.taskName = taskName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column administrator.my_student
     *
     * @return the value of administrator.my_student
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public String getMyStudent() {
        return myStudent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column administrator.my_student
     *
     * @param myStudent the value for administrator.my_student
     *
     * @mbg.generated Sat Feb 01 09:09:06 CST 2020
     */
    public void setMyStudent(String myStudent) {
        this.myStudent = myStudent == null ? null : myStudent.trim();
    }
}