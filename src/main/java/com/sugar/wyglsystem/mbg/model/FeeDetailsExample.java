package com.sugar.wyglsystem.mbg.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FeeDetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FeeDetailsExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFeeIdIsNull() {
            addCriterion("fee_id is null");
            return (Criteria) this;
        }

        public Criteria andFeeIdIsNotNull() {
            addCriterion("fee_id is not null");
            return (Criteria) this;
        }

        public Criteria andFeeIdEqualTo(Long value) {
            addCriterion("fee_id =", value, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdNotEqualTo(Long value) {
            addCriterion("fee_id <>", value, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdGreaterThan(Long value) {
            addCriterion("fee_id >", value, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("fee_id >=", value, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdLessThan(Long value) {
            addCriterion("fee_id <", value, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdLessThanOrEqualTo(Long value) {
            addCriterion("fee_id <=", value, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdIn(List<Long> values) {
            addCriterion("fee_id in", values, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdNotIn(List<Long> values) {
            addCriterion("fee_id not in", values, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdBetween(Long value1, Long value2) {
            addCriterion("fee_id between", value1, value2, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdNotBetween(Long value1, Long value2) {
            addCriterion("fee_id not between", value1, value2, "feeId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNull() {
            addCriterion("room_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNotNull() {
            addCriterion("room_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomIdEqualTo(Long value) {
            addCriterion("room_id =", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotEqualTo(Long value) {
            addCriterion("room_id <>", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThan(Long value) {
            addCriterion("room_id >", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThanOrEqualTo(Long value) {
            addCriterion("room_id >=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThan(Long value) {
            addCriterion("room_id <", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThanOrEqualTo(Long value) {
            addCriterion("room_id <=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIn(List<Long> values) {
            addCriterion("room_id in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotIn(List<Long> values) {
            addCriterion("room_id not in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdBetween(Long value1, Long value2) {
            addCriterion("room_id between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotBetween(Long value1, Long value2) {
            addCriterion("room_id not between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andCyclesIsNull() {
            addCriterion("cycles is null");
            return (Criteria) this;
        }

        public Criteria andCyclesIsNotNull() {
            addCriterion("cycles is not null");
            return (Criteria) this;
        }

        public Criteria andCyclesEqualTo(Integer value) {
            addCriterion("cycles =", value, "cycles");
            return (Criteria) this;
        }

        public Criteria andCyclesNotEqualTo(Integer value) {
            addCriterion("cycles <>", value, "cycles");
            return (Criteria) this;
        }

        public Criteria andCyclesGreaterThan(Integer value) {
            addCriterion("cycles >", value, "cycles");
            return (Criteria) this;
        }

        public Criteria andCyclesGreaterThanOrEqualTo(Integer value) {
            addCriterion("cycles >=", value, "cycles");
            return (Criteria) this;
        }

        public Criteria andCyclesLessThan(Integer value) {
            addCriterion("cycles <", value, "cycles");
            return (Criteria) this;
        }

        public Criteria andCyclesLessThanOrEqualTo(Integer value) {
            addCriterion("cycles <=", value, "cycles");
            return (Criteria) this;
        }

        public Criteria andCyclesIn(List<Integer> values) {
            addCriterion("cycles in", values, "cycles");
            return (Criteria) this;
        }

        public Criteria andCyclesNotIn(List<Integer> values) {
            addCriterion("cycles not in", values, "cycles");
            return (Criteria) this;
        }

        public Criteria andCyclesBetween(Integer value1, Integer value2) {
            addCriterion("cycles between", value1, value2, "cycles");
            return (Criteria) this;
        }

        public Criteria andCyclesNotBetween(Integer value1, Integer value2) {
            addCriterion("cycles not between", value1, value2, "cycles");
            return (Criteria) this;
        }

        public Criteria andReceivableAmountIsNull() {
            addCriterion("receivable_amount is null");
            return (Criteria) this;
        }

        public Criteria andReceivableAmountIsNotNull() {
            addCriterion("receivable_amount is not null");
            return (Criteria) this;
        }

        public Criteria andReceivableAmountEqualTo(BigDecimal value) {
            addCriterion("receivable_amount =", value, "receivableAmount");
            return (Criteria) this;
        }

        public Criteria andReceivableAmountNotEqualTo(BigDecimal value) {
            addCriterion("receivable_amount <>", value, "receivableAmount");
            return (Criteria) this;
        }

        public Criteria andReceivableAmountGreaterThan(BigDecimal value) {
            addCriterion("receivable_amount >", value, "receivableAmount");
            return (Criteria) this;
        }

        public Criteria andReceivableAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("receivable_amount >=", value, "receivableAmount");
            return (Criteria) this;
        }

        public Criteria andReceivableAmountLessThan(BigDecimal value) {
            addCriterion("receivable_amount <", value, "receivableAmount");
            return (Criteria) this;
        }

        public Criteria andReceivableAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("receivable_amount <=", value, "receivableAmount");
            return (Criteria) this;
        }

        public Criteria andReceivableAmountIn(List<BigDecimal> values) {
            addCriterion("receivable_amount in", values, "receivableAmount");
            return (Criteria) this;
        }

        public Criteria andReceivableAmountNotIn(List<BigDecimal> values) {
            addCriterion("receivable_amount not in", values, "receivableAmount");
            return (Criteria) this;
        }

        public Criteria andReceivableAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("receivable_amount between", value1, value2, "receivableAmount");
            return (Criteria) this;
        }

        public Criteria andReceivableAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("receivable_amount not between", value1, value2, "receivableAmount");
            return (Criteria) this;
        }

        public Criteria andReceivedAmountIsNull() {
            addCriterion("received_amount is null");
            return (Criteria) this;
        }

        public Criteria andReceivedAmountIsNotNull() {
            addCriterion("received_amount is not null");
            return (Criteria) this;
        }

        public Criteria andReceivedAmountEqualTo(BigDecimal value) {
            addCriterion("received_amount =", value, "receivedAmount");
            return (Criteria) this;
        }

        public Criteria andReceivedAmountNotEqualTo(BigDecimal value) {
            addCriterion("received_amount <>", value, "receivedAmount");
            return (Criteria) this;
        }

        public Criteria andReceivedAmountGreaterThan(BigDecimal value) {
            addCriterion("received_amount >", value, "receivedAmount");
            return (Criteria) this;
        }

        public Criteria andReceivedAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("received_amount >=", value, "receivedAmount");
            return (Criteria) this;
        }

        public Criteria andReceivedAmountLessThan(BigDecimal value) {
            addCriterion("received_amount <", value, "receivedAmount");
            return (Criteria) this;
        }

        public Criteria andReceivedAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("received_amount <=", value, "receivedAmount");
            return (Criteria) this;
        }

        public Criteria andReceivedAmountIn(List<BigDecimal> values) {
            addCriterion("received_amount in", values, "receivedAmount");
            return (Criteria) this;
        }

        public Criteria andReceivedAmountNotIn(List<BigDecimal> values) {
            addCriterion("received_amount not in", values, "receivedAmount");
            return (Criteria) this;
        }

        public Criteria andReceivedAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("received_amount between", value1, value2, "receivedAmount");
            return (Criteria) this;
        }

        public Criteria andReceivedAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("received_amount not between", value1, value2, "receivedAmount");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

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