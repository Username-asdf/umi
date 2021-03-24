package com.umi.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public CountExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andCountidIsNull() {
            addCriterion("countId is null");
            return (Criteria) this;
        }

        public Criteria andCountidIsNotNull() {
            addCriterion("countId is not null");
            return (Criteria) this;
        }

        public Criteria andCountidEqualTo(Long value) {
            addCriterion("countId =", value, "countid");
            return (Criteria) this;
        }

        public Criteria andCountidNotEqualTo(Long value) {
            addCriterion("countId <>", value, "countid");
            return (Criteria) this;
        }

        public Criteria andCountidGreaterThan(Long value) {
            addCriterion("countId >", value, "countid");
            return (Criteria) this;
        }

        public Criteria andCountidGreaterThanOrEqualTo(Long value) {
            addCriterion("countId >=", value, "countid");
            return (Criteria) this;
        }

        public Criteria andCountidLessThan(Long value) {
            addCriterion("countId <", value, "countid");
            return (Criteria) this;
        }

        public Criteria andCountidLessThanOrEqualTo(Long value) {
            addCriterion("countId <=", value, "countid");
            return (Criteria) this;
        }

        public Criteria andCountidIn(List<Long> values) {
            addCriterion("countId in", values, "countid");
            return (Criteria) this;
        }

        public Criteria andCountidNotIn(List<Long> values) {
            addCriterion("countId not in", values, "countid");
            return (Criteria) this;
        }

        public Criteria andCountidBetween(Long value1, Long value2) {
            addCriterion("countId between", value1, value2, "countid");
            return (Criteria) this;
        }

        public Criteria andCountidNotBetween(Long value1, Long value2) {
            addCriterion("countId not between", value1, value2, "countid");
            return (Criteria) this;
        }

        public Criteria andCountnumIsNull() {
            addCriterion("countNum is null");
            return (Criteria) this;
        }

        public Criteria andCountnumIsNotNull() {
            addCriterion("countNum is not null");
            return (Criteria) this;
        }

        public Criteria andCountnumEqualTo(Long value) {
            addCriterion("countNum =", value, "countnum");
            return (Criteria) this;
        }

        public Criteria andCountnumNotEqualTo(Long value) {
            addCriterion("countNum <>", value, "countnum");
            return (Criteria) this;
        }

        public Criteria andCountnumGreaterThan(Long value) {
            addCriterion("countNum >", value, "countnum");
            return (Criteria) this;
        }

        public Criteria andCountnumGreaterThanOrEqualTo(Long value) {
            addCriterion("countNum >=", value, "countnum");
            return (Criteria) this;
        }

        public Criteria andCountnumLessThan(Long value) {
            addCriterion("countNum <", value, "countnum");
            return (Criteria) this;
        }

        public Criteria andCountnumLessThanOrEqualTo(Long value) {
            addCriterion("countNum <=", value, "countnum");
            return (Criteria) this;
        }

        public Criteria andCountnumIn(List<Long> values) {
            addCriterion("countNum in", values, "countnum");
            return (Criteria) this;
        }

        public Criteria andCountnumNotIn(List<Long> values) {
            addCriterion("countNum not in", values, "countnum");
            return (Criteria) this;
        }

        public Criteria andCountnumBetween(Long value1, Long value2) {
            addCriterion("countNum between", value1, value2, "countnum");
            return (Criteria) this;
        }

        public Criteria andCountnumNotBetween(Long value1, Long value2) {
            addCriterion("countNum not between", value1, value2, "countnum");
            return (Criteria) this;
        }

        public Criteria andCountloginnumIsNull() {
            addCriterion("countLoginNum is null");
            return (Criteria) this;
        }

        public Criteria andCountloginnumIsNotNull() {
            addCriterion("countLoginNum is not null");
            return (Criteria) this;
        }

        public Criteria andCountloginnumEqualTo(Long value) {
            addCriterion("countLoginNum =", value, "countloginnum");
            return (Criteria) this;
        }

        public Criteria andCountloginnumNotEqualTo(Long value) {
            addCriterion("countLoginNum <>", value, "countloginnum");
            return (Criteria) this;
        }

        public Criteria andCountloginnumGreaterThan(Long value) {
            addCriterion("countLoginNum >", value, "countloginnum");
            return (Criteria) this;
        }

        public Criteria andCountloginnumGreaterThanOrEqualTo(Long value) {
            addCriterion("countLoginNum >=", value, "countloginnum");
            return (Criteria) this;
        }

        public Criteria andCountloginnumLessThan(Long value) {
            addCriterion("countLoginNum <", value, "countloginnum");
            return (Criteria) this;
        }

        public Criteria andCountloginnumLessThanOrEqualTo(Long value) {
            addCriterion("countLoginNum <=", value, "countloginnum");
            return (Criteria) this;
        }

        public Criteria andCountloginnumIn(List<Long> values) {
            addCriterion("countLoginNum in", values, "countloginnum");
            return (Criteria) this;
        }

        public Criteria andCountloginnumNotIn(List<Long> values) {
            addCriterion("countLoginNum not in", values, "countloginnum");
            return (Criteria) this;
        }

        public Criteria andCountloginnumBetween(Long value1, Long value2) {
            addCriterion("countLoginNum between", value1, value2, "countloginnum");
            return (Criteria) this;
        }

        public Criteria andCountloginnumNotBetween(Long value1, Long value2) {
            addCriterion("countLoginNum not between", value1, value2, "countloginnum");
            return (Criteria) this;
        }

        public Criteria andCountdateIsNull() {
            addCriterion("countDate is null");
            return (Criteria) this;
        }

        public Criteria andCountdateIsNotNull() {
            addCriterion("countDate is not null");
            return (Criteria) this;
        }

        public Criteria andCountdateEqualTo(Date value) {
            addCriterionForJDBCDate("countDate =", value, "countdate");
            return (Criteria) this;
        }

        public Criteria andCountdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("countDate <>", value, "countdate");
            return (Criteria) this;
        }

        public Criteria andCountdateGreaterThan(Date value) {
            addCriterionForJDBCDate("countDate >", value, "countdate");
            return (Criteria) this;
        }

        public Criteria andCountdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("countDate >=", value, "countdate");
            return (Criteria) this;
        }

        public Criteria andCountdateLessThan(Date value) {
            addCriterionForJDBCDate("countDate <", value, "countdate");
            return (Criteria) this;
        }

        public Criteria andCountdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("countDate <=", value, "countdate");
            return (Criteria) this;
        }

        public Criteria andCountdateIn(List<Date> values) {
            addCriterionForJDBCDate("countDate in", values, "countdate");
            return (Criteria) this;
        }

        public Criteria andCountdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("countDate not in", values, "countdate");
            return (Criteria) this;
        }

        public Criteria andCountdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("countDate between", value1, value2, "countdate");
            return (Criteria) this;
        }

        public Criteria andCountdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("countDate not between", value1, value2, "countdate");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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