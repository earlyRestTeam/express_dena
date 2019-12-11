package com.example.express_dena.pojo;

import java.util.ArrayList;
import java.util.List;

public class WithdrawalsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WithdrawalsExample() {
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

        public Criteria andWithdrawalsBalanceIsNull() {
            addCriterion("withdrawals_balance is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsBalanceIsNotNull() {
            addCriterion("withdrawals_balance is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsBalanceEqualTo(Float value) {
            addCriterion("withdrawals_balance =", value, "withdrawalsBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsBalanceNotEqualTo(Float value) {
            addCriterion("withdrawals_balance <>", value, "withdrawalsBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsBalanceGreaterThan(Float value) {
            addCriterion("withdrawals_balance >", value, "withdrawalsBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsBalanceGreaterThanOrEqualTo(Float value) {
            addCriterion("withdrawals_balance >=", value, "withdrawalsBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsBalanceLessThan(Float value) {
            addCriterion("withdrawals_balance <", value, "withdrawalsBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsBalanceLessThanOrEqualTo(Float value) {
            addCriterion("withdrawals_balance <=", value, "withdrawalsBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsBalanceIn(List<Float> values) {
            addCriterion("withdrawals_balance in", values, "withdrawalsBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsBalanceNotIn(List<Float> values) {
            addCriterion("withdrawals_balance not in", values, "withdrawalsBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsBalanceBetween(Float value1, Float value2) {
            addCriterion("withdrawals_balance between", value1, value2, "withdrawalsBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawalsBalanceNotBetween(Float value1, Float value2) {
            addCriterion("withdrawals_balance not between", value1, value2, "withdrawalsBalance");
            return (Criteria) this;
        }

        public Criteria andHorsemanidIsNull() {
            addCriterion("horsemanid is null");
            return (Criteria) this;
        }

        public Criteria andHorsemanidIsNotNull() {
            addCriterion("horsemanid is not null");
            return (Criteria) this;
        }

        public Criteria andHorsemanidEqualTo(Integer value) {
            addCriterion("horsemanid =", value, "horsemanid");
            return (Criteria) this;
        }

        public Criteria andHorsemanidNotEqualTo(Integer value) {
            addCriterion("horsemanid <>", value, "horsemanid");
            return (Criteria) this;
        }

        public Criteria andHorsemanidGreaterThan(Integer value) {
            addCriterion("horsemanid >", value, "horsemanid");
            return (Criteria) this;
        }

        public Criteria andHorsemanidGreaterThanOrEqualTo(Integer value) {
            addCriterion("horsemanid >=", value, "horsemanid");
            return (Criteria) this;
        }

        public Criteria andHorsemanidLessThan(Integer value) {
            addCriterion("horsemanid <", value, "horsemanid");
            return (Criteria) this;
        }

        public Criteria andHorsemanidLessThanOrEqualTo(Integer value) {
            addCriterion("horsemanid <=", value, "horsemanid");
            return (Criteria) this;
        }

        public Criteria andHorsemanidIn(List<Integer> values) {
            addCriterion("horsemanid in", values, "horsemanid");
            return (Criteria) this;
        }

        public Criteria andHorsemanidNotIn(List<Integer> values) {
            addCriterion("horsemanid not in", values, "horsemanid");
            return (Criteria) this;
        }

        public Criteria andHorsemanidBetween(Integer value1, Integer value2) {
            addCriterion("horsemanid between", value1, value2, "horsemanid");
            return (Criteria) this;
        }

        public Criteria andHorsemanidNotBetween(Integer value1, Integer value2) {
            addCriterion("horsemanid not between", value1, value2, "horsemanid");
            return (Criteria) this;
        }

        public Criteria andAccountsIsNull() {
            addCriterion("accounts is null");
            return (Criteria) this;
        }

        public Criteria andAccountsIsNotNull() {
            addCriterion("accounts is not null");
            return (Criteria) this;
        }

        public Criteria andAccountsEqualTo(String value) {
            addCriterion("accounts =", value, "accounts");
            return (Criteria) this;
        }

        public Criteria andAccountsNotEqualTo(String value) {
            addCriterion("accounts <>", value, "accounts");
            return (Criteria) this;
        }

        public Criteria andAccountsGreaterThan(String value) {
            addCriterion("accounts >", value, "accounts");
            return (Criteria) this;
        }

        public Criteria andAccountsGreaterThanOrEqualTo(String value) {
            addCriterion("accounts >=", value, "accounts");
            return (Criteria) this;
        }

        public Criteria andAccountsLessThan(String value) {
            addCriterion("accounts <", value, "accounts");
            return (Criteria) this;
        }

        public Criteria andAccountsLessThanOrEqualTo(String value) {
            addCriterion("accounts <=", value, "accounts");
            return (Criteria) this;
        }

        public Criteria andAccountsLike(String value) {
            addCriterion("accounts like", value, "accounts");
            return (Criteria) this;
        }

        public Criteria andAccountsNotLike(String value) {
            addCriterion("accounts not like", value, "accounts");
            return (Criteria) this;
        }

        public Criteria andAccountsIn(List<String> values) {
            addCriterion("accounts in", values, "accounts");
            return (Criteria) this;
        }

        public Criteria andAccountsNotIn(List<String> values) {
            addCriterion("accounts not in", values, "accounts");
            return (Criteria) this;
        }

        public Criteria andAccountsBetween(String value1, String value2) {
            addCriterion("accounts between", value1, value2, "accounts");
            return (Criteria) this;
        }

        public Criteria andAccountsNotBetween(String value1, String value2) {
            addCriterion("accounts not between", value1, value2, "accounts");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
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