package life.mashangkaishi.manongcommunity.model;

import java.util.ArrayList;
import java.util.List;

public class ClassExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table class
     *
     * @mbg.generated Tue Feb 04 22:49:36 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table class
     *
     * @mbg.generated Tue Feb 04 22:49:36 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table class
     *
     * @mbg.generated Tue Feb 04 22:49:36 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class
     *
     * @mbg.generated Tue Feb 04 22:49:36 CST 2020
     */
    public ClassExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class
     *
     * @mbg.generated Tue Feb 04 22:49:36 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class
     *
     * @mbg.generated Tue Feb 04 22:49:36 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class
     *
     * @mbg.generated Tue Feb 04 22:49:36 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class
     *
     * @mbg.generated Tue Feb 04 22:49:36 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class
     *
     * @mbg.generated Tue Feb 04 22:49:36 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class
     *
     * @mbg.generated Tue Feb 04 22:49:36 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class
     *
     * @mbg.generated Tue Feb 04 22:49:36 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class
     *
     * @mbg.generated Tue Feb 04 22:49:36 CST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class
     *
     * @mbg.generated Tue Feb 04 22:49:36 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class
     *
     * @mbg.generated Tue Feb 04 22:49:36 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table class
     *
     * @mbg.generated Tue Feb 04 22:49:36 CST 2020
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andClassNumberIsNull() {
            addCriterion("class_number is null");
            return (Criteria) this;
        }

        public Criteria andClassNumberIsNotNull() {
            addCriterion("class_number is not null");
            return (Criteria) this;
        }

        public Criteria andClassNumberEqualTo(Integer value) {
            addCriterion("class_number =", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberNotEqualTo(Integer value) {
            addCriterion("class_number <>", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberGreaterThan(Integer value) {
            addCriterion("class_number >", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("class_number >=", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberLessThan(Integer value) {
            addCriterion("class_number <", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberLessThanOrEqualTo(Integer value) {
            addCriterion("class_number <=", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberIn(List<Integer> values) {
            addCriterion("class_number in", values, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberNotIn(List<Integer> values) {
            addCriterion("class_number not in", values, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberBetween(Integer value1, Integer value2) {
            addCriterion("class_number between", value1, value2, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("class_number not between", value1, value2, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNull() {
            addCriterion("class_name is null");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNotNull() {
            addCriterion("class_name is not null");
            return (Criteria) this;
        }

        public Criteria andClassNameEqualTo(String value) {
            addCriterion("class_name =", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotEqualTo(String value) {
            addCriterion("class_name <>", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThan(String value) {
            addCriterion("class_name >", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("class_name >=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThan(String value) {
            addCriterion("class_name <", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThanOrEqualTo(String value) {
            addCriterion("class_name <=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLike(String value) {
            addCriterion("class_name like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotLike(String value) {
            addCriterion("class_name not like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameIn(List<String> values) {
            addCriterion("class_name in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotIn(List<String> values) {
            addCriterion("class_name not in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameBetween(String value1, String value2) {
            addCriterion("class_name between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotBetween(String value1, String value2) {
            addCriterion("class_name not between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andStudentsIsNull() {
            addCriterion("students is null");
            return (Criteria) this;
        }

        public Criteria andStudentsIsNotNull() {
            addCriterion("students is not null");
            return (Criteria) this;
        }

        public Criteria andStudentsEqualTo(String value) {
            addCriterion("students =", value, "students");
            return (Criteria) this;
        }

        public Criteria andStudentsNotEqualTo(String value) {
            addCriterion("students <>", value, "students");
            return (Criteria) this;
        }

        public Criteria andStudentsGreaterThan(String value) {
            addCriterion("students >", value, "students");
            return (Criteria) this;
        }

        public Criteria andStudentsGreaterThanOrEqualTo(String value) {
            addCriterion("students >=", value, "students");
            return (Criteria) this;
        }

        public Criteria andStudentsLessThan(String value) {
            addCriterion("students <", value, "students");
            return (Criteria) this;
        }

        public Criteria andStudentsLessThanOrEqualTo(String value) {
            addCriterion("students <=", value, "students");
            return (Criteria) this;
        }

        public Criteria andStudentsLike(String value) {
            addCriterion("students like", value, "students");
            return (Criteria) this;
        }

        public Criteria andStudentsNotLike(String value) {
            addCriterion("students not like", value, "students");
            return (Criteria) this;
        }

        public Criteria andStudentsIn(List<String> values) {
            addCriterion("students in", values, "students");
            return (Criteria) this;
        }

        public Criteria andStudentsNotIn(List<String> values) {
            addCriterion("students not in", values, "students");
            return (Criteria) this;
        }

        public Criteria andStudentsBetween(String value1, String value2) {
            addCriterion("students between", value1, value2, "students");
            return (Criteria) this;
        }

        public Criteria andStudentsNotBetween(String value1, String value2) {
            addCriterion("students not between", value1, value2, "students");
            return (Criteria) this;
        }

        public Criteria andMainTeacherIsNull() {
            addCriterion("main_teacher is null");
            return (Criteria) this;
        }

        public Criteria andMainTeacherIsNotNull() {
            addCriterion("main_teacher is not null");
            return (Criteria) this;
        }

        public Criteria andMainTeacherEqualTo(String value) {
            addCriterion("main_teacher =", value, "mainTeacher");
            return (Criteria) this;
        }

        public Criteria andMainTeacherNotEqualTo(String value) {
            addCriterion("main_teacher <>", value, "mainTeacher");
            return (Criteria) this;
        }

        public Criteria andMainTeacherGreaterThan(String value) {
            addCriterion("main_teacher >", value, "mainTeacher");
            return (Criteria) this;
        }

        public Criteria andMainTeacherGreaterThanOrEqualTo(String value) {
            addCriterion("main_teacher >=", value, "mainTeacher");
            return (Criteria) this;
        }

        public Criteria andMainTeacherLessThan(String value) {
            addCriterion("main_teacher <", value, "mainTeacher");
            return (Criteria) this;
        }

        public Criteria andMainTeacherLessThanOrEqualTo(String value) {
            addCriterion("main_teacher <=", value, "mainTeacher");
            return (Criteria) this;
        }

        public Criteria andMainTeacherLike(String value) {
            addCriterion("main_teacher like", value, "mainTeacher");
            return (Criteria) this;
        }

        public Criteria andMainTeacherNotLike(String value) {
            addCriterion("main_teacher not like", value, "mainTeacher");
            return (Criteria) this;
        }

        public Criteria andMainTeacherIn(List<String> values) {
            addCriterion("main_teacher in", values, "mainTeacher");
            return (Criteria) this;
        }

        public Criteria andMainTeacherNotIn(List<String> values) {
            addCriterion("main_teacher not in", values, "mainTeacher");
            return (Criteria) this;
        }

        public Criteria andMainTeacherBetween(String value1, String value2) {
            addCriterion("main_teacher between", value1, value2, "mainTeacher");
            return (Criteria) this;
        }

        public Criteria andMainTeacherNotBetween(String value1, String value2) {
            addCriterion("main_teacher not between", value1, value2, "mainTeacher");
            return (Criteria) this;
        }

        public Criteria andTeachersIsNull() {
            addCriterion("teachers is null");
            return (Criteria) this;
        }

        public Criteria andTeachersIsNotNull() {
            addCriterion("teachers is not null");
            return (Criteria) this;
        }

        public Criteria andTeachersEqualTo(String value) {
            addCriterion("teachers =", value, "teachers");
            return (Criteria) this;
        }

        public Criteria andTeachersNotEqualTo(String value) {
            addCriterion("teachers <>", value, "teachers");
            return (Criteria) this;
        }

        public Criteria andTeachersGreaterThan(String value) {
            addCriterion("teachers >", value, "teachers");
            return (Criteria) this;
        }

        public Criteria andTeachersGreaterThanOrEqualTo(String value) {
            addCriterion("teachers >=", value, "teachers");
            return (Criteria) this;
        }

        public Criteria andTeachersLessThan(String value) {
            addCriterion("teachers <", value, "teachers");
            return (Criteria) this;
        }

        public Criteria andTeachersLessThanOrEqualTo(String value) {
            addCriterion("teachers <=", value, "teachers");
            return (Criteria) this;
        }

        public Criteria andTeachersLike(String value) {
            addCriterion("teachers like", value, "teachers");
            return (Criteria) this;
        }

        public Criteria andTeachersNotLike(String value) {
            addCriterion("teachers not like", value, "teachers");
            return (Criteria) this;
        }

        public Criteria andTeachersIn(List<String> values) {
            addCriterion("teachers in", values, "teachers");
            return (Criteria) this;
        }

        public Criteria andTeachersNotIn(List<String> values) {
            addCriterion("teachers not in", values, "teachers");
            return (Criteria) this;
        }

        public Criteria andTeachersBetween(String value1, String value2) {
            addCriterion("teachers between", value1, value2, "teachers");
            return (Criteria) this;
        }

        public Criteria andTeachersNotBetween(String value1, String value2) {
            addCriterion("teachers not between", value1, value2, "teachers");
            return (Criteria) this;
        }

        public Criteria andGmtCreatIsNull() {
            addCriterion("gmt_creat is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatIsNotNull() {
            addCriterion("gmt_creat is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatEqualTo(String value) {
            addCriterion("gmt_creat =", value, "gmtCreat");
            return (Criteria) this;
        }

        public Criteria andGmtCreatNotEqualTo(String value) {
            addCriterion("gmt_creat <>", value, "gmtCreat");
            return (Criteria) this;
        }

        public Criteria andGmtCreatGreaterThan(String value) {
            addCriterion("gmt_creat >", value, "gmtCreat");
            return (Criteria) this;
        }

        public Criteria andGmtCreatGreaterThanOrEqualTo(String value) {
            addCriterion("gmt_creat >=", value, "gmtCreat");
            return (Criteria) this;
        }

        public Criteria andGmtCreatLessThan(String value) {
            addCriterion("gmt_creat <", value, "gmtCreat");
            return (Criteria) this;
        }

        public Criteria andGmtCreatLessThanOrEqualTo(String value) {
            addCriterion("gmt_creat <=", value, "gmtCreat");
            return (Criteria) this;
        }

        public Criteria andGmtCreatLike(String value) {
            addCriterion("gmt_creat like", value, "gmtCreat");
            return (Criteria) this;
        }

        public Criteria andGmtCreatNotLike(String value) {
            addCriterion("gmt_creat not like", value, "gmtCreat");
            return (Criteria) this;
        }

        public Criteria andGmtCreatIn(List<String> values) {
            addCriterion("gmt_creat in", values, "gmtCreat");
            return (Criteria) this;
        }

        public Criteria andGmtCreatNotIn(List<String> values) {
            addCriterion("gmt_creat not in", values, "gmtCreat");
            return (Criteria) this;
        }

        public Criteria andGmtCreatBetween(String value1, String value2) {
            addCriterion("gmt_creat between", value1, value2, "gmtCreat");
            return (Criteria) this;
        }

        public Criteria andGmtCreatNotBetween(String value1, String value2) {
            addCriterion("gmt_creat not between", value1, value2, "gmtCreat");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNull() {
            addCriterion("task_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("task_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("task_name =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("task_name <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("task_name >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_name >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("task_name <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("task_name <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("task_name like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("task_name not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("task_name in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("task_name not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("task_name between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("task_name not between", value1, value2, "taskName");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table class
     *
     * @mbg.generated do_not_delete_during_merge Tue Feb 04 22:49:36 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table class
     *
     * @mbg.generated Tue Feb 04 22:49:36 CST 2020
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}