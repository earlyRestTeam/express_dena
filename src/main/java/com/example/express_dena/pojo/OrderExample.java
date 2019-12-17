package com.example.express_dena.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andOrdernoIsNull() {
            addCriterion("orderno is null");
            return (Criteria) this;
        }

        public Criteria andOrdernoIsNotNull() {
            addCriterion("orderno is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernoEqualTo(String value) {
            addCriterion("orderno =", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotEqualTo(String value) {
            addCriterion("orderno <>", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThan(String value) {
            addCriterion("orderno >", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThanOrEqualTo(String value) {
            addCriterion("orderno >=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThan(String value) {
            addCriterion("orderno <", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThanOrEqualTo(String value) {
            addCriterion("orderno <=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLike(String value) {
            addCriterion("orderno like", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotLike(String value) {
            addCriterion("orderno not like", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoIn(List<String> values) {
            addCriterion("orderno in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotIn(List<String> values) {
            addCriterion("orderno not in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoBetween(String value1, String value2) {
            addCriterion("orderno between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotBetween(String value1, String value2) {
            addCriterion("orderno not between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUserTelephoneIsNull() {
            addCriterion("user_telephone is null");
            return (Criteria) this;
        }

        public Criteria andUserTelephoneIsNotNull() {
            addCriterion("user_telephone is not null");
            return (Criteria) this;
        }

        public Criteria andUserTelephoneEqualTo(String value) {
            addCriterion("user_telephone =", value, "userTelephone");
            return (Criteria) this;
        }

        public Criteria andUserTelephoneNotEqualTo(String value) {
            addCriterion("user_telephone <>", value, "userTelephone");
            return (Criteria) this;
        }

        public Criteria andUserTelephoneGreaterThan(String value) {
            addCriterion("user_telephone >", value, "userTelephone");
            return (Criteria) this;
        }

        public Criteria andUserTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_telephone >=", value, "userTelephone");
            return (Criteria) this;
        }

        public Criteria andUserTelephoneLessThan(String value) {
            addCriterion("user_telephone <", value, "userTelephone");
            return (Criteria) this;
        }

        public Criteria andUserTelephoneLessThanOrEqualTo(String value) {
            addCriterion("user_telephone <=", value, "userTelephone");
            return (Criteria) this;
        }

        public Criteria andUserTelephoneLike(String value) {
            addCriterion("user_telephone like", value, "userTelephone");
            return (Criteria) this;
        }

        public Criteria andUserTelephoneNotLike(String value) {
            addCriterion("user_telephone not like", value, "userTelephone");
            return (Criteria) this;
        }

        public Criteria andUserTelephoneIn(List<String> values) {
            addCriterion("user_telephone in", values, "userTelephone");
            return (Criteria) this;
        }

        public Criteria andUserTelephoneNotIn(List<String> values) {
            addCriterion("user_telephone not in", values, "userTelephone");
            return (Criteria) this;
        }

        public Criteria andUserTelephoneBetween(String value1, String value2) {
            addCriterion("user_telephone between", value1, value2, "userTelephone");
            return (Criteria) this;
        }

        public Criteria andUserTelephoneNotBetween(String value1, String value2) {
            addCriterion("user_telephone not between", value1, value2, "userTelephone");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(Float value) {
            addCriterion("total_amount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(Float value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(Float value) {
            addCriterion("total_amount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(Float value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(Float value) {
            addCriterion("total_amount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(Float value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<Float> values) {
            addCriterion("total_amount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<Float> values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(Float value1, Float value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(Float value1, Float value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
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

        public Criteria andTargetAddressIsNull() {
            addCriterion("target_address is null");
            return (Criteria) this;
        }

        public Criteria andTargetAddressIsNotNull() {
            addCriterion("target_address is not null");
            return (Criteria) this;
        }

        public Criteria andTargetAddressEqualTo(String value) {
            addCriterion("target_address =", value, "targetAddress");
            return (Criteria) this;
        }

        public Criteria andTargetAddressNotEqualTo(String value) {
            addCriterion("target_address <>", value, "targetAddress");
            return (Criteria) this;
        }

        public Criteria andTargetAddressGreaterThan(String value) {
            addCriterion("target_address >", value, "targetAddress");
            return (Criteria) this;
        }

        public Criteria andTargetAddressGreaterThanOrEqualTo(String value) {
            addCriterion("target_address >=", value, "targetAddress");
            return (Criteria) this;
        }

        public Criteria andTargetAddressLessThan(String value) {
            addCriterion("target_address <", value, "targetAddress");
            return (Criteria) this;
        }

        public Criteria andTargetAddressLessThanOrEqualTo(String value) {
            addCriterion("target_address <=", value, "targetAddress");
            return (Criteria) this;
        }

        public Criteria andTargetAddressLike(String value) {
            addCriterion("target_address like", value, "targetAddress");
            return (Criteria) this;
        }

        public Criteria andTargetAddressNotLike(String value) {
            addCriterion("target_address not like", value, "targetAddress");
            return (Criteria) this;
        }

        public Criteria andTargetAddressIn(List<String> values) {
            addCriterion("target_address in", values, "targetAddress");
            return (Criteria) this;
        }

        public Criteria andTargetAddressNotIn(List<String> values) {
            addCriterion("target_address not in", values, "targetAddress");
            return (Criteria) this;
        }

        public Criteria andTargetAddressBetween(String value1, String value2) {
            addCriterion("target_address between", value1, value2, "targetAddress");
            return (Criteria) this;
        }

        public Criteria andTargetAddressNotBetween(String value1, String value2) {
            addCriterion("target_address not between", value1, value2, "targetAddress");
            return (Criteria) this;
        }

        public Criteria andCommentNumIsNull() {
            addCriterion("comment_num is null");
            return (Criteria) this;
        }

        public Criteria andCommentNumIsNotNull() {
            addCriterion("comment_num is not null");
            return (Criteria) this;
        }

        public Criteria andCommentNumEqualTo(Integer value) {
            addCriterion("comment_num =", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumNotEqualTo(Integer value) {
            addCriterion("comment_num <>", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumGreaterThan(Integer value) {
            addCriterion("comment_num >", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_num >=", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumLessThan(Integer value) {
            addCriterion("comment_num <", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumLessThanOrEqualTo(Integer value) {
            addCriterion("comment_num <=", value, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumIn(List<Integer> values) {
            addCriterion("comment_num in", values, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumNotIn(List<Integer> values) {
            addCriterion("comment_num not in", values, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumBetween(Integer value1, Integer value2) {
            addCriterion("comment_num between", value1, value2, "commentNum");
            return (Criteria) this;
        }

        public Criteria andCommentNumNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_num not between", value1, value2, "commentNum");
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

        public Criteria andHosermanidIsNull() {
            addCriterion("hosermanid is null");
            return (Criteria) this;
        }

        public Criteria andHosermanidIsNotNull() {
            addCriterion("hosermanid is not null");
            return (Criteria) this;
        }

        public Criteria andHosermanidEqualTo(Integer value) {
            addCriterion("hosermanid =", value, "hosermanid");
            return (Criteria) this;
        }

        public Criteria andHosermanidNotEqualTo(Integer value) {
            addCriterion("hosermanid <>", value, "hosermanid");
            return (Criteria) this;
        }

        public Criteria andHosermanidGreaterThan(Integer value) {
            addCriterion("hosermanid >", value, "hosermanid");
            return (Criteria) this;
        }

        public Criteria andHosermanidGreaterThanOrEqualTo(Integer value) {
            addCriterion("hosermanid >=", value, "hosermanid");
            return (Criteria) this;
        }

        public Criteria andHosermanidLessThan(Integer value) {
            addCriterion("hosermanid <", value, "hosermanid");
            return (Criteria) this;
        }

        public Criteria andHosermanidLessThanOrEqualTo(Integer value) {
            addCriterion("hosermanid <=", value, "hosermanid");
            return (Criteria) this;
        }

        public Criteria andHosermanidIn(List<Integer> values) {
            addCriterion("hosermanid in", values, "hosermanid");
            return (Criteria) this;
        }

        public Criteria andHosermanidNotIn(List<Integer> values) {
            addCriterion("hosermanid not in", values, "hosermanid");
            return (Criteria) this;
        }

        public Criteria andHosermanidBetween(Integer value1, Integer value2) {
            addCriterion("hosermanid between", value1, value2, "hosermanid");
            return (Criteria) this;
        }

        public Criteria andHosermanidNotBetween(Integer value1, Integer value2) {
            addCriterion("hosermanid not between", value1, value2, "hosermanid");
            return (Criteria) this;
        }

        public Criteria andPickUpTimeIsNull() {
            addCriterion("pick_up_time is null");
            return (Criteria) this;
        }

        public Criteria andPickUpTimeIsNotNull() {
            addCriterion("pick_up_time is not null");
            return (Criteria) this;
        }

        public Criteria andPickUpTimeEqualTo(Date value) {
            addCriterion("pick_up_time =", value, "pickUpTime");
            return (Criteria) this;
        }

        public Criteria andPickUpTimeNotEqualTo(Date value) {
            addCriterion("pick_up_time <>", value, "pickUpTime");
            return (Criteria) this;
        }

        public Criteria andPickUpTimeGreaterThan(Date value) {
            addCriterion("pick_up_time >", value, "pickUpTime");
            return (Criteria) this;
        }

        public Criteria andPickUpTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pick_up_time >=", value, "pickUpTime");
            return (Criteria) this;
        }

        public Criteria andPickUpTimeLessThan(Date value) {
            addCriterion("pick_up_time <", value, "pickUpTime");
            return (Criteria) this;
        }

        public Criteria andPickUpTimeLessThanOrEqualTo(Date value) {
            addCriterion("pick_up_time <=", value, "pickUpTime");
            return (Criteria) this;
        }

        public Criteria andPickUpTimeIn(List<Date> values) {
            addCriterion("pick_up_time in", values, "pickUpTime");
            return (Criteria) this;
        }

        public Criteria andPickUpTimeNotIn(List<Date> values) {
            addCriterion("pick_up_time not in", values, "pickUpTime");
            return (Criteria) this;
        }

        public Criteria andPickUpTimeBetween(Date value1, Date value2) {
            addCriterion("pick_up_time between", value1, value2, "pickUpTime");
            return (Criteria) this;
        }

        public Criteria andPickUpTimeNotBetween(Date value1, Date value2) {
            addCriterion("pick_up_time not between", value1, value2, "pickUpTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNull() {
            addCriterion("send_time is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("send_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(Date value) {
            addCriterion("send_time =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(Date value) {
            addCriterion("send_time <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(Date value) {
            addCriterion("send_time >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("send_time >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(Date value) {
            addCriterion("send_time <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("send_time <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<Date> values) {
            addCriterion("send_time in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<Date> values) {
            addCriterion("send_time not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(Date value1, Date value2) {
            addCriterion("send_time between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("send_time not between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andHosermainPhoneIsNull() {
            addCriterion("hosermain_phone is null");
            return (Criteria) this;
        }

        public Criteria andHosermainPhoneIsNotNull() {
            addCriterion("hosermain_phone is not null");
            return (Criteria) this;
        }

        public Criteria andHosermainPhoneEqualTo(String value) {
            addCriterion("hosermain_phone =", value, "hosermainPhone");
            return (Criteria) this;
        }

        public Criteria andHosermainPhoneNotEqualTo(String value) {
            addCriterion("hosermain_phone <>", value, "hosermainPhone");
            return (Criteria) this;
        }

        public Criteria andHosermainPhoneGreaterThan(String value) {
            addCriterion("hosermain_phone >", value, "hosermainPhone");
            return (Criteria) this;
        }

        public Criteria andHosermainPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("hosermain_phone >=", value, "hosermainPhone");
            return (Criteria) this;
        }

        public Criteria andHosermainPhoneLessThan(String value) {
            addCriterion("hosermain_phone <", value, "hosermainPhone");
            return (Criteria) this;
        }

        public Criteria andHosermainPhoneLessThanOrEqualTo(String value) {
            addCriterion("hosermain_phone <=", value, "hosermainPhone");
            return (Criteria) this;
        }

        public Criteria andHosermainPhoneLike(String value) {
            addCriterion("hosermain_phone like", value, "hosermainPhone");
            return (Criteria) this;
        }

        public Criteria andHosermainPhoneNotLike(String value) {
            addCriterion("hosermain_phone not like", value, "hosermainPhone");
            return (Criteria) this;
        }

        public Criteria andHosermainPhoneIn(List<String> values) {
            addCriterion("hosermain_phone in", values, "hosermainPhone");
            return (Criteria) this;
        }

        public Criteria andHosermainPhoneNotIn(List<String> values) {
            addCriterion("hosermain_phone not in", values, "hosermainPhone");
            return (Criteria) this;
        }

        public Criteria andHosermainPhoneBetween(String value1, String value2) {
            addCriterion("hosermain_phone between", value1, value2, "hosermainPhone");
            return (Criteria) this;
        }

        public Criteria andHosermainPhoneNotBetween(String value1, String value2) {
            addCriterion("hosermain_phone not between", value1, value2, "hosermainPhone");
            return (Criteria) this;
        }

        public Criteria andHosermanNameIsNull() {
            addCriterion("hoserman_name is null");
            return (Criteria) this;
        }

        public Criteria andHosermanNameIsNotNull() {
            addCriterion("hoserman_name is not null");
            return (Criteria) this;
        }

        public Criteria andHosermanNameEqualTo(String value) {
            addCriterion("hoserman_name =", value, "hosermanName");
            return (Criteria) this;
        }

        public Criteria andHosermanNameNotEqualTo(String value) {
            addCriterion("hoserman_name <>", value, "hosermanName");
            return (Criteria) this;
        }

        public Criteria andHosermanNameGreaterThan(String value) {
            addCriterion("hoserman_name >", value, "hosermanName");
            return (Criteria) this;
        }

        public Criteria andHosermanNameGreaterThanOrEqualTo(String value) {
            addCriterion("hoserman_name >=", value, "hosermanName");
            return (Criteria) this;
        }

        public Criteria andHosermanNameLessThan(String value) {
            addCriterion("hoserman_name <", value, "hosermanName");
            return (Criteria) this;
        }

        public Criteria andHosermanNameLessThanOrEqualTo(String value) {
            addCriterion("hoserman_name <=", value, "hosermanName");
            return (Criteria) this;
        }

        public Criteria andHosermanNameLike(String value) {
            addCriterion("hoserman_name like", value, "hosermanName");
            return (Criteria) this;
        }

        public Criteria andHosermanNameNotLike(String value) {
            addCriterion("hoserman_name not like", value, "hosermanName");
            return (Criteria) this;
        }

        public Criteria andHosermanNameIn(List<String> values) {
            addCriterion("hoserman_name in", values, "hosermanName");
            return (Criteria) this;
        }

        public Criteria andHosermanNameNotIn(List<String> values) {
            addCriterion("hoserman_name not in", values, "hosermanName");
            return (Criteria) this;
        }

        public Criteria andHosermanNameBetween(String value1, String value2) {
            addCriterion("hoserman_name between", value1, value2, "hosermanName");
            return (Criteria) this;
        }

        public Criteria andHosermanNameNotBetween(String value1, String value2) {
            addCriterion("hoserman_name not between", value1, value2, "hosermanName");
            return (Criteria) this;
        }

        public Criteria andShowHosemanStatusIsNull() {
            addCriterion("show_hoseman_status is null");
            return (Criteria) this;
        }

        public Criteria andShowHosemanStatusIsNotNull() {
            addCriterion("show_hoseman_status is not null");
            return (Criteria) this;
        }

        public Criteria andShowHosemanStatusEqualTo(Integer value) {
            addCriterion("show_hoseman_status =", value, "showHosemanStatus");
            return (Criteria) this;
        }

        public Criteria andShowHosemanStatusNotEqualTo(Integer value) {
            addCriterion("show_hoseman_status <>", value, "showHosemanStatus");
            return (Criteria) this;
        }

        public Criteria andShowHosemanStatusGreaterThan(Integer value) {
            addCriterion("show_hoseman_status >", value, "showHosemanStatus");
            return (Criteria) this;
        }

        public Criteria andShowHosemanStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_hoseman_status >=", value, "showHosemanStatus");
            return (Criteria) this;
        }

        public Criteria andShowHosemanStatusLessThan(Integer value) {
            addCriterion("show_hoseman_status <", value, "showHosemanStatus");
            return (Criteria) this;
        }

        public Criteria andShowHosemanStatusLessThanOrEqualTo(Integer value) {
            addCriterion("show_hoseman_status <=", value, "showHosemanStatus");
            return (Criteria) this;
        }

        public Criteria andShowHosemanStatusIn(List<Integer> values) {
            addCriterion("show_hoseman_status in", values, "showHosemanStatus");
            return (Criteria) this;
        }

        public Criteria andShowHosemanStatusNotIn(List<Integer> values) {
            addCriterion("show_hoseman_status not in", values, "showHosemanStatus");
            return (Criteria) this;
        }

        public Criteria andShowHosemanStatusBetween(Integer value1, Integer value2) {
            addCriterion("show_hoseman_status between", value1, value2, "showHosemanStatus");
            return (Criteria) this;
        }

        public Criteria andShowHosemanStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("show_hoseman_status not between", value1, value2, "showHosemanStatus");
            return (Criteria) this;
        }

        public Criteria andShowuserstatusIsNull() {
            addCriterion("showUserstatus is null");
            return (Criteria) this;
        }

        public Criteria andShowuserstatusIsNotNull() {
            addCriterion("showUserstatus is not null");
            return (Criteria) this;
        }

        public Criteria andShowuserstatusEqualTo(Integer value) {
            addCriterion("showUserstatus =", value, "showuserstatus");
            return (Criteria) this;
        }

        public Criteria andShowuserstatusNotEqualTo(Integer value) {
            addCriterion("showUserstatus <>", value, "showuserstatus");
            return (Criteria) this;
        }

        public Criteria andShowuserstatusGreaterThan(Integer value) {
            addCriterion("showUserstatus >", value, "showuserstatus");
            return (Criteria) this;
        }

        public Criteria andShowuserstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("showUserstatus >=", value, "showuserstatus");
            return (Criteria) this;
        }

        public Criteria andShowuserstatusLessThan(Integer value) {
            addCriterion("showUserstatus <", value, "showuserstatus");
            return (Criteria) this;
        }

        public Criteria andShowuserstatusLessThanOrEqualTo(Integer value) {
            addCriterion("showUserstatus <=", value, "showuserstatus");
            return (Criteria) this;
        }

        public Criteria andShowuserstatusIn(List<Integer> values) {
            addCriterion("showUserstatus in", values, "showuserstatus");
            return (Criteria) this;
        }

        public Criteria andShowuserstatusNotIn(List<Integer> values) {
            addCriterion("showUserstatus not in", values, "showuserstatus");
            return (Criteria) this;
        }

        public Criteria andShowuserstatusBetween(Integer value1, Integer value2) {
            addCriterion("showUserstatus between", value1, value2, "showuserstatus");
            return (Criteria) this;
        }

        public Criteria andShowuserstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("showUserstatus not between", value1, value2, "showuserstatus");
            return (Criteria) this;
        }

        public Criteria andComfirmUserStatusIsNull() {
            addCriterion("comfirm_user_status is null");
            return (Criteria) this;
        }

        public Criteria andComfirmUserStatusIsNotNull() {
            addCriterion("comfirm_user_status is not null");
            return (Criteria) this;
        }

        public Criteria andComfirmUserStatusEqualTo(Integer value) {
            addCriterion("comfirm_user_status =", value, "comfirmUserStatus");
            return (Criteria) this;
        }

        public Criteria andComfirmUserStatusNotEqualTo(Integer value) {
            addCriterion("comfirm_user_status <>", value, "comfirmUserStatus");
            return (Criteria) this;
        }

        public Criteria andComfirmUserStatusGreaterThan(Integer value) {
            addCriterion("comfirm_user_status >", value, "comfirmUserStatus");
            return (Criteria) this;
        }

        public Criteria andComfirmUserStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("comfirm_user_status >=", value, "comfirmUserStatus");
            return (Criteria) this;
        }

        public Criteria andComfirmUserStatusLessThan(Integer value) {
            addCriterion("comfirm_user_status <", value, "comfirmUserStatus");
            return (Criteria) this;
        }

        public Criteria andComfirmUserStatusLessThanOrEqualTo(Integer value) {
            addCriterion("comfirm_user_status <=", value, "comfirmUserStatus");
            return (Criteria) this;
        }

        public Criteria andComfirmUserStatusIn(List<Integer> values) {
            addCriterion("comfirm_user_status in", values, "comfirmUserStatus");
            return (Criteria) this;
        }

        public Criteria andComfirmUserStatusNotIn(List<Integer> values) {
            addCriterion("comfirm_user_status not in", values, "comfirmUserStatus");
            return (Criteria) this;
        }

        public Criteria andComfirmUserStatusBetween(Integer value1, Integer value2) {
            addCriterion("comfirm_user_status between", value1, value2, "comfirmUserStatus");
            return (Criteria) this;
        }

        public Criteria andComfirmUserStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("comfirm_user_status not between", value1, value2, "comfirmUserStatus");
            return (Criteria) this;
        }

        public Criteria andComfirmHosemanStatusIsNull() {
            addCriterion("comfirm_hoseman_status is null");
            return (Criteria) this;
        }

        public Criteria andComfirmHosemanStatusIsNotNull() {
            addCriterion("comfirm_hoseman_status is not null");
            return (Criteria) this;
        }

        public Criteria andComfirmHosemanStatusEqualTo(Integer value) {
            addCriterion("comfirm_hoseman_status =", value, "comfirmHosemanStatus");
            return (Criteria) this;
        }

        public Criteria andComfirmHosemanStatusNotEqualTo(Integer value) {
            addCriterion("comfirm_hoseman_status <>", value, "comfirmHosemanStatus");
            return (Criteria) this;
        }

        public Criteria andComfirmHosemanStatusGreaterThan(Integer value) {
            addCriterion("comfirm_hoseman_status >", value, "comfirmHosemanStatus");
            return (Criteria) this;
        }

        public Criteria andComfirmHosemanStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("comfirm_hoseman_status >=", value, "comfirmHosemanStatus");
            return (Criteria) this;
        }

        public Criteria andComfirmHosemanStatusLessThan(Integer value) {
            addCriterion("comfirm_hoseman_status <", value, "comfirmHosemanStatus");
            return (Criteria) this;
        }

        public Criteria andComfirmHosemanStatusLessThanOrEqualTo(Integer value) {
            addCriterion("comfirm_hoseman_status <=", value, "comfirmHosemanStatus");
            return (Criteria) this;
        }

        public Criteria andComfirmHosemanStatusIn(List<Integer> values) {
            addCriterion("comfirm_hoseman_status in", values, "comfirmHosemanStatus");
            return (Criteria) this;
        }

        public Criteria andComfirmHosemanStatusNotIn(List<Integer> values) {
            addCriterion("comfirm_hoseman_status not in", values, "comfirmHosemanStatus");
            return (Criteria) this;
        }

        public Criteria andComfirmHosemanStatusBetween(Integer value1, Integer value2) {
            addCriterion("comfirm_hoseman_status between", value1, value2, "comfirmHosemanStatus");
            return (Criteria) this;
        }

        public Criteria andComfirmHosemanStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("comfirm_hoseman_status not between", value1, value2, "comfirmHosemanStatus");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
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