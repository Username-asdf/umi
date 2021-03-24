package com.umi.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public CommentExample() {
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

        public Criteria andPostidIsNull() {
            addCriterion("postID is null");
            return (Criteria) this;
        }

        public Criteria andPostidIsNotNull() {
            addCriterion("postID is not null");
            return (Criteria) this;
        }

        public Criteria andPostidEqualTo(Long value) {
            addCriterion("postID =", value, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidNotEqualTo(Long value) {
            addCriterion("postID <>", value, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidGreaterThan(Long value) {
            addCriterion("postID >", value, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidGreaterThanOrEqualTo(Long value) {
            addCriterion("postID >=", value, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidLessThan(Long value) {
            addCriterion("postID <", value, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidLessThanOrEqualTo(Long value) {
            addCriterion("postID <=", value, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidIn(List<Long> values) {
            addCriterion("postID in", values, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidNotIn(List<Long> values) {
            addCriterion("postID not in", values, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidBetween(Long value1, Long value2) {
            addCriterion("postID between", value1, value2, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidNotBetween(Long value1, Long value2) {
            addCriterion("postID not between", value1, value2, "postid");
            return (Criteria) this;
        }

        public Criteria andFkcommidIsNull() {
            addCriterion("fkCommId is null");
            return (Criteria) this;
        }

        public Criteria andFkcommidIsNotNull() {
            addCriterion("fkCommId is not null");
            return (Criteria) this;
        }

        public Criteria andFkcommidEqualTo(Long value) {
            addCriterion("fkCommId =", value, "fkcommid");
            return (Criteria) this;
        }

        public Criteria andFkcommidNotEqualTo(Long value) {
            addCriterion("fkCommId <>", value, "fkcommid");
            return (Criteria) this;
        }

        public Criteria andFkcommidGreaterThan(Long value) {
            addCriterion("fkCommId >", value, "fkcommid");
            return (Criteria) this;
        }

        public Criteria andFkcommidGreaterThanOrEqualTo(Long value) {
            addCriterion("fkCommId >=", value, "fkcommid");
            return (Criteria) this;
        }

        public Criteria andFkcommidLessThan(Long value) {
            addCriterion("fkCommId <", value, "fkcommid");
            return (Criteria) this;
        }

        public Criteria andFkcommidLessThanOrEqualTo(Long value) {
            addCriterion("fkCommId <=", value, "fkcommid");
            return (Criteria) this;
        }

        public Criteria andFkcommidIn(List<Long> values) {
            addCriterion("fkCommId in", values, "fkcommid");
            return (Criteria) this;
        }

        public Criteria andFkcommidNotIn(List<Long> values) {
            addCriterion("fkCommId not in", values, "fkcommid");
            return (Criteria) this;
        }

        public Criteria andFkcommidBetween(Long value1, Long value2) {
            addCriterion("fkCommId between", value1, value2, "fkcommid");
            return (Criteria) this;
        }

        public Criteria andFkcommidNotBetween(Long value1, Long value2) {
            addCriterion("fkCommId not between", value1, value2, "fkcommid");
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

        public Criteria andSendtimeIsNull() {
            addCriterion("sendTime is null");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNotNull() {
            addCriterion("sendTime is not null");
            return (Criteria) this;
        }

        public Criteria andSendtimeEqualTo(Date value) {
            addCriterion("sendTime =", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotEqualTo(Date value) {
            addCriterion("sendTime <>", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThan(Date value) {
            addCriterion("sendTime >", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sendTime >=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThan(Date value) {
            addCriterion("sendTime <", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThanOrEqualTo(Date value) {
            addCriterion("sendTime <=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeIn(List<Date> values) {
            addCriterion("sendTime in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotIn(List<Date> values) {
            addCriterion("sendTime not in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeBetween(Date value1, Date value2) {
            addCriterion("sendTime between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotBetween(Date value1, Date value2) {
            addCriterion("sendTime not between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andReportnumIsNull() {
            addCriterion("reportNum is null");
            return (Criteria) this;
        }

        public Criteria andReportnumIsNotNull() {
            addCriterion("reportNum is not null");
            return (Criteria) this;
        }

        public Criteria andReportnumEqualTo(Long value) {
            addCriterion("reportNum =", value, "reportnum");
            return (Criteria) this;
        }

        public Criteria andReportnumNotEqualTo(Long value) {
            addCriterion("reportNum <>", value, "reportnum");
            return (Criteria) this;
        }

        public Criteria andReportnumGreaterThan(Long value) {
            addCriterion("reportNum >", value, "reportnum");
            return (Criteria) this;
        }

        public Criteria andReportnumGreaterThanOrEqualTo(Long value) {
            addCriterion("reportNum >=", value, "reportnum");
            return (Criteria) this;
        }

        public Criteria andReportnumLessThan(Long value) {
            addCriterion("reportNum <", value, "reportnum");
            return (Criteria) this;
        }

        public Criteria andReportnumLessThanOrEqualTo(Long value) {
            addCriterion("reportNum <=", value, "reportnum");
            return (Criteria) this;
        }

        public Criteria andReportnumIn(List<Long> values) {
            addCriterion("reportNum in", values, "reportnum");
            return (Criteria) this;
        }

        public Criteria andReportnumNotIn(List<Long> values) {
            addCriterion("reportNum not in", values, "reportnum");
            return (Criteria) this;
        }

        public Criteria andReportnumBetween(Long value1, Long value2) {
            addCriterion("reportNum between", value1, value2, "reportnum");
            return (Criteria) this;
        }

        public Criteria andReportnumNotBetween(Long value1, Long value2) {
            addCriterion("reportNum not between", value1, value2, "reportnum");
            return (Criteria) this;
        }

        public Criteria andLikenumIsNull() {
            addCriterion("likeNum is null");
            return (Criteria) this;
        }

        public Criteria andLikenumIsNotNull() {
            addCriterion("likeNum is not null");
            return (Criteria) this;
        }

        public Criteria andLikenumEqualTo(Long value) {
            addCriterion("likeNum =", value, "likenum");
            return (Criteria) this;
        }

        public Criteria andLikenumNotEqualTo(Long value) {
            addCriterion("likeNum <>", value, "likenum");
            return (Criteria) this;
        }

        public Criteria andLikenumGreaterThan(Long value) {
            addCriterion("likeNum >", value, "likenum");
            return (Criteria) this;
        }

        public Criteria andLikenumGreaterThanOrEqualTo(Long value) {
            addCriterion("likeNum >=", value, "likenum");
            return (Criteria) this;
        }

        public Criteria andLikenumLessThan(Long value) {
            addCriterion("likeNum <", value, "likenum");
            return (Criteria) this;
        }

        public Criteria andLikenumLessThanOrEqualTo(Long value) {
            addCriterion("likeNum <=", value, "likenum");
            return (Criteria) this;
        }

        public Criteria andLikenumIn(List<Long> values) {
            addCriterion("likeNum in", values, "likenum");
            return (Criteria) this;
        }

        public Criteria andLikenumNotIn(List<Long> values) {
            addCriterion("likeNum not in", values, "likenum");
            return (Criteria) this;
        }

        public Criteria andLikenumBetween(Long value1, Long value2) {
            addCriterion("likeNum between", value1, value2, "likenum");
            return (Criteria) this;
        }

        public Criteria andLikenumNotBetween(Long value1, Long value2) {
            addCriterion("likeNum not between", value1, value2, "likenum");
            return (Criteria) this;
        }

        public Criteria andHatenumIsNull() {
            addCriterion("hateNum is null");
            return (Criteria) this;
        }

        public Criteria andHatenumIsNotNull() {
            addCriterion("hateNum is not null");
            return (Criteria) this;
        }

        public Criteria andHatenumEqualTo(Long value) {
            addCriterion("hateNum =", value, "hatenum");
            return (Criteria) this;
        }

        public Criteria andHatenumNotEqualTo(Long value) {
            addCriterion("hateNum <>", value, "hatenum");
            return (Criteria) this;
        }

        public Criteria andHatenumGreaterThan(Long value) {
            addCriterion("hateNum >", value, "hatenum");
            return (Criteria) this;
        }

        public Criteria andHatenumGreaterThanOrEqualTo(Long value) {
            addCriterion("hateNum >=", value, "hatenum");
            return (Criteria) this;
        }

        public Criteria andHatenumLessThan(Long value) {
            addCriterion("hateNum <", value, "hatenum");
            return (Criteria) this;
        }

        public Criteria andHatenumLessThanOrEqualTo(Long value) {
            addCriterion("hateNum <=", value, "hatenum");
            return (Criteria) this;
        }

        public Criteria andHatenumIn(List<Long> values) {
            addCriterion("hateNum in", values, "hatenum");
            return (Criteria) this;
        }

        public Criteria andHatenumNotIn(List<Long> values) {
            addCriterion("hateNum not in", values, "hatenum");
            return (Criteria) this;
        }

        public Criteria andHatenumBetween(Long value1, Long value2) {
            addCriterion("hateNum between", value1, value2, "hatenum");
            return (Criteria) this;
        }

        public Criteria andHatenumNotBetween(Long value1, Long value2) {
            addCriterion("hateNum not between", value1, value2, "hatenum");
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