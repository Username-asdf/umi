package com.umi.pojo;

import java.util.ArrayList;
import java.util.List;

public class FriendsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public FriendsExample() {
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

        public Criteria andFidIsNull() {
            addCriterion("fId is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("fId is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(Long value) {
            addCriterion("fId =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(Long value) {
            addCriterion("fId <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(Long value) {
            addCriterion("fId >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(Long value) {
            addCriterion("fId >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(Long value) {
            addCriterion("fId <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(Long value) {
            addCriterion("fId <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<Long> values) {
            addCriterion("fId in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<Long> values) {
            addCriterion("fId not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(Long value1, Long value2) {
            addCriterion("fId between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(Long value1, Long value2) {
            addCriterion("fId not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andBeattenduseridIsNull() {
            addCriterion("beAttendUserId is null");
            return (Criteria) this;
        }

        public Criteria andBeattenduseridIsNotNull() {
            addCriterion("beAttendUserId is not null");
            return (Criteria) this;
        }

        public Criteria andBeattenduseridEqualTo(Long value) {
            addCriterion("beAttendUserId =", value, "beattenduserid");
            return (Criteria) this;
        }

        public Criteria andBeattenduseridNotEqualTo(Long value) {
            addCriterion("beAttendUserId <>", value, "beattenduserid");
            return (Criteria) this;
        }

        public Criteria andBeattenduseridGreaterThan(Long value) {
            addCriterion("beAttendUserId >", value, "beattenduserid");
            return (Criteria) this;
        }

        public Criteria andBeattenduseridGreaterThanOrEqualTo(Long value) {
            addCriterion("beAttendUserId >=", value, "beattenduserid");
            return (Criteria) this;
        }

        public Criteria andBeattenduseridLessThan(Long value) {
            addCriterion("beAttendUserId <", value, "beattenduserid");
            return (Criteria) this;
        }

        public Criteria andBeattenduseridLessThanOrEqualTo(Long value) {
            addCriterion("beAttendUserId <=", value, "beattenduserid");
            return (Criteria) this;
        }

        public Criteria andBeattenduseridIn(List<Long> values) {
            addCriterion("beAttendUserId in", values, "beattenduserid");
            return (Criteria) this;
        }

        public Criteria andBeattenduseridNotIn(List<Long> values) {
            addCriterion("beAttendUserId not in", values, "beattenduserid");
            return (Criteria) this;
        }

        public Criteria andBeattenduseridBetween(Long value1, Long value2) {
            addCriterion("beAttendUserId between", value1, value2, "beattenduserid");
            return (Criteria) this;
        }

        public Criteria andBeattenduseridNotBetween(Long value1, Long value2) {
            addCriterion("beAttendUserId not between", value1, value2, "beattenduserid");
            return (Criteria) this;
        }

        public Criteria andAttenduseridIsNull() {
            addCriterion("attendUserId is null");
            return (Criteria) this;
        }

        public Criteria andAttenduseridIsNotNull() {
            addCriterion("attendUserId is not null");
            return (Criteria) this;
        }

        public Criteria andAttenduseridEqualTo(Long value) {
            addCriterion("attendUserId =", value, "attenduserid");
            return (Criteria) this;
        }

        public Criteria andAttenduseridNotEqualTo(Long value) {
            addCriterion("attendUserId <>", value, "attenduserid");
            return (Criteria) this;
        }

        public Criteria andAttenduseridGreaterThan(Long value) {
            addCriterion("attendUserId >", value, "attenduserid");
            return (Criteria) this;
        }

        public Criteria andAttenduseridGreaterThanOrEqualTo(Long value) {
            addCriterion("attendUserId >=", value, "attenduserid");
            return (Criteria) this;
        }

        public Criteria andAttenduseridLessThan(Long value) {
            addCriterion("attendUserId <", value, "attenduserid");
            return (Criteria) this;
        }

        public Criteria andAttenduseridLessThanOrEqualTo(Long value) {
            addCriterion("attendUserId <=", value, "attenduserid");
            return (Criteria) this;
        }

        public Criteria andAttenduseridIn(List<Long> values) {
            addCriterion("attendUserId in", values, "attenduserid");
            return (Criteria) this;
        }

        public Criteria andAttenduseridNotIn(List<Long> values) {
            addCriterion("attendUserId not in", values, "attenduserid");
            return (Criteria) this;
        }

        public Criteria andAttenduseridBetween(Long value1, Long value2) {
            addCriterion("attendUserId between", value1, value2, "attenduserid");
            return (Criteria) this;
        }

        public Criteria andAttenduseridNotBetween(Long value1, Long value2) {
            addCriterion("attendUserId not between", value1, value2, "attenduserid");
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