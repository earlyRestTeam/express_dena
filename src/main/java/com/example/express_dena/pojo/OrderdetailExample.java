package com.example.express_dena.pojo;

import java.util.ArrayList;
import java.util.List;

public class OrderdetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderdetailExample() {
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

        public Criteria andOrderidIsNull() {
            addCriterion("orderid is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(Integer value) {
            addCriterion("orderid =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(Integer value) {
            addCriterion("orderid <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(Integer value) {
            addCriterion("orderid >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderid >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(Integer value) {
            addCriterion("orderid <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(Integer value) {
            addCriterion("orderid <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<Integer> values) {
            addCriterion("orderid in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<Integer> values) {
            addCriterion("orderid not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(Integer value1, Integer value2) {
            addCriterion("orderid between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(Integer value1, Integer value2) {
            addCriterion("orderid not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(Float value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(Float value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(Float value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(Float value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(Float value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(Float value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<Float> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<Float> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(Float value1, Float value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(Float value1, Float value2) {
            addCriterion("balance not between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andKgIsNull() {
            addCriterion("kg is null");
            return (Criteria) this;
        }

        public Criteria andKgIsNotNull() {
            addCriterion("kg is not null");
            return (Criteria) this;
        }

        public Criteria andKgEqualTo(Float value) {
            addCriterion("kg =", value, "kg");
            return (Criteria) this;
        }

        public Criteria andKgNotEqualTo(Float value) {
            addCriterion("kg <>", value, "kg");
            return (Criteria) this;
        }

        public Criteria andKgGreaterThan(Float value) {
            addCriterion("kg >", value, "kg");
            return (Criteria) this;
        }

        public Criteria andKgGreaterThanOrEqualTo(Float value) {
            addCriterion("kg >=", value, "kg");
            return (Criteria) this;
        }

        public Criteria andKgLessThan(Float value) {
            addCriterion("kg <", value, "kg");
            return (Criteria) this;
        }

        public Criteria andKgLessThanOrEqualTo(Float value) {
            addCriterion("kg <=", value, "kg");
            return (Criteria) this;
        }

        public Criteria andKgIn(List<Float> values) {
            addCriterion("kg in", values, "kg");
            return (Criteria) this;
        }

        public Criteria andKgNotIn(List<Float> values) {
            addCriterion("kg not in", values, "kg");
            return (Criteria) this;
        }

        public Criteria andKgBetween(Float value1, Float value2) {
            addCriterion("kg between", value1, value2, "kg");
            return (Criteria) this;
        }

        public Criteria andKgNotBetween(Float value1, Float value2) {
            addCriterion("kg not between", value1, value2, "kg");
            return (Criteria) this;
        }

        public Criteria andPickUpCodeIsNull() {
            addCriterion("pick_up_code is null");
            return (Criteria) this;
        }

        public Criteria andPickUpCodeIsNotNull() {
            addCriterion("pick_up_code is not null");
            return (Criteria) this;
        }

        public Criteria andPickUpCodeEqualTo(String value) {
            addCriterion("pick_up_code =", value, "pickUpCode");
            return (Criteria) this;
        }

        public Criteria andPickUpCodeNotEqualTo(String value) {
            addCriterion("pick_up_code <>", value, "pickUpCode");
            return (Criteria) this;
        }

        public Criteria andPickUpCodeGreaterThan(String value) {
            addCriterion("pick_up_code >", value, "pickUpCode");
            return (Criteria) this;
        }

        public Criteria andPickUpCodeGreaterThanOrEqualTo(String value) {
            addCriterion("pick_up_code >=", value, "pickUpCode");
            return (Criteria) this;
        }

        public Criteria andPickUpCodeLessThan(String value) {
            addCriterion("pick_up_code <", value, "pickUpCode");
            return (Criteria) this;
        }

        public Criteria andPickUpCodeLessThanOrEqualTo(String value) {
            addCriterion("pick_up_code <=", value, "pickUpCode");
            return (Criteria) this;
        }

        public Criteria andPickUpCodeLike(String value) {
            addCriterion("pick_up_code like", value, "pickUpCode");
            return (Criteria) this;
        }

        public Criteria andPickUpCodeNotLike(String value) {
            addCriterion("pick_up_code not like", value, "pickUpCode");
            return (Criteria) this;
        }

        public Criteria andPickUpCodeIn(List<String> values) {
            addCriterion("pick_up_code in", values, "pickUpCode");
            return (Criteria) this;
        }

        public Criteria andPickUpCodeNotIn(List<String> values) {
            addCriterion("pick_up_code not in", values, "pickUpCode");
            return (Criteria) this;
        }

        public Criteria andPickUpCodeBetween(String value1, String value2) {
            addCriterion("pick_up_code between", value1, value2, "pickUpCode");
            return (Criteria) this;
        }

        public Criteria andPickUpCodeNotBetween(String value1, String value2) {
            addCriterion("pick_up_code not between", value1, value2, "pickUpCode");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressIsNull() {
            addCriterion("pick_up_address is null");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressIsNotNull() {
            addCriterion("pick_up_address is not null");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressEqualTo(String value) {
            addCriterion("pick_up_address =", value, "pickUpAddress");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressNotEqualTo(String value) {
            addCriterion("pick_up_address <>", value, "pickUpAddress");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressGreaterThan(String value) {
            addCriterion("pick_up_address >", value, "pickUpAddress");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressGreaterThanOrEqualTo(String value) {
            addCriterion("pick_up_address >=", value, "pickUpAddress");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressLessThan(String value) {
            addCriterion("pick_up_address <", value, "pickUpAddress");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressLessThanOrEqualTo(String value) {
            addCriterion("pick_up_address <=", value, "pickUpAddress");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressLike(String value) {
            addCriterion("pick_up_address like", value, "pickUpAddress");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressNotLike(String value) {
            addCriterion("pick_up_address not like", value, "pickUpAddress");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressIn(List<String> values) {
            addCriterion("pick_up_address in", values, "pickUpAddress");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressNotIn(List<String> values) {
            addCriterion("pick_up_address not in", values, "pickUpAddress");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressBetween(String value1, String value2) {
            addCriterion("pick_up_address between", value1, value2, "pickUpAddress");
            return (Criteria) this;
        }

        public Criteria andPickUpAddressNotBetween(String value1, String value2) {
            addCriterion("pick_up_address not between", value1, value2, "pickUpAddress");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyIsNull() {
            addCriterion("courier_company is null");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyIsNotNull() {
            addCriterion("courier_company is not null");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyEqualTo(String value) {
            addCriterion("courier_company =", value, "courierCompany");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyNotEqualTo(String value) {
            addCriterion("courier_company <>", value, "courierCompany");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyGreaterThan(String value) {
            addCriterion("courier_company >", value, "courierCompany");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("courier_company >=", value, "courierCompany");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyLessThan(String value) {
            addCriterion("courier_company <", value, "courierCompany");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyLessThanOrEqualTo(String value) {
            addCriterion("courier_company <=", value, "courierCompany");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyLike(String value) {
            addCriterion("courier_company like", value, "courierCompany");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyNotLike(String value) {
            addCriterion("courier_company not like", value, "courierCompany");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyIn(List<String> values) {
            addCriterion("courier_company in", values, "courierCompany");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyNotIn(List<String> values) {
            addCriterion("courier_company not in", values, "courierCompany");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyBetween(String value1, String value2) {
            addCriterion("courier_company between", value1, value2, "courierCompany");
            return (Criteria) this;
        }

        public Criteria andCourierCompanyNotBetween(String value1, String value2) {
            addCriterion("courier_company not between", value1, value2, "courierCompany");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNull() {
            addCriterion("remark1 is null");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNotNull() {
            addCriterion("remark1 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark1EqualTo(String value) {
            addCriterion("remark1 =", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotEqualTo(String value) {
            addCriterion("remark1 <>", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThan(String value) {
            addCriterion("remark1 >", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            addCriterion("remark1 >=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThan(String value) {
            addCriterion("remark1 <", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            addCriterion("remark1 <=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Like(String value) {
            addCriterion("remark1 like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotLike(String value) {
            addCriterion("remark1 not like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1In(List<String> values) {
            addCriterion("remark1 in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotIn(List<String> values) {
            addCriterion("remark1 not in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Between(String value1, String value2) {
            addCriterion("remark1 between", value1, value2, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            addCriterion("remark1 not between", value1, value2, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark2IsNull() {
            addCriterion("remark2 is null");
            return (Criteria) this;
        }

        public Criteria andRemark2IsNotNull() {
            addCriterion("remark2 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark2EqualTo(String value) {
            addCriterion("remark2 =", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotEqualTo(String value) {
            addCriterion("remark2 <>", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2GreaterThan(String value) {
            addCriterion("remark2 >", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2GreaterThanOrEqualTo(String value) {
            addCriterion("remark2 >=", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2LessThan(String value) {
            addCriterion("remark2 <", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2LessThanOrEqualTo(String value) {
            addCriterion("remark2 <=", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2Like(String value) {
            addCriterion("remark2 like", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotLike(String value) {
            addCriterion("remark2 not like", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2In(List<String> values) {
            addCriterion("remark2 in", values, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotIn(List<String> values) {
            addCriterion("remark2 not in", values, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2Between(String value1, String value2) {
            addCriterion("remark2 between", value1, value2, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotBetween(String value1, String value2) {
            addCriterion("remark2 not between", value1, value2, "remark2");
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