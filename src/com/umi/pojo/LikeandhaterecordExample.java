package com.umi.pojo;

import java.util.ArrayList;
import java.util.List;

public class LikeandhaterecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public LikeandhaterecordExample() {
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

        public Criteria andLhidIsNull() {
            addCriterion("lhId is null");
            return (Criteria) this;
        }

        public Criteria andLhidIsNotNull() {
            addCriterion("lhId is not null");
            return (Criteria) this;
        }

        public Criteria andLhidEqualTo(Long value) {
            addCriterion("lhId =", value, "lhid");
            return (Criteria) this;
        }

        public Criteria andLhidNotEqualTo(Long value) {
            addCriterion("lhId <>", value, "lhid");
            return (Criteria) this;
        }

        public Criteria andLhidGreaterThan(Long value) {
            addCriterion("lhId >", value, "lhid");
            return (Criteria) this;
        }

        public Criteria andLhidGreaterThanOrEqualTo(Long value) {
            addCriterion("lhId >=", value, "lhid");
            return (Criteria) this;
        }

        public Criteria andLhidLessThan(Long value) {
            addCriterion("lhId <", value, "lhid");
            return (Criteria) this;
        }

        public Criteria andLhidLessThanOrEqualTo(Long value) {
            addCriterion("lhId <=", value, "lhid");
            return (Criteria) this;
        }

        public Criteria andLhidIn(List<Long> values) {
            addCriterion("lhId in", values, "lhid");
            return (Criteria) this;
        }

        public Criteria andLhidNotIn(List<Long> values) {
            addCriterion("lhId not in", values, "lhid");
            return (Criteria) this;
        }

        public Criteria andLhidBetween(Long value1, Long value2) {
            addCriterion("lhId between", value1, value2, "lhid");
            return (Criteria) this;
        }

        public Criteria andLhidNotBetween(Long value1, Long value2) {
            addCriterion("lhId not between", value1, value2, "lhid");
            return (Criteria) this;
        }

        public Criteria andPostidIsNull() {
            addCriterion("postId is null");
            return (Criteria) this;
        }

        public Criteria andPostidIsNotNull() {
            addCriterion("postId is not null");
            return (Criteria) this;
        }

        public Criteria andPostidEqualTo(Long value) {
            addCriterion("postId =", value, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidNotEqualTo(Long value) {
            addCriterion("postId <>", value, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidGreaterThan(Long value) {
            addCriterion("postId >", value, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidGreaterThanOrEqualTo(Long value) {
            addCriterion("postId >=", value, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidLessThan(Long value) {
            addCriterion("postId <", value, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidLessThanOrEqualTo(Long value) {
            addCriterion("postId <=", value, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidIn(List<Long> values) {
            addCriterion("postId in", values, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidNotIn(List<Long> values) {
            addCriterion("postId not in", values, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidBetween(Long value1, Long value2) {
            addCriterion("postId between", value1, value2, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidNotBetween(Long value1, Long value2) {
            addCriterion("postId not between", value1, value2, "postid");
            return (Criteria) this;
        }

        public Criteria andUsersidIsNull() {
            addCriterion("usersId is null");
            return (Criteria) this;
        }

        public Criteria andUsersidIsNotNull() {
            addCriterion("usersId is not null");
            return (Criteria) this;
        }

        public Criteria andUsersidEqualTo(Long value) {
            addCriterion("usersId =", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidNotEqualTo(Long value) {
            addCriterion("usersId <>", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidGreaterThan(Long value) {
            addCriterion("usersId >", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidGreaterThanOrEqualTo(Long value) {
            addCriterion("usersId >=", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidLessThan(Long value) {
            addCriterion("usersId <", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidLessThanOrEqualTo(Long value) {
            addCriterion("usersId <=", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidIn(List<Long> values) {
            addCriterion("usersId in", values, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidNotIn(List<Long> values) {
            addCriterion("usersId not in", values, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidBetween(Long value1, Long value2) {
            addCriterion("usersId between", value1, value2, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidNotBetween(Long value1, Long value2) {
            addCriterion("usersId not between", value1, value2, "usersid");
            return (Criteria) this;
        }

        public Criteria andLorhIsNull() {
            addCriterion("lOrH is null");
            return (Criteria) this;
        }

        public Criteria andLorhIsNotNull() {
            addCriterion("lOrH is not null");
            return (Criteria) this;
        }

        public Criteria andLorhEqualTo(Integer value) {
            addCriterion("lOrH =", value, "lorh");
            return (Criteria) this;
        }

        public Criteria andLorhNotEqualTo(Integer value) {
            addCriterion("lOrH <>", value, "lorh");
            return (Criteria) this;
        }

        public Criteria andLorhGreaterThan(Integer value) {
            addCriterion("lOrH >", value, "lorh");
            return (Criteria) this;
        }

        public Criteria andLorhGreaterThanOrEqualTo(Integer value) {
            addCriterion("lOrH >=", value, "lorh");
            return (Criteria) this;
        }

        public Criteria andLorhLessThan(Integer value) {
            addCriterion("lOrH <", value, "lorh");
            return (Criteria) this;
        }

        public Criteria andLorhLessThanOrEqualTo(Integer value) {
            addCriterion("lOrH <=", value, "lorh");
            return (Criteria) this;
        }

        public Criteria andLorhIn(List<Integer> values) {
            addCriterion("lOrH in", values, "lorh");
            return (Criteria) this;
        }

        public Criteria andLorhNotIn(List<Integer> values) {
            addCriterion("lOrH not in", values, "lorh");
            return (Criteria) this;
        }

        public Criteria andLorhBetween(Integer value1, Integer value2) {
            addCriterion("lOrH between", value1, value2, "lorh");
            return (Criteria) this;
        }

        public Criteria andLorhNotBetween(Integer value1, Integer value2) {
            addCriterion("lOrH not between", value1, value2, "lorh");
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