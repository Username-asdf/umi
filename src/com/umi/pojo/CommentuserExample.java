package com.umi.pojo;

import java.util.ArrayList;
import java.util.List;

public class CommentuserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public CommentuserExample() {
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

        public Criteria andCuidIsNull() {
            addCriterion("cuId is null");
            return (Criteria) this;
        }

        public Criteria andCuidIsNotNull() {
            addCriterion("cuId is not null");
            return (Criteria) this;
        }

        public Criteria andCuidEqualTo(Long value) {
            addCriterion("cuId =", value, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidNotEqualTo(Long value) {
            addCriterion("cuId <>", value, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidGreaterThan(Long value) {
            addCriterion("cuId >", value, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidGreaterThanOrEqualTo(Long value) {
            addCriterion("cuId >=", value, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidLessThan(Long value) {
            addCriterion("cuId <", value, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidLessThanOrEqualTo(Long value) {
            addCriterion("cuId <=", value, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidIn(List<Long> values) {
            addCriterion("cuId in", values, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidNotIn(List<Long> values) {
            addCriterion("cuId not in", values, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidBetween(Long value1, Long value2) {
            addCriterion("cuId between", value1, value2, "cuid");
            return (Criteria) this;
        }

        public Criteria andCuidNotBetween(Long value1, Long value2) {
            addCriterion("cuId not between", value1, value2, "cuid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Long value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Long value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Long value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Long value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Long value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Long> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Long> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Long value1, Long value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Long value1, Long value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andCommidIsNull() {
            addCriterion("commId is null");
            return (Criteria) this;
        }

        public Criteria andCommidIsNotNull() {
            addCriterion("commId is not null");
            return (Criteria) this;
        }

        public Criteria andCommidEqualTo(Long value) {
            addCriterion("commId =", value, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidNotEqualTo(Long value) {
            addCriterion("commId <>", value, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidGreaterThan(Long value) {
            addCriterion("commId >", value, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidGreaterThanOrEqualTo(Long value) {
            addCriterion("commId >=", value, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidLessThan(Long value) {
            addCriterion("commId <", value, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidLessThanOrEqualTo(Long value) {
            addCriterion("commId <=", value, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidIn(List<Long> values) {
            addCriterion("commId in", values, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidNotIn(List<Long> values) {
            addCriterion("commId not in", values, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidBetween(Long value1, Long value2) {
            addCriterion("commId between", value1, value2, "commid");
            return (Criteria) this;
        }

        public Criteria andCommidNotBetween(Long value1, Long value2) {
            addCriterion("commId not between", value1, value2, "commid");
            return (Criteria) this;
        }

        public Criteria andLorhIsNull() {
            addCriterion("lOrh is null");
            return (Criteria) this;
        }

        public Criteria andLorhIsNotNull() {
            addCriterion("lOrh is not null");
            return (Criteria) this;
        }

        public Criteria andLorhEqualTo(Integer value) {
            addCriterion("lOrh =", value, "lorh");
            return (Criteria) this;
        }

        public Criteria andLorhNotEqualTo(Integer value) {
            addCriterion("lOrh <>", value, "lorh");
            return (Criteria) this;
        }

        public Criteria andLorhGreaterThan(Integer value) {
            addCriterion("lOrh >", value, "lorh");
            return (Criteria) this;
        }

        public Criteria andLorhGreaterThanOrEqualTo(Integer value) {
            addCriterion("lOrh >=", value, "lorh");
            return (Criteria) this;
        }

        public Criteria andLorhLessThan(Integer value) {
            addCriterion("lOrh <", value, "lorh");
            return (Criteria) this;
        }

        public Criteria andLorhLessThanOrEqualTo(Integer value) {
            addCriterion("lOrh <=", value, "lorh");
            return (Criteria) this;
        }

        public Criteria andLorhIn(List<Integer> values) {
            addCriterion("lOrh in", values, "lorh");
            return (Criteria) this;
        }

        public Criteria andLorhNotIn(List<Integer> values) {
            addCriterion("lOrh not in", values, "lorh");
            return (Criteria) this;
        }

        public Criteria andLorhBetween(Integer value1, Integer value2) {
            addCriterion("lOrh between", value1, value2, "lorh");
            return (Criteria) this;
        }

        public Criteria andLorhNotBetween(Integer value1, Integer value2) {
            addCriterion("lOrh not between", value1, value2, "lorh");
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